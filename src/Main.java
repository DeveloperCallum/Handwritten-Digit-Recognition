import java.lang.reflect.Array;

public class Main {
	public static void main(String[] args) {
//        CSVToGrayscaleImage img = new CSVToGrayscaleImage(28, 28);
//        img.generateImageFromFile("image.csv");

		double[] inputs = new double[]{0.5, 1, 2};
		System.out.println("\nInputs: Inputs fed to the network.");
		printMatrix(inputs);

		double[][] InFl = new double[3][4];

		for (int row = 0; row < InFl.length; row++) {
			for (int column = 0; column < InFl[row].length; column++) {
				InFl[row][column] = NeuralNetwork.randomTwoDecimalNumber(7);
			}
		}

		System.out.println("\nInFL: Random Weights");
		printMatrix(InFl);

		NeuralNetwork neuralNetwork = new NeuralNetwork(inputs, InFl);
		double[] outputs = neuralNetwork.getWeightedSum();

		System.out.println("\nOutput: Before Activation Function!");
		printMatrix(outputs);

		System.out.println("\nOutput: After Activation Function!");
		printMatrix(neuralNetwork.applyActivationFunction(outputs));
	}

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