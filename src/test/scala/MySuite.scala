// For more information on writing tests, see
// https://scalameta.org/munit/docs/getting-started.html
class MySuite extends munit.FunSuite {
  val baseRover = Rover(Point(1, 2))
  
  test("Rover Object is correctly created when given position") {
    val position = "1,2"
    val constructedRover = Rover(position)
    val expectedRover = Rover(Point(1, 2))
    assert(constructedRover == expectedRover)
  }

  test("Ignore incorrect move") {
    val userInput = Move("Y")
    val obtainedRover = userInput.move(baseRover)
    assert(obtainedRover == baseRover)
  }

  test("Forward moves correct given North orientation") {
    val userInput = Move("F")
    val obtainedRover = userInput.move(baseRover)
    val expectedRover = Rover(Point(2,2))
    assert(obtainedRover == expectedRover)
  }

  test("Forward moves correct given South") {
    val userInput = Move("F")
    val baseRover = Rover(Point(1, 2), Direction.South)
    val obtainedRover = userInput.move(baseRover)
    val expectedRover = Rover(Point(0,2), Direction.South)
    assert(obtainedRover == expectedRover)
  }

  test("Forward moves correct given West (and overflow)") {
    val userInput = Move("F")
    val baseRover = Rover(Point(0, 0), Direction.West)
    val obtainedRover = userInput.move(baseRover)
    val expectedRover = Rover(Point(0, 99), Direction.West)
    assert(obtainedRover == expectedRover)
  }

  test("Left moves correct given North (West)") {
    val userInput = Move("L")
    val obtainedRover = userInput.move(baseRover)
    val expectedRover = Rover(Point(1, 2), Direction.West)
  }

  test("Right moves correct given North (East)") {
    val userInput = Move("R")
    val obtainedRover = userInput.move(baseRover)
    val expectedRover = Rover(Point(1, 2), Direction.West)
  }

}
