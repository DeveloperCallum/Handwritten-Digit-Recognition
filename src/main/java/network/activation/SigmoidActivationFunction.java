package network.activation;

public class SigmoidActivationFunction implements ActivationFunction{
	@Override
	public double[] Activation(double[] summedWeightOutput) {
		double[] output = new double[summedWeightOutput.length];

		for (int i = 0; i < output.length; i++) {
			output[i] = Activation(summedWeightOutput[i]);
		}

		return output;
	}

	@Override
	public double Activation(double summedWeightOutput) {
		return 1 / (1 + Math.exp(-summedWeightOutput));
	}
}
