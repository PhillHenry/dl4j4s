package uk.co.odinconsultants.dl4j4s.autogen

import java.io.{FileWriter, PrintWriter}

/**
  * Inspired by Miles Sabin's Shapeless library, this code will autogenerate types representing natural numbers.
  * Sabin's library only has some 22 classes. This can generate any.
  */
object MakeNatsMain {

  def aNat(i: Int): String = {
    s"""  type _$i = Succ[_${i - 1}]
      |  val _$i: _$i = new _$i
      |"""
  }

  def main(args: Array[String]): Unit = {
    val n = if (args.length == 1) args(0).toInt else 128

    val code = s"""package uk.co.odinconsultants.dl4j4s.autogen
                 |

                 |trait Nat {
                 |  type N <: Nat
                 |}
                 |
                 |case class Succ[P <: Nat]() extends Nat {
                 |  type N = Succ[P]
                 |}
                 |
                 |class _0 extends Nat {
                 |  type N = _0
                 |}
                 |
                 |trait Nats {
                 |${(1 to n).map(aNat(_)).mkString("\n")}
                 |}""".stripMargin

    val dirName     = "src/main/scala/uk/co/odinconsultants/dl4j4s/autogen"
    val dir         = new java.io.File(dirName)
    if (!dir.exists()) dir.mkdirs()
    val writer      = new FileWriter(s"$dirName/Nats.scala")
    val printWriter = new PrintWriter(writer)
    printWriter.println(code)
    printWriter.close()
  }

}
