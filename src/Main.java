public class Main {
    public static void main(String[] args) {
        CSVToGrayscaleImage img = new CSVToGrayscaleImage(28, 28);
        img.generateImageFromFile("image.csv");
    }
}