import network.NeuralNetwork;
import network.activation.SigmoidActivationFunction;
import org.junit.Assert;
import org.junit.Test;

public class WeightTests {

	@Test
	public void correctSummedValues() {
		double[] inputs = new double[]{0.5, 1, 2};

		double[][] InFl = new double[][]{
				{4, 6, 1, 2},
				{5, 7, 4, 2},
				{1, 7, 5, 3}};

		NeuralNetwork neuralNetwork = new NeuralNetwork(inputs, InFl, new SigmoidActivationFunction());
		double[] outputs = neuralNetwork.getWeightedSum();
		double[] expected = new double[]{9, 24, 14.5, 9};

		Assert.assertArrayEquals("Summed weights calculated incorrectly", expected, outputs, 0.1);
	}
}
