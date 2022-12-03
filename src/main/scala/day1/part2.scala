package day1

import scala.annotation.tailrec
import scala.io.Source

object part2 {
  private[day1] def run(): Unit = {
    val source = Source.fromResource("day1.dat")
    val lines = source.getLines().toList
    val cals = acc(lines, 0, List()).sorted.reverse
    println(cals.head + cals(1) + cals(2))
  }

  @tailrec
  private def acc(lines: List[String], currentTotal: Int, cals: List[Int]): List[Int] = {
    val calPattern = "(\\d+)".r
    lines match {
      case s :: rest => s match {
        case calPattern(num) => acc(rest, currentTotal + num.toInt, cals)
        case "" => acc(rest, 0, currentTotal :: cals)
      }
      case Nil => cals
    }
  }
}