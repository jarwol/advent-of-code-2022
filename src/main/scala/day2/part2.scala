package day2

import scala.annotation.tailrec
import scala.io.Source

object part2 {

  val Win = 6
  val Draw = 3
  val Loss = 0
  val OpponentRock = "A"
  val OpponentPaper = "B"
  val OpponentScissors = "C"
  val MyRock = "X"
  val MyPaper = "Y"
  val MyScissors = "Z"

  private[day2] def run(): Unit = {
    val pointMap = Map("X" -> 1, "Y" -> 2, "Z" -> 3)
    val resultMap = Map("X" -> Loss, "Y" -> Draw, "Z" -> Win)
    val source = Source.fromResource("day2.dat")
    val lines = source.getLines().toList
    val totalScore = lines.foldLeft(0) { (score, line) =>
      val parts = line.split(" ")
      val myMove = calcMyMove(parts(0), parts(1))
      score + resultMap(parts(1)) + pointMap(myMove)
    }
    println(totalScore)
  }

  private def calcMyMove(opponentMove: String, result: String): String = opponentMove match {
    case OpponentRock =>
      if (result == "X") MyScissors
      else if (result == "Y") MyRock
      else MyPaper
    case OpponentPaper =>
      if (result == "X") MyRock
      else if (result == "Y") MyPaper
      else MyScissors
    case OpponentScissors =>
      if (result == "X") MyPaper
      else if (result == "Y") MyScissors
      else MyRock
  }
}