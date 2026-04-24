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
 * Represents a class type definition in a metamodel.
 *
 * @property name The name of the class type.
 * @property comment Documentation or description for this class type.
 * @property simpleProperties List of simple (primitive) property definitions.
 * @property objectProperties List of complex object property definitions.
 */
data class ClassType(
    val name: String,
    val comment: String,
    val simpleProperties: List<SimpleProperty>,
    val objectProperties: List<ClassTypeProperty>
){

    /**
     * Returns simple properties as a map keyed by property name.
     *
     * @return Map of property names to SimpleProperty objects.
     */
    fun simplePropsAsMap(): Map<String, SimpleProperty> {
        return simpleProperties.associateBy { it.key }
    }

    /**
     * Returns object properties as a map keyed by property name.
     *
     * @return Map of property names to ClassTypeProperty objects.
     */
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