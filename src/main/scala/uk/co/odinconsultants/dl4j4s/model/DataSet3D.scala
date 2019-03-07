package uk.co.odinconsultants.dl4j4s.model

import org.nd4j.linalg.dataset.DataSet
import org.nd4j.linalg.factory.Nd4j
import uk.co.odinconsultants.dl4j4s.autogen.Nat
import uk.co.odinconsultants.dl4j4s.shapeless.Ops._

class DataSet3D[T : Numeric, X <: Nat, Y <: Nat, Z <: Nat](val n: Int)
  (implicit x: ToInt[X], y: ToInt[Y], z: ToInt[Z]) {

  val nIn:          Int = x.apply()
  val seriesLength: Int = y.apply()
  val nClasses:     Int = z.apply()

  private val features  = Nd4j.zeros(n: Int, nIn: Int, seriesLength: Int)
  private val labels    = Nd4j.zeros(n, nClasses, seriesLength)

  protected def toDataSet: DataSet = ???

}

