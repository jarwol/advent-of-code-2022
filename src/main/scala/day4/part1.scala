package day4

import scala.annotation.tailrec
import scala.io.Source

object part1 {
  type Section = (Int, Int)

  private[day4] def run(): Unit = {
    val source = Source.fromResource("day4.dat")
    val sections: Seq[(Section, Section)] = source.getLines().map { line =>
      val sections = line.split(',').map { pair =>
        val pairs = pair.split('-')
        (pairs(0).toInt, pairs(1).toInt)
      }
      (sections(0), sections(1))
    }.toSeq

    println(sections.count(sections => contains(sections._1, sections._2)))
  }

  private def contains(sec1: Section, sec2: Section): Boolean = {
    (sec1._1 <= sec2._1 && sec1._2 >= sec2._2) || (sec1._1 >= sec2._1 && sec1._2 <= sec2._2)
  }
}