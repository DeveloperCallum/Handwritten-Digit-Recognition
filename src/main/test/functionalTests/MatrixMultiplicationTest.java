package functionalTests;

import network.MatrixCalculator;
import org.junit.Test;

public class MatrixMultiplicationTest {

	@Test
	public void MatrixTestOne() {
		double[][] a = new double[][]{
				{1, 2, 3},
				{4, 5, 6}};

		double[][] b = new double[][]{
				{7, 8},
				{9, 10},
				{11, 12}};

		double[][] result = MatrixCalculator.multiplyMatrix(a, b);
		double[][] expected = new double[][]{
				{58, 64},
				{139, 154}
		};

		TestUtil.testMatrixEqualsResult(expected, result, 0.01);
	}

	@Test
	public void MatrixTestTwo() {
		double[][] a = new double[][]{
				{1, 2, 3},
				{4, 5, 6}};

		double[][] b = new double[][]{
				{7},
				{9},
				{11}};

		double[][] result = MatrixCalculator.multiplyMatrix(a, b);
		double[][] expected = new double[][]{
				{58},
				{139}
		};

		TestUtil.testMatrixEqualsResult(expected, result, 0.01);
	}

	@Test
	public void MatrixTestThree() {
		double[][] a = new double[][]{
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}};

		double[][] b = new double[][]{
				{7},
				{9},
				{11}};

		double[][] result = MatrixCalculator.multiplyMatrix(a, b);
		double[][] expected = new double[][]{
				{58},
				{139},
				{220}
		};

		TestUtil.testMatrixEqualsResult(expected, result, 0.01);
	}

	@Test
	public void MatrixTestFour() {
		double[][] b = new double[][]{
				{0.9},
				{0.1},
				{0.8}};

		double[][] a = new double[][]{
				{0.9, 0.3, 0.4},
				{0.2, 0.8, 0.2},
				{0.1, 0.5, 0.6}};

		double[][] result = MatrixCalculator.multiplyMatrix(a, b);
		double[][] expected = new double[][]{
				{1.16},
				{0.42},
				{0.62}
		};

		TestUtil.testMatrixEqualsResult(expected, result, 0.01);
	}
}
