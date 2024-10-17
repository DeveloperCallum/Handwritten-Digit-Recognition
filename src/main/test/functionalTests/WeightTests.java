package functionalTests;

import network.MatrixCalculator;
import network.NeuralNetwork;
import network.activation.SigmoidActivationFunction;
import org.junit.Assert;
import org.junit.Test;
import util.MatrixPrinter;

public class WeightTests {

	@Test
	public void correctSummedValues() {
		double[][] inputs = new double[][]{
				{0.9},
				{0.1},
				{0.8}};

		double[][] inFL = new double[][]{
				{0.9, 0.3, 0.4},
				{0.2, 0.8, 0.2},
				{0.1, 0.5, 0.6}
		};

		double[][] expected = new double[][]{
				{1.16},
				{0.42},
				{0.62}};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] output = neuralNetwork.getWeightedSum(inFL, inputs);

		TestUtil.testMatrixEqualsResult(expected, output, 0.01);
	}

	@Test
	public void proportionalMatrixCreationTest1() {
		double[][] weight = new double[][]{
				{4, 7, 1},
				{8, 1, 6},
				{2, 9, 2}};

		double[][] expected = new double[][]{
				{0.29, 0.41, 0.11},
				{0.57, 0.06, 0.67},
				{0.14, 0.53, 0.22}};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] actual = neuralNetwork.calculateProportionalMatrix(weight);

		TestUtil.testMatrixEqualsResult(expected, actual, 0.01);
	}

	@Test
	public void proportionalMatrixCreationTestBiggerWidth() {
		double[][] weight = new double[][]{
				{4, 7, 1, 9},
				{8, 1, 6, 3},
				{2, 9, 2, 1}};

		double[][] expected = new double[][]{
				{0.29, 0.41, 0.11, 0.69},
				{0.57, 0.06, 0.67, 0.23},
				{0.14, 0.53, 0.22, 0.08}};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] actual = neuralNetwork.calculateProportionalMatrix(weight);

		TestUtil.testMatrixEqualsResult(expected, actual, 0.01);
	}

	@Test
	public void proportionalMatrixCreationTestBiggerHeight() {
		double[][] weight = new double[][]{
				{4, 7, 1},
				{8, 1, 6},
				{2, 9, 2},
				{9, 3, 1}};

		double[][] expected = new double[][]{
				{0.17, 0.35, 0.10},
				{0.35, 0.05, 0.60},
				{0.09, 0.45, 0.20},
				{0.39, 0.15, 0.10}};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] actual = neuralNetwork.calculateProportionalMatrix(weight);

		for (int i = 0; i < actual.length; i++) {
			double[] actualArr = actual[i];
			double[] expectedArr = expected[i];

			Assert.assertArrayEquals("incorrect values", expectedArr, actualArr, 0.01);
		}
	}

	@Test
	public void calculateError() {
		double[][] target = new double[][]{
				{4},
				{51},
				{16},
				{53},
				{34},
				{1}};

		double[][] output = new double[][]{
				{26},
				{63},
				{14},
				{74},
				{1},
				{52}};

		double[][] expected = new double[][]{
				{484},
				{144},
				{4},
				{441},
				{1089},
				{2601}};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] actual = neuralNetwork.calculateError(target, output);

		TestUtil.testMatrixEqualsResult(expected, actual, 0.01);
	}

	@Test
	public void calculateError1(){
		double[][] target = new double[][]{
				{0.5},
				{0.7},
				{1}
		};

		double[][] output = new double[][]{
				{0.4},
				{0.8},
				{1},
		};

		double[][] expected = new double[][]{
				{0.01},
				{0.01},
				{0.0},
		};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] actual = neuralNetwork.calculateError(target, output);

		TestUtil.testMatrixEqualsResult(expected, actual, 0.01);
	}

	@Test
	public void calculateError2(){
		double[][] who = new double[][]{
				{2, 1},
				{3, 4}

		};

		double[][] wih = new double[][]{
				{3, 1},
				{2, 7}

		};

		double[][] outputError = new double[][]{
				{0.8},
				{0.5}
		};


		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] proportionalMatrix = neuralNetwork.calculateProportionalMatrix(who);
		double[][] eho = MatrixCalculator.multiplyMatrix(proportionalMatrix, outputError);
		double[][] proportionalMatrix1 = neuralNetwork.calculateProportionalMatrix(wih);
		double[][] eih = MatrixCalculator.multiplyMatrix(proportionalMatrix1, eho);

		double[][] expected = new double[][]{
				{0.362},
				{0.930}
		};

		TestUtil.testMatrixEqualsResult(expected, eih, 0.01);
	}

	@Test
	public void creationTest() {
		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());

		double[][] output = neuralNetwork.generateWeightMatrix(3, 4);

		Assert.assertEquals(output.length, 3);
		Assert.assertEquals(output[0].length, 4);
	}
}
