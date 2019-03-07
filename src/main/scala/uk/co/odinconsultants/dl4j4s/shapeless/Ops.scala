package uk.co.odinconsultants.dl4j4s.shapeless

import uk.co.odinconsultants.dl4j4s.autogen.{Nat, Succ, _0}

/**
  * To use Shapeless concepts in my code.
  * Stolen^H^H^H^H^H^H Inspired by the hyper-smart Miles Sabin.
  */
object Ops {

  /**
    * Type class supporting conversion of type-level Nats to value level Ints.
    *
    * @author Miles Sabin
    */
  trait ToInt[N <: Nat] extends Serializable {
    def apply() : Int
  }

  object ToInt {
    def apply[N <: Nat](implicit toInt: ToInt[N]): ToInt[N] = toInt

    implicit val toInt0: ToInt[_0] = () => 0

    implicit def toIntSucc[N <: Nat](implicit toIntN : ToInt[N]): ToInt[Succ[N]] = () => toIntN() + 1
  }
}
