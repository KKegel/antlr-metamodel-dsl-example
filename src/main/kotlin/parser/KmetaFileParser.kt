/**
 * Copyright 2026 Karl Kegel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package parser

import kmeta.*
import org.antlr.v4.runtime.CharStreams
import org.antlr.v4.runtime.CommonTokenStream
import java.io.File

/**
 * Parser for KMeta DSL files using ANTLR-generated parser classes.
 */
class KmetaFileParser {

    /**
     * Parses a KMeta metamodel from a file.
     *
     * @param filePath The path to the KMeta file to parse.
     * @return The parsed metamodel structure.
     */
    fun parseFile(filePath: String): KmetaFile {
        val file = File(filePath)
        return parseString(file.readText())
    }

    /**
     * Parses a KMeta metamodel from a string.
     *
     * @param content The KMeta content as a string.
     * @return The parsed metamodel structure.
     */
    fun parseString(content: String): KmetaFile {
        val inputStream = CharStreams.fromString(content)
        val lexer = KmetaLexer(inputStream)
        val tokens = CommonTokenStream(lexer)
        val parser = KmetaParser(tokens)

        val parseTree = parser.kmeta_file()
        val visitor = KmetaParseVisitor()

        return visitor.visit(parseTree) ?: KmetaFile(emptyList())
    }
}

class KmetaParseVisitor : KmetaBaseVisitor<KmetaFile>() {
    private val typeDefinitions = mutableListOf<TypeDefinition>()

    override fun visitKmeta_file(ctx: KmetaParser.Kmeta_fileContext): KmetaFile {
        for (typeDefCtx in ctx.type_definition()) {
            typeDefinitions.add(visitTypeDefinition(typeDefCtx))
        }
        return KmetaFile(typeDefinitions)
    }

    private fun visitTypeDefinition(ctx: KmetaParser.Type_definitionContext): TypeDefinition {
        val typeName = ctx.STRING(0).text.trim('"')
        val typeDescription = ctx.STRING(1).text.trim('"')
        val typeDef = TypeDefinition(typeName, typeDescription)

        val ruleListCtx = ctx.rule_list()
        if (ruleListCtx != null) {
            for (ruleCtx in ruleListCtx.rule_()) {
                when {
                    ruleCtx.prop_rule() != null -> {
                        val propCtx = ruleCtx.prop_rule()
                        val key = propCtx.STRING().text.trim('"')
                        val value = parseRuleValue(propCtx.rule_value())
                        typeDef.addProp(key, value)
                    }
                    ruleCtx.has_rule() != null -> {
                        val hasCtx = ruleCtx.has_rule()
                        val key = hasCtx.STRING().text.trim('"')
                        val value = parseRuleValue(hasCtx.rule_value())
                        typeDef.addHas(key, value)
                    }
                    ruleCtx.knows_rule() != null -> {
                        val knowsCtx = ruleCtx.knows_rule()
                        val key = knowsCtx.STRING().text.trim('"')
                        val value = parseRuleValue(knowsCtx.rule_value())
                        typeDef.addKnows(key, value)
                    }
                }
            }
        }

        return typeDef
    }

    private fun parseRuleValue(ctx: KmetaParser.Rule_valueContext): RuleValue {
        return when {
            ctx.LIST() != null -> {
                // LIST LPAREN STRING RPAREN
                val listValue = ctx.STRING().text.trim('"')
                ListValue(listValue)
            }
            ctx.STRING() != null -> {
                // Just STRING
                val stringValue = ctx.STRING().text.trim('"')
                StringValue(stringValue)
            }
            else -> StringValue("")
        }
    }
}

data class KmetaFile(val types: List<TypeDefinition>)

data class TypeDefinition(
    val name: String,
    val description: String
) {
    val props = mutableListOf<Rule>()
    val has = mutableListOf<Rule>()
    val knows = mutableListOf<Rule>()

    fun addProp(key: String, value: RuleValue) {
        props.add(Rule(key, value))
    }

    fun addHas(key: String, value: RuleValue) {
        has.add(Rule(key, value))
    }

    fun addKnows(key: String, value: RuleValue) {
        knows.add(Rule(key, value))
    }
}

data class Rule(val key: String, val value: RuleValue)

sealed class RuleValue
data class StringValue(val value: String) : RuleValue()
data class ListValue(val value: String) : RuleValue()

