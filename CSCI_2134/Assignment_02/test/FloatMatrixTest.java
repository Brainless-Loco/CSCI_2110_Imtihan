import java.awt.datatransfer.FlavorEvent;

import static org.junit.jupiter.api.Assertions.*;

class FloatMatrixTest {

    static final float[] testMatSmall = {1.0f};
    static final float[] testMat1 = {1.0f, 2.0f, 3.0f, 4.0f};
    static final float[] testMat2 = {1.0f, 2.0f, 3.0f, 4.0f, 5.0f, 6.0f};
    static final float[] testMat3 = {4.0f, 3.0f, 2.0f, 1.0f};

    void assertEqualsFloat(float expected, float actual) {
        assertTrue(Math.abs(expected-actual) < FloatMatrix.EPSILON);
    }

    @org.junit.jupiter.api.Test
    void columns_one() {
        FloatMatrix M = new FloatMatrix(testMatSmall, 1);
        assertEquals(1, M.columns());
    }

    @org.junit.jupiter.api.Test
    void columns_square() {
        FloatMatrix M = new FloatMatrix(testMat1, 2);
        assertEquals(2, M.columns());
    }

    @org.junit.jupiter.api.Test
    void columns_wide() {
        FloatMatrix M = new FloatMatrix(testMat2, 3);
        assertEquals(3, M.columns());
    }

    @org.junit.jupiter.api.Test
    void columns_narrow() {
        FloatMatrix M = new FloatMatrix(testMat2, 2);
        assertEquals(2, M.columns());
    }

    @org.junit.jupiter.api.Test
    void rows_one() {
        FloatMatrix M = new FloatMatrix(testMatSmall, 1);
        assertEquals(1, M.rows());
    }

    @org.junit.jupiter.api.Test
    void rows_square() {
        FloatMatrix M = new FloatMatrix(testMat1, 2);
        assertEquals(2, M.rows());
    }

    @org.junit.jupiter.api.Test
    void rows_wide() {
        FloatMatrix M = new FloatMatrix(testMat2, 3);
        assertEquals(2, M.rows());
    }

    @org.junit.jupiter.api.Test
    void rows_narrow() {
        FloatMatrix M = new FloatMatrix(testMat2, 2);
        assertEquals(3, M.rows());
    }

    @org.junit.jupiter.api.Test
    void get() {
        FloatMatrix M = new FloatMatrix(testMat1, 2);
        assertEquals(1.0f, M.get(0, 0),"Didn't get the actual value at 0,0 for testmat1 and Columns = 2");
        assertEquals(4.0f, M.get(1, 1),"Didn't get the actual value at 1,1 for testmat1 and Columns = 2");
        FloatMatrix M1 = new FloatMatrix(testMat2, 3);
        assertEquals(1.0f, M.get(0, 0),"Didn't get the actual value at 0,0 for testmat2 and Columns = 3");
        assertEquals(6.0f, M.get(1, 2),"Didn't get the actual value at 1,2 for testmat2 and Columns = 3");
    }

    @org.junit.jupiter.api.Test
    void set() {
        FloatMatrix M = new FloatMatrix(testMat2, 2);
        M.set(1, 1, 10.0f);
        assertEquals(10.0f, M.get(1, 1),"Didn't set the value 10.0f at 1,1 for testMat2 and Columns = 2");
    }

    @org.junit.jupiter.api.Test
    void zero() {
        FloatMatrix M = new FloatMatrix(testMat2, 2);
        M.zero();
        assertEquals(0.0f, M.get(0, 0),"Didn't set the value 0 at 0,0 for testMat2 and Columns = 2");
        assertEquals(0.0f, M.get(2, 1),"Didn't set the value 0 at 2,1 for testMat2 and Columns = 2");
    }
    
    @org.junit.jupiter.api.Test
    void multiply() {
        FloatMatrix M1 = new FloatMatrix(testMat1, 2);
        FloatMatrix M2 = new FloatMatrix(testMat2, 3);
        FloatMatrix product = M1.multiply(M2);

        float[] ansProduct = {22.0f, 28.0f, 49.0f, 64.0f};
        FloatMatrix shouldReturn = new FloatMatrix(ansProduct, 2);

        assertEquals(shouldReturn.columns(), product.columns(),"Row number of Product Matrix doesn't match");
        assertEquals(shouldReturn.rows(), product.rows(),"Column number of Product Matrix doesn't match");

        for (int i = 0; i < shouldReturn.rows(); i++) {
            for (int j = 0; j < shouldReturn.columns(); j++) {
                assertEquals(shouldReturn.get(i, j), product.get(i, j),"Wrong Multiplication result at "+i+","+j);
            }
        }
    }

}
