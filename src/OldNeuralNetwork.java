public class OldNeuralNetwork {
    private int inputNodes;
    private int hiddenNodes; // 2 layers.
    private int outputNodes;
    private float learningRate;

    private double[][] wih;
    private double[][] who;
    private int[] o;

    public OldNeuralNetwork(int inputNodes, int hiddenNodes, int outputNodes, float learningRate) {
        this.inputNodes = inputNodes;
        this.hiddenNodes = hiddenNodes;
        this.outputNodes = outputNodes;
        this.learningRate = learningRate;

        //Weights
        wih = new double[hiddenNodes][inputNodes];
        who = new double[outputNodes][hiddenNodes];

        for (int a = 0; a < wih.length; a++) {
            for (int b = 0; b < wih.length; b++) {
                wih[a][b] = randomTwoDecimalNumber(hiddenNodes + inputNodes);
            }
        }

        for (int a = 0; a < who.length; a++) {
            for (int b = 0; b < who.length; b++) {
                who[a][b] = randomTwoDecimalNumber(outputNodes + hiddenNodes);
            }
        }
    }

    public void train(int[] input) {

    }

    public void query() {

    }

    protected static double randomTwoDecimalNumber(int linkSize) {
        double r = Math.random();
        double num = Math.pow(linkSize, -0.5);

        return r * (num - (-num)) + (-num);
    }

    protected static double sigmoidFunction(double num) {
        return Math.pow((1) / (1 + Math.E), -num);
    }
}
