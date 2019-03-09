package uk.co.odinconsultants.dl4j4s.autogen

import org.scalatest.{Matchers, WordSpec}

class NatsSpec extends WordSpec with Matchers {

  "Nats" should {
    "provide compile time limits" in new Nats {
      def greaterThan10[A <: Succ[_]](x: A)(implicit ev: gt[_, _10]): Unit = println("that works")

      trait gt[T <: Succ[U], U <: Succ[_]]
      implicit object Gt10Evidence extends gt[_11, _10]

      trait NaturalPair[A <: Nat, B <: Nat]

//      implicit def sub[A <: Nat, B <: Nat](implicit e: NaturalPair[Succ[A], Succ[B]]) = new NaturalPair[A, B] {}
      implicit def peano[A <: Succ[B], B <: Nat](implicit e: NaturalPair[Succ[A], Succ[B]]): NaturalPair[A, B] = new NaturalPair[A, B] {}

      implicit def peanoDef[A <: Succ[B], B <: Succ[_]]: gt[A, B] = new gt[A, B] {}

      implicit def successive[T <: Succ[U], U <: Succ[_]](implicit b: U): U = b

      implicit val a8:   _8 = new _8
      implicit val a9:   _9 = new _9
      implicit val a10: _10 = new _10
      implicit val a11: _11 = new _11
      implicit val a12: _12 = new _12

      implicit def add1[A <: Succ[_]](implicit b: Succ[A]): Succ[A] = b

      greaterThan10(a9) // this should fail
      greaterThan10(a11)
      greaterThan10(a12)

      add1[_10]

    }
  }

}
