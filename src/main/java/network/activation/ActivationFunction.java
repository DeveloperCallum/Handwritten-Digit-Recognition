package network.activation;

public interface ActivationFunction {
	double[][] activation(double[][] value);
	double[] activation(double[] value);
	double activation(double value);
}
