public class NeuralNetwork {
	private double[] inputs;

	//Weights between the Input layer and the first Layer
	private double[][] InFl;

	public NeuralNetwork(double[] inputs, double[][] InFl) {
		this.inputs = inputs;
		this.InFl = InFl;
	}

	public double[] getWeightedSum() {
		if (inputs.length != InFl.length) {
			throw new IllegalArgumentException("Number of columns in inputs must be equal to the number of rows in the second");
		}
		//Create an array to store the outputs
		double[] outputs = new double[inputs.length];
		//for every input
		for (int input = 0; input < inputs.length; input++) {
			double weight = 0;
			//for every row in the weights matrix
			for (int row = 0; row < InFl.length; row++) {
				weight += InFl[row][input];
			}

			outputs[input] = weight;
		}

		return outputs;
	}

	public double[] applyActivationFunction(double[] summedWeightOutput){
		double[] output = new double[summedWeightOutput.length];

		for (int i = 0; i < output.length; i++) {
			output[i] = sigmoidFunction(summedWeightOutput[i]);
		}

		return output;
	}

	protected static double randomTwoDecimalNumber(int sumFanInFanOut) {
		double r = Math.random();
		double num = Math.pow(sumFanInFanOut, -0.5);

		return r * (num - (-num)) + (-num);
	}

	protected static double sigmoidFunction(double num) {
		return Math.pow((1) / (1 + Math.E), -num);
	}
}
