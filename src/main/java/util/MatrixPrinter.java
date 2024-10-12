package util;

public class MatrixPrinter {
	public static void printMatrix(double[][] array) {
		for (int row = 0; row < array.length; row++) {
			for (int column = 0; column < array[row].length; column++) {
				double weight = array[row][column];

				if (weight >= 0) {
					System.out.print("\t\t " + array[row][column] + ", ");
				} else {
					System.out.print("\t\t" + array[row][column] + ", ");
				}

			}

			System.out.print("\n");
		}
	}

	public static void printMatrix(double[] array) {
		for (int row = 0; row < array.length; row++) {
			double weight = array[row];

			if (weight >= 0) {
				System.out.print("\t " + array[row] + ", ");
			} else {
				System.out.print("\t" + array[row] + ", ");
			}

		}

		System.out.print("\n");
	}
}
