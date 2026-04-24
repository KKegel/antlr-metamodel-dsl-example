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
package meta

/**
 * A single type block from a .kmeta file, e.g. `type "Robot" "description" { ... }`.
 * Acts as the central building block of the metamodel: it groups a type's name, human-readable
 * description, primitive attributes (SimpleProperty), and object relationships (ClassTypeProperty).
 */
data class ClassType(
    val name: String,
    val comment: String,
    val simpleProperties: List<SimpleProperty>,
    val objectProperties: List<ClassTypeProperty>
){

    fun simplePropsAsMap(): Map<String, SimpleProperty> {
        return simpleProperties.associateBy { it.key }
    }

    fun objectPropsAsMap(): Map<String, ClassTypeProperty> {
        return objectProperties.associateBy { it.key }
    }

    fun getSimpleProperty(key: String): SimpleProperty {
        return simplePropsAsMap()[key] ?:
        throw IllegalArgumentException("No simple property with key $key found in class type $name")
    }

    fun getObjectProperty(key: String): ClassTypeProperty {
        return objectPropsAsMap()[key] ?:
        throw IllegalArgumentException("No object property with key $key found in class type $name")
    }
}