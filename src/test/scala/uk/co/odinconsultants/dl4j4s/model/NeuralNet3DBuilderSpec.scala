package uk.co.odinconsultants.dl4j4s.model

import org.deeplearning4j.nn.conf.layers.{LSTM, RnnOutputLayer}
import org.nd4j.linalg.activations.Activation
import org.nd4j.linalg.factory.Nd4j
import org.nd4j.linalg.lossfunctions.LossFunctions
import org.nd4j.linalg.lossfunctions.impl.LossNegativeLogLikelihood
import org.scalatest.{Matchers, WordSpec}
import uk.co.odinconsultants.dl4j4s.autogen.Nats

class NeuralNet3DBuilderSpec extends WordSpec with Matchers {

  "A neural net with 2 layers" should {
    "be constructed" in new Nats {
      type H = _20
      type X = _1
      type Y = _50
      type Z = _2
      val lstmBuilder = new LSTM.Builder().activation(Activation.TANH)
      val rnnBuilder  = new RnnOutputLayer.Builder(LossFunctions.LossFunction.MCXENT).activation(Activation.SOFTMAX).lossFunction(new LossNegativeLogLikelihood(Nd4j.create(Array(0.005f, 1f))))
      val layer1      = new LayerBuilder[X, H]( (in, out) => lstmBuilder.nIn(in).nOut(out).build() )
      val layer2      = new LayerBuilder[H, Z]( (in, out) => rnnBuilder.nIn(in).nOut(out).build() )
      NeuralNet3DBuilder[Double, X, Y, Z, H](layer1, layer2)
    }
  }

}
