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
import dsl.functional.MetamodelBuilder
import meta.Metamodel

class MetamodelConstructorExample {

    fun setupRobotRoomMetamodel(): Metamodel {
        val m = MetamodelBuilder()

        m.makeClass(
            name = "Point",
            comment = "A point in 2D space",
            props = listOf(
                m.makeNumber(key = "x"),
                m.makeNumber(key = "y")
            ))

        m.makeClass(
            name = "TwoDObject",
            comment = "A two-dimensional object with a position and diameter.",
            props = listOf(m.makeNumber(key = "diameter")),
            rels = listOf(m.makeClassProp(key = "position", classT = "Point", relT = m.EMBEDDED))
        )

        m.makeClass(
            name = "Obstacle",
            comment = "An obstacle in the room that the robot should avoid.",
            rels = listOf(m.makeClassProp(key = "boundingBox", classT = "TwoDObject", relT = m.EMBEDDED))
        )

        m.makeClass(
            name = "Robot",
            comment = "A cleaning robot that can move around the room and log its actions.",
            props = listOf(
                m.makeNumber(key = "speed"),
                m.makeStringList(key = "log")),
            rels = listOf(
                m.makeClassProp(key = "boundingBox", classT = "TwoDObject", relT = m.EMBEDDED),
                m.makeClassPropList(key = "obstacles", classT = "Obstacle", relT = m.LINK)
            )
        )

        m.makeClass(
            name = "Room",
            comment = "A room that contains a robot and some obstacles.",
            rels = listOf(
                m.makeClassProp(key = "topLeftCorner", classT = "Point", relT = m.EMBEDDED),
                m.makeClassProp(key = "topRightCorner", classT = "Point", relT = m.EMBEDDED),
                m.makeClassProp(key = "bottomLeftCorner", classT = "Point", relT = m.EMBEDDED),
                m.makeClassProp(key = "bottomRightCorner", classT = "Point", relT = m.EMBEDDED),
                m.makeClassProp(key = "robot", classT = "Robot", relT = m.EMBEDDED),
                m.makeClassPropList(key = "obstacles", classT = "Obstacle", relT = m.EMBEDDED)
            )
        )

        m.setRoot("Room")
        return m.build()
    }



}