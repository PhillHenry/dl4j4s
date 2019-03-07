package uk.co.odinconsultants.dl4j4s.model

import org.deeplearning4j.nn.conf.{GradientNormalization, NeuralNetConfiguration}
import org.deeplearning4j.nn.conf.layers.{LSTM, RnnOutputLayer}
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork
import org.deeplearning4j.nn.weights.WeightInit
import org.deeplearning4j.optimize.listeners.ScoreIterationListener
import org.nd4j.linalg.activations.Activation
import org.nd4j.linalg.factory.Nd4j
import org.nd4j.linalg.learning.config.Nesterovs
import org.nd4j.linalg.lossfunctions.LossFunctions
import org.nd4j.linalg.lossfunctions.impl.LossNegativeLogLikelihood
import uk.co.odinconsultants.dl4j4s.autogen.Nat
import uk.co.odinconsultants.dl4j4s.shapeless.Ops._

object NeuralNet3DBuilder {

  def apply[T : Numeric, X <: Nat, Y <: Nat, Z <: Nat, H <: Nat](first: LayerBuilder[X, H], second: LayerBuilder[H, Z])(implicit x: ToInt[X], y: ToInt[Y], z: ToInt[Z]) : NeuralNet3D[T, X, Y, Z] = {
    val nIn:          Int = x.apply()
    val seriesLength: Int = y.apply()
    val nClasses:     Int = z.apply()

    // TODO make all these other configs configurable
    val conf = new NeuralNetConfiguration.Builder()
      .seed(123)
      .weightInit(WeightInit.XAVIER)
      .updater(new Nesterovs(0.005))
      .gradientNormalization(GradientNormalization.ClipElementWiseAbsoluteValue)
      .gradientNormalizationThreshold(0.5)
      .list()
      .layer(0, first.build)
      .layer(1, second.build)
      .build()

    val model = new MultiLayerNetwork(conf)
    model.init()
    model.setListeners(new ScoreIterationListener(100))
    new NeuralNet3D[T, X, Y, Z](model)
  }

}
