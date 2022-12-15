package day5

import scala.annotation.tailrec
import scala.io.Source

object part1 {
  type Section = (Int, Int)

  private[day5] def run(): Unit = {
    val stacks = Array.fill(9) {
      Seq[Char]()
    }
    val source = Source.fromResource("day5.dat")
    val lines = source.getLines()

  }


  private def parseLine(line: String, stacks: Seq[Char]): Unit = {
    for (i <- 0 until line.length by 3) {

    }
  }
}