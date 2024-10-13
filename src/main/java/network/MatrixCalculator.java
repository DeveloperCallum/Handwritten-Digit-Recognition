package network;

public class MatrixCalculator {
	public static double[][] multiplyMatrix(double[][] a, double[][] b){
		if (a[0].length != b.length) {
			throw new IllegalArgumentException("Number of columns in inputs must be equal to the number of rows in the second");
		}

		double[][] result = new double[a.length][b[0].length];

		for (int resultRow = 0; resultRow < result.length; resultRow++) {
			for (int resultColumn = 0; resultColumn < result[resultRow].length; resultColumn++) {

				double[] multiplyRow = a[resultRow];

				for (int bRow = 0; bRow < b.length; bRow++) {
					double columnValue = b[bRow][resultColumn];

					result[resultRow][resultColumn] += multiplyRow[bRow] * columnValue;
				}
			}
		}

		return result;
	}
}
