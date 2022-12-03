package day2

import scala.annotation.tailrec
import scala.io.Source

object part1 {

  val Win = 6
  val Draw = 3
  val Loss = 0

  private[day2] def run(): Unit = {
    val pointMap = Map("X" -> 1, "Y" -> 2, "Z" -> 3)
    val source = Source.fromResource("day2.dat")
    val lines = source.getLines().toList
    val totalScore = lines.foldLeft(0) { (score: Int, line: String) =>
      val parts = line.split(" ")
      val total = score + calcOutcome(parts(0), parts(1)) + pointMap(parts(1))
      total
    }
    println(totalScore)
  }

  private def calcOutcome(opponentMove: String, myMove: String): Int = opponentMove match {
    case "A" =>
      if (myMove == "X") Draw
      else if (myMove == "Y") Win
      else Loss
    case "B" =>
      if (myMove == "X") Loss
      else if (myMove == "Y") Draw
      else Win
    case "C" =>
      if (myMove == "X") Win
      else if (myMove == "Y") Loss
      else Draw
  }
}