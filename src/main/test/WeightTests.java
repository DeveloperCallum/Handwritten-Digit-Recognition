import network.NeuralNetwork;
import network.activation.SigmoidActivationFunction;
import org.junit.Assert;
import org.junit.Test;
import util.MatrixPrinter;

public class WeightTests {

	@Test
	public void correctSummedValues() {
		double[] inputs = new double[]{0.9, 0.1, 0.8};
		double[][] inFL = new double[][]{
				{0.9, 0.3, 0.4},
				{0.2, 0.8, 0.2},
				{0.1, 0.5, 0.6}
		};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[] output = neuralNetwork.getWeightedSum(inputs, inFL);

		Assert.assertArrayEquals("Activation Function producing incorrect values", new double[]{1.16, 	 0.42, 	 0.62}, output, 0.001);
	}

	@Test
	public void creationTest(){
		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());

		double[][] output = neuralNetwork.generateWeightMatrix(3, 4);

		Assert.assertEquals(output.length, 3);
		Assert.assertEquals(output[0].length, 4);
	}
}
