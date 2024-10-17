package endToEnd;

import functionalTests.TestUtil;
import network.MatrixCalculator;
import network.NeuralNetwork;
import network.activation.SigmoidActivationFunction;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import util.MatrixPrinter;

public class EndToEndCalculationTest {

	@Test
	@Order(1)
	public void FirstLayer() {
		double[][] inputs = new double[][]{
				{0.9},
				{0.1},
				{0.8}};

		double[][] inFL = new double[][]{
				{0.9, 0.3, 0.4},
				{0.2, 0.8, 0.2},
				{0.1, 0.5, 0.6}
		};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] output1 = neuralNetwork.getWeightedSum(inFL, inputs);
		double[][] expected1 = new double[][]{
				{1.16},
				{0.42},
				{0.62}};
		TestUtil.testMatrixEqualsResult(expected1, output1, 0.01);

		double[][] o1Sigmoid = neuralNetwork.applyActivationFunction(output1);
		double[][] expectedO1Sigmoid = new double[][]{
				{0.761},
				{0.603},
				{0.650}};
		TestUtil.testMatrixEqualsResult(expectedO1Sigmoid, o1Sigmoid, 0.01);
	}

	@Test
	@Order(2)
	public void SecondLayer() {
		double[][] inputs = new double[][]{
				{0.761},
				{0.603},
				{0.650}};

		double[][] fl2L = new double[][]{
				{0.3, 0.7, 0.5},
				{0.6, 0.5, 0.2},
				{0.8, 0.1, 0.9}
		};

		double[][] expected2 = new double[][]{
				{0.975},
				{0.888},
				{1.254}};

		double[][] expectedO2Sigmoid = new double[][]{
				{0.726},
				{0.708},
				{0.778}};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] output2 = neuralNetwork.getWeightedSum(fl2L, inputs);

		TestUtil.testMatrixEqualsResult(expected2, output2, 0.01);

		double[][] o2Sigmoid = neuralNetwork.applyActivationFunction(output2);
		TestUtil.testMatrixEqualsResult(expectedO2Sigmoid, o2Sigmoid, 0.01);
	}

	@Test
	public void calculateProportionalWHOError() {
		double[][] target = {{1}, {0.5}, {0.3}};
		double[][] output = new double[][]{
				{0.726},
				{0.708},
				{0.778}};

		double[][] fl2L = new double[][]{
				{0.3, 0.7, 0.5},
				{0.6, 0.5, 0.2},
				{0.8, 0.1, 0.9}
		};

		double[][] expected = new double[][]{
				{-0.21},
				{-0.04},
				{-0.15}
		};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] error = neuralNetwork.calculateError(target, output);


		double[][] proportionalMatrix = neuralNetwork.calculateProportionalMatrix(fl2L);
		double[][] actual = MatrixCalculator.multiplyMatrix(proportionalMatrix, error);

		TestUtil.testMatrixEqualsResult(expected, actual, 0.01);
	}

	@Test
	public void calculateProportionalWIHError() {
		double[][] inFL = new double[][]{
				{0.9, 0.3, 0.4},
				{0.2, 0.8, 0.2},
				{0.1, 0.5, 0.6}
		};

		double[][] eL2 = new double[][]{
				{-0.25},
				{0.030769231},
				{-0.20925}
		};

		NeuralNetwork neuralNetwork = new NeuralNetwork(new SigmoidActivationFunction());
		double[][] proportionalMatrix = neuralNetwork.calculateProportionalMatrix(inFL);

		MatrixPrinter.printMatrix(MatrixCalculator.transposeMatrix(proportionalMatrix));
	}
}
