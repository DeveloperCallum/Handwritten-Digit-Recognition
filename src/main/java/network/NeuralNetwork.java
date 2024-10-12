package network;

import network.activation.ActivationFunction;
import network.activation.SigmoidActivationFunction;

public class NeuralNetwork {
	private double[] inputs;
	private double[][] InFl; //Weights between the Input layer and the first Layer
	private final ActivationFunction activationFunction;

	public NeuralNetwork(double[] inputs, double[][] InFl) {
		this.inputs = inputs;
		this.InFl = InFl;
		this.activationFunction = new SigmoidActivationFunction();
	}

	public NeuralNetwork(double[] inputs, double[][] inFl, ActivationFunction activationFunction) {
		this.inputs = inputs;
		InFl = inFl;
		this.activationFunction = activationFunction;
	}

	public double[] getWeightedSum() {
		if (inputs.length != InFl.length) {
			throw new IllegalArgumentException("Number of columns in inputs must be equal to the number of rows in the second");
		}
		//Create an array to store the outputs
		double[] outputs = new double[InFl[0].length];
		//for every input
		for (int column = 0; column < InFl[0].length; column++) {
			double weight = 0;
			//for every row in the weights matrix
			for (int row = 0; row < InFl.length; row++) {
				weight += InFl[row][column] * inputs[row];
			}

			outputs[column] = weight;
		}

		return outputs;
	}

	public double[] applyActivationFunction(double[] summedWeightOutput){
		return activationFunction.Activation(summedWeightOutput);
	}

	public static double randomTwoDecimalNumber(int sumFanInFanOut) {
		double r = Math.random();
		double num = Math.pow(sumFanInFanOut, -0.5);

		return r * (num - (-num)) + (-num);
	}
}
