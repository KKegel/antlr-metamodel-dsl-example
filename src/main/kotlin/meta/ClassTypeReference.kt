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
 * A two-phase pointer to a target ClassType.
 * During the first parse pass only the target type name is known; once all types have been
 * collected, the classType field is resolved to the actual ClassType object. This deferred
 * resolution allows types to reference each other regardless of declaration order.
 */
data class ClassTypeReference(
    val associationType: AssociationType,
    val classTypeName: String,
    var classType: ClassType? = null
)