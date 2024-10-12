import network.NeuralNetwork;
import util.MatrixPrinter;

public class Main {
	public static void main(String[] args) {
//        ImageGeneration.CSVToGrayscaleImage img = new ImageGeneration.CSVToGrayscaleImage(28, 28);
//        img.generateImageFromFile("image.csv");

		double[] inputs = new double[]{0.5, 1, 2};
		System.out.println("\nInputs: Inputs fed to the network.");
		MatrixPrinter.printMatrix(inputs);

		double[][] InFl = new double[3][4];

		for (int row = 0; row < InFl.length; row++) {
			for (int column = 0; column < InFl[row].length; column++) {
				InFl[row][column] = NeuralNetwork.randomTwoDecimalNumber(7);
			}
		}

		System.out.println("\nInFL: Random Weights");
		MatrixPrinter.printMatrix(InFl);

		NeuralNetwork neuralNetwork = new NeuralNetwork(inputs, InFl);
		double[] outputs = neuralNetwork.getWeightedSum();

		System.out.println("\nOutput: Before Activation Function!");
		MatrixPrinter.printMatrix(outputs);

		System.out.println("\nOutput: After Activation Function!");
		MatrixPrinter.printMatrix(neuralNetwork.applyActivationFunction(outputs));
	}
}