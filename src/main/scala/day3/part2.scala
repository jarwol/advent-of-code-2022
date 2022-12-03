package day3

import scala.annotation.tailrec
import scala.io.Source

object part2 {
  private[day3] def run(): Unit = {
    val source = Source.fromResource("day3.dat")
    val lines = source.getLines().toList

    println(findCommon(0, lines))
  }

  @tailrec
  private def findCommon(total: Int, lines: List[String]): Int = lines match {
    case s :: xs =>
      val item = s.intersect(xs.head).intersect(xs.tail.head)
      val pri = getPriority(item.charAt(0))
      findCommon(total + pri, xs.tail.tail)
    case Nil => total
  }

  private def getPriority(ch: Char): Int = {
    if (ch >= 'A' && ch <= 'Z') {
      ch - 'A' + 27
    } else {
      ch - 'a' + 1
    }
  }
}