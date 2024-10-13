package network.activation;

public class SigmoidActivationFunction implements ActivationFunction{
	@Override
	public double[][] activation(double[][] value) {
		double[][] result = new double[value.length][];

		for (int row = 0; row < result.length; row++) {
			result[row] = activation(value[row]);
		}

		return result;
	}

	@Override
	public double[] activation(double[] summedWeightOutput) {
		double[] output = new double[summedWeightOutput.length];

		for (int i = 0; i < output.length; i++) {
			output[i] = activation(summedWeightOutput[i]);
		}

		return output;
	}

	@Override
	public double activation(double summedWeightOutput) {
		return 1 / (1 + Math.exp(-summedWeightOutput));
	}


}
