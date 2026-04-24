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
import dsl.textual.KmetaDSLConverter
import meta.SimplePropertyType
import org.junit.jupiter.api.Assertions.assertTrue
import parser.KmetaFileParser
import kotlin.test.Test
import kotlin.test.assertEquals

class KmetaStringParserTest {

    val content = """
            type "Robot" "A cleaning robot" {
                prop("speed", "number")
                prop("batteryLife", "number")
                has("location", "Location")
            }
            
            type "Location" "A physical location" {
                prop("x", "number")
                prop("y", "number")
            }
            
            type "Person" "A human being" {
                prop("name", "string")
                prop("age", "number")
                has("location", "Location")
            }
            
            type "World" "The world containing robots and persons" {
                has("robots", list("Robot"))
                has("persons", list("Person"))
            }
        """

    @Test
    fun testParseStringDefaultANTLRParserRuntime() {
        val parser = KmetaFileParser()
        val kmetaFile = parser.parseString(content.trimIndent())
        assertEquals(kmetaFile.types.size, 4)
        assertTrue(kmetaFile.types.map { it.name }.containsAll(listOf("Location", "Person", "World", "Robot")))
    }

    @Test
    fun testParserOutputConverter(){
        val metamodel = KmetaDSLConverter.parseKmetaString(content)
        assertEquals(metamodel.types.size, 4)
        assertTrue(metamodel.types.map { it.name }.containsAll(listOf("Location", "Person", "World", "Robot")))
        val personType = metamodel.getTypeByName("Person")
        assertEquals(2, personType?.simpleProperties?.size)
        assertEquals(1, personType?.objectProperties?.size)
        val personAgeProp = personType?.getSimpleProperty("age")
        assertEquals(false, personAgeProp?.isList)
        assertEquals(SimplePropertyType.NUMBER, personAgeProp?.propertyType)
    }

    @Test
    fun testParserOutputConverterFromFile(){
        val filePath = "example/cleaning_robot.kmeta"
        val metamodel = KmetaDSLConverter.parseKmetaFile(filePath)
        assertEquals(6, metamodel.types.size, )
        assertTrue(metamodel.types.map { it.name }.containsAll(listOf("Vector", "TwoDObject", "Obstacle", "Robot", "Room", "Wall")))

        val vectorType = metamodel.getTypeByName("Vector")
        val twoDObjectType = metamodel.getTypeByName("TwoDObject")
        val obstacleType = metamodel.getTypeByName("Obstacle")
        val robotType = metamodel.getTypeByName("Robot")
        val wallType = metamodel.getTypeByName("Wall")
        val roomType = metamodel.getTypeByName("Room")

        assertEquals("A vector in 2D space", vectorType?.comment)
        assertEquals("A two-dimensional object with a position and diameter", twoDObjectType?.comment)
        assertEquals("circular obstacle in the room", obstacleType?.comment)
        assertEquals("A cleaning robot that can move around the room and log its actions", robotType?.comment)
        assertEquals("An obstacle that represents a wall as an infinite line", wallType?.comment)
        assertEquals("A room that contains a robot and obstacles", roomType?.comment)

        assertEquals(listOf("x", "y"), vectorType?.simpleProperties?.map { it.key })
        assertEquals(listOf("diameter"), twoDObjectType?.simpleProperties?.map { it.key })
        assertEquals(emptyList<String>(), obstacleType?.simpleProperties?.map { it.key })
        assertEquals(listOf("log", "d_closest_obstacle", "d_closest_wall"), robotType?.simpleProperties?.map { it.key })
        assertEquals(emptyList<String>(), wallType?.simpleProperties?.map { it.key })
        assertEquals(emptyList<String>(), roomType?.simpleProperties?.map { it.key })

        assertEquals(listOf("position"), twoDObjectType?.objectProperties?.map { it.key })
        assertEquals(listOf("boundingBox"), obstacleType?.objectProperties?.map { it.key })
        assertEquals(listOf("boundingBox", "direction", "obstacles", "walls", "closest_obstacle", "closest_wall"),
            robotType?.objectProperties?.map { it.key })
        assertEquals(listOf("p", "u_vec"), wallType?.objectProperties?.map { it.key })
        assertEquals(listOf("robot", "obstacles", "walls").toSet(),
            roomType?.objectProperties?.map { it.key }?.toSet())

        val robotObstaclesProp = robotType?.getObjectProperty("obstacles")
        assertEquals(true, robotObstaclesProp?.isList)
        assertEquals("Obstacle", robotObstaclesProp?.reference?.classTypeName)
    }

}