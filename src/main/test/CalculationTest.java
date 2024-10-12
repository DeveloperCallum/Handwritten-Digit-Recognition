import network.NeuralNetwork;
import network.activation.SigmoidActivationFunction;
import org.junit.Assert;
import org.junit.Test;
import util.MatrixPrinter;

public class CalculationTest {

	@Test
	public void run(){
		double[] inputs = new double[]{0.9, 0.1, 0.8};
		double[][] inFL = new double[][]{
				{0.9, 0.3, 0.4},
				{0.2, 0.8, 0.2},
				{0.1, 0.5, 0.6}
		};

		double[][] fl2L = new double[][]{
				{0.3, 0.7, 0.5},
				{0.6, 0.5, 0.2},
				{0.8, 0.1, 0.9}
		};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[] output1 = neuralNetwork.getWeightedSum(inputs, inFL);
		Assert.assertArrayEquals("Weighted Sum incorrect", new double[]{1.16, 0.42, 0.62}, output1, 0.001);

		double[] o1Sigmoid = neuralNetwork.applyActivationFunction(output1);
		Assert.assertArrayEquals("Activation Function incorrect", new double[]{0.761, 0.603, 0.650,}, o1Sigmoid, 0.001);

		double[] output2 = neuralNetwork.getWeightedSum(o1Sigmoid, fl2L);
		Assert.assertArrayEquals("Weighted Sum incorrect", new double[]{0.975, 0.888, 1.254}, output2, 0.001);

		double[] o2Sigmoid = neuralNetwork.applyActivationFunction(output2);
		Assert.assertArrayEquals("Activation Function incorrect", new double[]{0.726, 0.708, 0.778}, o2Sigmoid, 0.001);
	}
}
