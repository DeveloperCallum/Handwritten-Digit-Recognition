import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CSVToGrayscaleImage {
    private int height;
    private int width;

    /**
     * Turn a single line grayscale image stored in csv into a png image.
     * @param height Height of the image
     * @param width Width of the image.
     */
    public CSVToGrayscaleImage(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void generateImageFromFile(String pathToFile) {
        try {
            // Read CSV data (replace with your actual CSV file)
            BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
            String line = reader.readLine();
            BufferedImage image = createImage(line);
            reader.close();

            // Save the image (optional)
            ImageIO.write(image, "PNG", new File("output.png"));

            // Display the image (you can use a Swing JFrame here)
            // ...

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateImageFromString(String grayscaleCSV) {
        try {
            // Read CSV data (replace with your actual CSV file)
            String line = grayscaleCSV;
            BufferedImage image = createImage(line);

            // Save the image (optional)
            ImageIO.write(image, "PNG", new File("output.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private BufferedImage createImage(String line) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_GRAY);

        // Assign pixel values from CSV data
        for (int y = 0; y < height; y++) {
            String[] values = line.split(",");
            for (int x = 0; x < width; x++) {
                int intensity = Integer.parseInt(values[(y * 28) + x]);
                image.setRGB(x, y, (intensity << 16) | (intensity << 8) | intensity);
            }
        }

        return image;
    }
}