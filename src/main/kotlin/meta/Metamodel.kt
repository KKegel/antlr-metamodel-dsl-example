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
 * The root object produced by parsing a .kmeta file.
 * Holds all ClassType definitions in declaration order and designates one of them as the root
 * type — the entry point consumers use to navigate the full type graph.
 */
class Metamodel(val types: MutableList<ClassType>, val rootClass: ClassType) {

    fun getTypeByName(name: String): ClassType? {
        return types.firstOrNull { it.name == name }
    }

    fun getClassTypes(): Set<String> {
        return types.map { it.name }.toSet()
    }

    fun typesAsMap(): Map<String, ClassType> {
        return types.associateBy { it.name }
    }

}