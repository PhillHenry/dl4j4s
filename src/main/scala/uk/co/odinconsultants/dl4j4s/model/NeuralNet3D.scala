package uk.co.odinconsultants.dl4j4s.model

import org.deeplearning4j.nn.multilayer.MultiLayerNetwork
import uk.co.odinconsultants.dl4j4s.autogen.Nat
import uk.co.odinconsultants.dl4j4s.shapeless.Ops.ToInt

class NeuralNet3D[T : Numeric, X <: Nat, Y <: Nat, Z <: Nat](val net: MultiLayerNetwork)
                                                            (implicit x: ToInt[X], y: ToInt[Y], z: ToInt[Z]) {

  def fit(iter: DataSetIterator3D[T, X, Y, Z]): NeuralNet3D[T, X, Y, Z] = {
    net.fit(iter.toDataSetIterator)
    this
  }

}
