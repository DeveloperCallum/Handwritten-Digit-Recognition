package network;

public class MatrixCalculator {
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
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

    public static double[][] transposeMatrix(double[][] a) {
		double[][] results = new double[a[0].length][a.length];

        for (int rows = 0; rows < a.length; rows++) {
            for (int column = 0; column < a.length; column++) {
                double value = a[rows][column];
                results[column][rows] = value;
            }
        }

        return results;
    }
}
