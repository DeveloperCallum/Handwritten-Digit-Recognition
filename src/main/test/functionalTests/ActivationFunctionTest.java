package functionalTests;

import network.activation.ActivationFunction;
import network.activation.SigmoidActivationFunction;
import org.junit.Assert;
import org.junit.Test;

public class ActivationFunctionTest {

	@Test
	public void sigmoidTest(){
		ActivationFunction activationFunction = new SigmoidActivationFunction();

		double output = activationFunction.activation(1.386);
		double expected = 0.80;
		double delta = 0.1;

		Assert.assertEquals("Sigmoid Function producing incorrect values", expected, output, delta);
	}
}
