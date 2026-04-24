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
package dsl.textual

import meta.AssociationType
import meta.ClassType
import meta.ClassTypeProperty
import meta.ClassTypeReference
import meta.Metamodel
import meta.SimpleProperty
import meta.SimplePropertyType
import parser.KmetaFileParser
import parser.ListValue
import parser.StringValue
import java.io.File

/**
 * Converts KMeta DSL strings and files into Metamodel objects.
 */
object KmetaDSLConverter {

    /**
     * Parses a KMeta string and converts it to a Metamodel.
     *
     * @param content The KMeta content as a string.
     * @return The parsed metamodel.
     */
    fun parseKmetaString(content: String): Metamodel {
        val d = KmetaFileParser().parseString(content.trimIndent())
        val types = d.types
        val classTypes = mutableListOf<ClassType>()

        for (t in d.types){
            println("Type: ${t.name}")
            println("   Description: ${t.description}")

            val typeName = t.name
            val typeDescription = t.description
            val typeSimpleProperties = mutableListOf<SimpleProperty>()
            val typeClassTypeProperties = mutableListOf<ClassTypeProperty>()


                if (t.props.isNotEmpty()) {
                    println("\n   Props:")
                    for (prop in t.props) {
                        val key = prop.key
                        val value = prop.value
                        val isList = prop.value is ListValue
                        val targetType = when (prop.value) {
                            is StringValue -> {
                                println("   Prop: $key = ${(value as StringValue).value}")
                                value.value
                            }
                            is ListValue -> {
                                val listValue = prop.value as ListValue
                                val targetType = listValue.value
                                targetType
                            }
                        }
                        val parsedTargetType = when (targetType) {
                            "string" -> SimplePropertyType.STRING
                            "number" -> SimplePropertyType.NUMBER
                            "boolean" -> SimplePropertyType.BOOLEAN
                            else -> {
                                throw IllegalArgumentException("Unknown rule value type for prop '$key'")
                            }
                        }
                        val property = SimpleProperty(key, parsedTargetType, isList)
                        typeSimpleProperties.add(property)
                    }

                }

                if (t.has.isNotEmpty()) {
                    println("\n   Has:")
                    for (hasRule in t.has) {
                        val key = hasRule.key
                        val value = hasRule.value
                        val isList = hasRule.value is ListValue
                        val targetType = if(isList){
                            value.value
                        }else{
                            (value as StringValue).value
                        }
                        val hasProperty = ClassTypeProperty(
                            key,
                            ClassTypeReference(AssociationType.EMBEDDED, targetType),
                            isList,
                            AssociationType.EMBEDDED
                        )
                        typeClassTypeProperties.add(hasProperty)
                        println(hasProperty)
                    }
                }

                if (t.knows.isNotEmpty()) {
                    println("\n   Knows:")
                    for (knowsRule in t.knows) {
                        val key = knowsRule.key
                        val value = knowsRule.value
                        val isList = knowsRule.value is ListValue
                        val targetType = if(isList){
                            value.value
                        }else{
                            (value as StringValue).value
                        }
                        val hasProperty = ClassTypeProperty(
                            key,
                            ClassTypeReference(AssociationType.LINK, targetType),
                            isList,
                            AssociationType.LINK
                        )
                        typeClassTypeProperties.add(hasProperty)
                    }
                }
            val classType = ClassType(
                typeName,
                typeDescription,
                typeSimpleProperties,
                typeClassTypeProperties
            )
            classTypes.add(classType)
        }

        //now that we know all class types, we can resolve the references in the ClassTypeProperties
        for (classType in classTypes){
            for (classTypeProp in classType.objectProperties){
                val reference = classTypeProp.reference
                val targetClassType = classTypes.find { it.name == reference.classTypeName }
                if (targetClassType != null){
                    reference.classType = targetClassType
                }else {
                    throw IllegalArgumentException("Unknown target class type '${reference.classTypeName}' for property")
                }
            }
        }

        //FIXME for now, we assume the last type defined is the root type of the metamodel,
        // but we should have a better way to define this in the DSL
        return Metamodel(classTypes, classTypes.last())
    }

    /**
     * Parses a KMeta file and converts it to a Metamodel.
     *
     * @param filePath The path to the KMeta file to parse.
     * @return The parsed metamodel.
     */
    fun parseKmetaFile(filePath: String): Metamodel {
        val content = File(filePath).readText()
        return parseKmetaString(content)
    }

    /**
     * Converts a Metamodel back to a KMeta DSL string.
     *
     * @param metamodel The metamodel to convert.
     * @return The KMeta DSL string representation.
     * @throws NotImplementedError This operation is not yet implemented.
     */
    fun convertToKmetaString(metamodel: Metamodel): String {
        throw NotImplementedError()
    }

}