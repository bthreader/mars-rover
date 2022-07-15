trait Move {
    def move(rover: Rover): Rover
}

case class Empty() extends Move {
    def move(rover: Rover): Rover = {
        // Return the same rover
        rover
    }
}

case class Forward() extends Move {
    def move(rover: Rover): Rover = {
        rover.orientation match
            case Direction.North => 
                Rover(rover.position.safeAdd(1, 0), rover.orientation)
            case Direction.South =>
                Rover(rover.position.safeAdd(-1, 0), rover.orientation)
            case Direction.West =>
                Rover(rover.position.safeAdd(0, -1), rover.orientation)
            case Direction.East =>
                Rover(rover.position.safeAdd(0, 1), rover.orientation)
    }
}

case class Left() extends Move {
    def move(rover: Rover): Rover = {
        rover.orientation match
            case Direction.North => Rover(rover.position,Direction.West)
            case Direction.South => Rover(rover.position,Direction.East)
            case Direction.East => Rover(rover.position,Direction.North)
            case Direction.West => Rover(rover.position,Direction.South)
    }
}

case class Right() extends Move {
    def move(rover: Rover): Rover = {
        rover.orientation match
            case Direction.North => Rover(rover.position,Direction.East)
            case Direction.South => Rover(rover.position,Direction.West)
            case Direction.East => Rover(rover.position,Direction.South)
            case Direction.West => Rover(rover.position,Direction.North)
    }
}

object Move {
    def apply(input: String): Move = {
        input match {
            case "F" => Forward()
            case "L" => Left()
            case "R" => Right()
            case _ => Empty()
        }
    }
}