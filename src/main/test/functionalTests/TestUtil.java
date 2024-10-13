package functionalTests;

import org.junit.Assert;

public class TestUtil {
	public static void testMatrixEqualsResult(double[][] expected, double[][] actual, double delta){
		for (int i = 0; i < actual.length; i++) {
			double[] actualArr = actual[i];
			double[] expectedArr = expected[i];

			Assert.assertArrayEquals("incorrect values", expectedArr, actualArr, delta);
		}
	}
}
