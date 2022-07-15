case class Point(row: Int, column: Int, plane: (Int, Int) = (99, 99)) {
  def safeAdd(rowDelta: Int, columnDelta: Int): Point =
    if (row == plane._1 && rowDelta > 0) {
      Point(0,column)
    }

    else if (column == plane._2 && columnDelta > 0) {
      Point(row,0)
    }

    else if (row == 0 && rowDelta < 0) {
      Point(99,column)
    }

    else if (column == 0 && columnDelta < 0) {
      Point(row,99)
    }

    else 
      Point(row+rowDelta,column+columnDelta)
}

case class Rover(position: Point, orientation: Direction = Direction.North)

object Rover {
  def apply(position: String): Rover = {
    val splitedPosition = position.split(",").map(_.toInt)
    Rover(Point(row=splitedPosition(0), column = splitedPosition(1)))
  }
}