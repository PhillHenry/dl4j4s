package uk.co.odinconsultants.dl4j4s.model

import uk.co.odinconsultants.dl4j4s.autogen.Nat
import uk.co.odinconsultants.dl4j4s.shapeless.Ops.ToInt

class NeuralNet3D[T : Numeric, X <: Nat, Y <: Nat, Z <: Nat](implicit
                                                              x: ToInt[X],
                                                              y: ToInt[Y],
                                                              z: ToInt[Z]
                                                            ) {



}
