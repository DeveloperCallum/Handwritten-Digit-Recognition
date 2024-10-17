package network;

import network.activation.ActivationFunction;
import network.activation.SigmoidActivationFunction;

public class NeuralNetwork {
	private final ActivationFunction activationFunction;

	public NeuralNetwork(ActivationFunction activationFunction) {
		this.activationFunction = activationFunction;
	}

	public double[][] getWeightedSum(double[][] weights, double[][] inputs) {
		return MatrixCalculator.multiplyMatrix(weights, inputs);
	}

	public double[][] generateWeightMatrix(int rowNum, int columnNum) {
		double[][] matrix = new double[rowNum][columnNum];

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = NeuralNetwork.randomTwoDecimalNumber(7);
			}
		}

		return matrix;
	}

	public double[][] calculateProportionalMatrix(double[][] weights){
		double[][] proportionalMatrix = new double[weights.length][weights[0].length];

		for (int row = 0; row < weights.length; row++) { //For every row in the weight matrix.
			for (int column = 0; column < weights[row].length; column++) { //For every column in the weight matrix.
				double currentWeight = weights[row][column]; //Get the current weight
				double weightSum = 0; //Calculate the sum

				for (int sumRow = 0; sumRow < weights.length; sumRow++) {
					weightSum += weights[sumRow][column];
				}

				proportionalMatrix[row][column] = currentWeight / weightSum;
			}
		}

		return proportionalMatrix;
	}

	public double[][] applyActivationFunction(double[][] value) {
		return activationFunction.activation(value);
	}

	public double[][] calculateError(double[][] target, double[][] output) {
		double[][] results = new double[target.length][1];

		for (int i = 0; i < results.length; i++) {
			double e = target[i][0] - output[i][0];
			results[i][0] = Math.pow(e, 2);
		}

		return results;
	}

	public static double randomTwoDecimalNumber(int sumFanInFanOut) {
		double r = Math.random();
		double num = Math.pow(sumFanInFanOut, -0.5);

		return r * (num - (-num)) + (-num);
	}
}
