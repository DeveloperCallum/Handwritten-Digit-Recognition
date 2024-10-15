package functionalTests;

import network.MatrixCalculator;
import org.junit.jupiter.api.Test;

public class MatrixTransposeTests {
    @Test
    public void transposeTest(){
        double[][] input = new double[][]{
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        double[][] expected = new double[][]{
                {1,4,7},
                {2,5,8},
                {3,6,9}
        };

        double[][] actual = MatrixCalculator.transposeMatrix(input);

        TestUtil.testMatrixEqualsResult(expected, actual, 0);
    }
}
