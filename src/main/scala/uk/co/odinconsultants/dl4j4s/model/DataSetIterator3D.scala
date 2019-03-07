package uk.co.odinconsultants.dl4j4s.model

import org.deeplearning4j.datasets.iterator.impl.ListDataSetIterator
import uk.co.odinconsultants.dl4j4s.autogen.Nat
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator

class DataSetIterator3D[T : Numeric, X <: Nat, Y <: Nat, Z <: Nat](ds: DataSet3D[T, X, Y, Z]) {

  def toDataSetIterator: DataSetIterator = ???  // new ListDataSetIterator(ds.toDataSet)

}
