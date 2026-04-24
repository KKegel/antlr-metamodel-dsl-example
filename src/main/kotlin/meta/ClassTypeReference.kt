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
 * Represents a reference to another class type in the metamodel.
 *
 * @property associationType The type of association to the referenced class.
 * @property classTypeName The name of the referenced class type.
 * @property classType The resolved ClassType object (populated after parsing).
 */
data class ClassTypeReference(
    val associationType: AssociationType,
    val classTypeName: String,
    var classType: ClassType? = null
)