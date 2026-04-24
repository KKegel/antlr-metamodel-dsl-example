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
 * An object-typed attribute on a ClassType, produced by a `has(...)` or `knows(...)` rule in the DSL.
 * Unlike SimpleProperty it points to another ClassType via a ClassTypeReference and records
 * whether the relationship is ownership (EMBEDDED) or a plain reference (LINK).
 */
data class ClassTypeProperty(
    val key: String,
    val reference: ClassTypeReference,
    val isList: Boolean,
    val associationType: AssociationType
)
