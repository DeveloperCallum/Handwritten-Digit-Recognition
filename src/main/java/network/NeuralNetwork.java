package network;

import network.activation.ActivationFunction;
import network.activation.SigmoidActivationFunction;

public class NeuralNetwork {
	private double[] inputs;
	private double[][] inFl; //Weights between the Input layer and the first Layer
	private double[][] fl2L; //Weights between the Input layer and the first Layer
	private final ActivationFunction activationFunction;

	@Deprecated
	public NeuralNetwork(double[] inputs, double[][] InFl) {
		this.inputs = inputs;
		this.inFl = InFl;
		this.activationFunction = new SigmoidActivationFunction();
	}

	@Deprecated
	public NeuralNetwork(double[] inputs, double[][] inFl, ActivationFunction activationFunction) {
		this.inputs = inputs;
		this.inFl = inFl;
		this.activationFunction = activationFunction;
	}

	@Deprecated
	public NeuralNetwork(double[] inputs, double[][] inFl, double[][] fl2L, ActivationFunction activationFunction) {
		this.inputs = inputs;
		this.inFl = inFl;
		this.fl2L = fl2L;
		this.activationFunction = activationFunction;
	}

	public NeuralNetwork(ActivationFunction activationFunction) {
		this.activationFunction = activationFunction;
	}

	@Deprecated
	public double[] getWeightedSum() {
		return getWeightedSum(inputs, inFl);
	}

	public double[] getWeightedSum(double[] inputs, double[][] weights) {
		if (inputs.length != weights.length) {
			throw new IllegalArgumentException("Number of columns in inputs must be equal to the number of rows in the second");
		}
		//Create an array to store the outputs
		double[] output = new double[weights[0].length];
		//for every input
		for (int row = 0; row < weights.length; row++) {
			double w = 0;
			for (int column = 0; column < weights[0].length; column++) {
				w += weights[row][column] * inputs[column];
			}
			output[row] = w;
		}

		return output;
	}

	public double[] applyActivationFunction(double[] summedWeightOutput){
		return activationFunction.Activation(summedWeightOutput);
	}

	public double[][] generateWeightMatrix(int rowNum, int columnNum){

		double[][] matrix = new double[rowNum][columnNum];

		for (int row = 0; row < matrix.length; row++) {
			for (int column = 0; column < matrix[row].length; column++) {
				matrix[row][column] = NeuralNetwork.randomTwoDecimalNumber(7);
			}
		}

		return matrix;
	}

	public static double randomTwoDecimalNumber(int sumFanInFanOut) {
		double r = Math.random();
		double num = Math.pow(sumFanInFanOut, -0.5);

		return r * (num - (-num)) + (-num);
	}
}
