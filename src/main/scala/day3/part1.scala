package day3

import scala.annotation.tailrec
import scala.io.Source

object part1 {
  private[day3] def run(): Unit = {
    val source = Source.fromResource("day3.dat")
    val lines = source.getLines().toList

    val total = lines.foldLeft(0) { (sum: Int, line: String) =>
      val (comp1, comp2) = getCompartments(line)
      sum + getDuplicatePriority(comp1, comp2)
    }

    println(total)
  }

  private def getDuplicatePriority(comp1: Set[Char], comp2: Set[Char]): Int =
    getPriority(comp1.intersect(comp2).head)

  private def getPriority(ch: Char): Int = {
    if (ch >= 'A' && ch <= 'Z') {
      ch - 'A' + 27
    } else {
      ch - 'a' + 1
    }
  }

  private def getCompartments(line: String): (Set[Char], Set[Char]) = {
    val compartment1 = line.slice(0, line.length / 2)
    val compartment2 = line.slice(line.length / 2, line.length)

    (compartment1.toSet, compartment2.toSet)
  }
}