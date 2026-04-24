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
 * Represents the metamodel structure with class type definitions and root type.
 *
 * @property types List of all class type definitions in the metamodel.
 * @property rootClass The designated root class type for instances.
 */
class Metamodel(val types: MutableList<ClassType>, val rootClass: ClassType) {

    /**
     * Retrieves a class type by its name.
     *
     * @param name The name of the class type to retrieve.
     * @return The ClassType if found, null otherwise.
     */
    fun getTypeByName(name: String): ClassType? {
        return types.firstOrNull { it.name == name }
    }

    /**
     * Returns the set of all class type names in the metamodel.
     *
     * @return A set of class type names.
     */
    fun getClassTypes(): Set<String> {
        return types.map { it.name }.toSet()
    }

    fun typesAsMap(): Map<String, ClassType> {
        return types.associateBy { it.name }
    }

}