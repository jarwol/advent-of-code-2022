package day1

import scala.annotation.tailrec
import scala.io.Source

object part1 {
  private[day1] def run(): Unit = {
    val source = Source.fromResource("day1.dat")
    val lines = source.getLines().toList
    println(acc(lines, 0, 0))
  }

  @tailrec
  private def acc(lines: List[String], currentTotal: Int, max: Int): Int = {
    val calPattern = "(\\d+)".r
    lines match {
      case s :: rest => s match {
        case calPattern(num) => acc(rest, currentTotal + num.toInt, max.max(currentTotal + num.toInt))
        case "" => acc(rest, 0, max)
      }
      case Nil => max
    }
  }
}