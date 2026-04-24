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
package dsl.functional

import meta.AssociationType
import meta.ClassType
import meta.ClassTypeProperty
import meta.ClassTypeReference
import meta.Metamodel
import meta.SimpleProperty

/**
 * A fluent builder for constructing a Metamodel directly in Kotlin code, without writing or
 * parsing any DSL text. Intended for tests and for programmatically assembling metamodels.
 * Because references are resolved eagerly, each ClassType must be declared with makeClass()
 * before it is referenced in a relationship.
 */
class MetamodelBuilder {

    private val classTypes = mutableMapOf<String, ClassType>()
    private var rootClass: String? = null

    /** Association type constant for embedded relationships */
    public val EMBEDDED = AssociationType.EMBEDDED
    public val LINK = AssociationType.LINK

    fun makeClass(
        name: String,
        comment: String,
        props: List<SimpleProperty> = emptyList(),
        rels: List<ClassTypeProperty> = emptyList()
        ): MetamodelBuilder {
        val classType = ClassType(name, comment, props, rels)
        classTypes[name] = classType
        return this
    }

    fun makeBool(key: String): SimpleProperty {
        return SimpleProperty(key, meta.SimplePropertyType.BOOLEAN, false)
    }

    fun makeString(key: String): SimpleProperty {
        return SimpleProperty(key, meta.SimplePropertyType.STRING, false)
    }

    fun makeNumber(key: String): SimpleProperty {
       return SimpleProperty(key, meta.SimplePropertyType.NUMBER, false)
    }

    fun makeBoolList(key: String): SimpleProperty {
        return SimpleProperty(key, meta.SimplePropertyType.BOOLEAN, true)
    }

    fun makeStringList(key: String): SimpleProperty {
        return SimpleProperty(key, meta.SimplePropertyType.STRING, true)
    }

    fun makeNumberList(key: String): SimpleProperty {
        return SimpleProperty(key, meta.SimplePropertyType.NUMBER, true)
    }

    fun makeClassProp(key: String, classT: String, relT: AssociationType): ClassTypeProperty {
        return ClassTypeProperty(
            key,
            ClassTypeReference(relT, classT, classTypes[classT]!!),
            false,
            relT
        )
    }

    fun makeClassPropList(key: String, classT: String, relT: AssociationType): ClassTypeProperty {
        return ClassTypeProperty(
            key,
            ClassTypeReference(relT, classT, classTypes[classT]!!),
            true,
            relT
        )
    }

    fun setRoot(rootClassName: String){
        this.rootClass = rootClassName
    }

     fun build(): Metamodel {
        if (rootClass == null) {
            throw IllegalStateException("Root class must be set before building the metamodel.")
        }
        val rootClass = classTypes.get(rootClass!!) ?: throw IllegalStateException("Root class '$rootClass' is not defined in the metamodel.")
        return Metamodel(classTypes.values.toMutableList(), rootClass)
    }

}