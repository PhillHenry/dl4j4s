package uk.co.odinconsultants.dl4j4s.model

import uk.co.odinconsultants.dl4j4s.autogen.Nat
import uk.co.odinconsultants.dl4j4s.shapeless.Ops._
import org.deeplearning4j.nn.conf.layers.Layer

class LayerBuilder[X <: Nat, Y <: Nat](fn: (Int, Int) => Layer)(implicit x: ToInt[X], y: ToInt[Y]) {

  val nIn:  Int = x.apply()
  val nOut: Int = y.apply()

  def build: Layer = fn(nIn, nOut)

}
