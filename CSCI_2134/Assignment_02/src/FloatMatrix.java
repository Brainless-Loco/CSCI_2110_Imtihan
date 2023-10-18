import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

/**
 * The FloatMatrix class represents a matrix of floating point numbers.
 */
public class FloatMatrix {

    /* A small number for floating point comparison.*/
    public static final double EPSILON = 0.00001;
    public static final int DEFAULT_SIZE = 10;
    int nCols;
    int nRows;
    float[] entries;

    /**
     * Create a zero matrix of DEFAULT_SIZE.
     */
    public FloatMatrix() {
        this(DEFAULT_SIZE);
    }

    /**
     * Create a square zero matrix whose number of rows and columns equals size.
     * @param size: the number of rows in the square matrix to create.
     */
    public FloatMatrix(int size) {
        this(size, size);
    }

    /**
     * Create a rectangular zero matrix whose number of rows is rows
     * and number of columns is cols.
     * @param rows: the number of rows in the FloatMatrix to construct.
     * @param cols: the number of columns in the FloatMatrix to construct.
     */
    public FloatMatrix(int rows, int cols) {
        _init(rows, cols);
    }

    /**
     * Create a new FloatMatrix which is a copy of an existing FloatMatrix
     * @param other: the FloatMatrix to copy from.
     */
    public FloatMatrix(FloatMatrix other) {
        if (other == null) {
            _init(DEFAULT_SIZE, DEFAULT_SIZE);
            this.zero();
        } else {
            _init(other.rows(), other.columns());
            for (int i = 0; i < other.rows(); ++i) {
                for (int j = 0; j < other.columns(); ++j) {
                    this.set(i, j, other.get(i,j));
                }
            }
        }
    }

    /**
     * Create a FloatMatrix from an array of float values.
     * Each row of the matrix is determined by columns number of consecutive
     * values from the array of floats.
     * The number of rows in the constructed matrix is calculated automatically
     * from the length of the array and the number of columns specified.
     * If the length of the array is not divisible by the number of columns,
     * 0 will be assigned to the excess matrix entries in the last row.
     *
     * @param vals: array of float values to use as matrix entries
     * @param columns: the number of columns in the constructed matrix
     */
    public FloatMatrix(float[] vals, int columns) {
        if (vals == null) {
            _init(DEFAULT_SIZE, DEFAULT_SIZE);
            zero();
            return;
        }
        int numVals = vals.length;
        int rows = (int) Math.ceil((double) numVals/columns); //round up the division

        _init(rows, columns);
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (i*columns + j >= numVals) {
                    break;
                }
                this.set(i, j, vals[i*columns + j]);
            }
        }
    }

    /**
     * A simple private method to initialize the entries instance variable.
     * @param rows: number of rows.
     * @param cols: number of columns.
     */
    private void _init(int rows, int cols) {
        this.nRows = rows;
        this.nCols = cols;
        this.entries = new float[nRows*nCols];
    }

    /**
     * Return the number of columns in this FloatMatrix
     * @return the number of columns.
     */
    public int columns() {
        return this.nCols;
    }

    /**
     * Return the number of rows in this FloatMatrix
     * @return the number of rows.
     */
    public int rows() {
        return this.nRows;
    }

    /**
     * Set this matrix to have 0 in all entries.
     */
    public void zero() {
        int M = this.rows();
        int N = this.columns();
        for (int i = 0; i < M; ++i) {
            for (int j = 0; j < M; ++j) {
                this.set(i, j, 0.0f);
            }
        }
    }

    /**
     * Get the entry in this matrix at row i and column j.
     * Rows and columns are 0-indexed.
     * If i or j is negative, throw an exception.
     * If i is greater than or equal to the number of rows,
     * or if j is greater than or equal to the numbder of columns,
     * throw on exception.
     *
     * @param i: the 0-indexed row number.
     * @param j: the 0-indexed column number.
     * @return the entry of the matrix at (i,j)
     * @throws IndexOutOfBoundsException if row or column index is invalid.
     */
    public float get(int i, int j) throws IndexOutOfBoundsException {
        _validateIndices(i, j);
        return this.entries[i * this.columns() + j];
    }

    /**
     * Set the entry in this matrix at row i and column j.
     * Rows and columns are 0-indexed.
     * If i or j is negative, throw an exception.
     * If i is greater than or equal to the number of rows,
     * or if j is greater than or equal to the numbder of columns,
     * throw on exception.
     *
     * @param i: the 0-indexed row number.
     * @param j: the 0-indexed column number.
     * @param val: the value to set as the new entry at position (i,j).
     * @throws IndexOutOfBoundsException if row or column index is invalid.
     */
    public void set(int i, int j, float val) throws IndexOutOfBoundsException {
        _validateIndices(i, j);
        this.entries[i * this.columns() + j] = val;
    }

    /**
     * Right-multiply this FloatMatrix by the FloatMatrix other.
     * That is, this * other.
     *
     * If the matrix product is not defined (if the number of columns in this matrix
     * does not equal the number of rows in other), an ArithmeticException is thrown.
     * @param other: the right-hand matrix (i.e. the multiplicand)
     * @return the product of this FloatMatrix by other.
     * @throws ArithmeticException if the matrix product is undefined.
     */
    public FloatMatrix multiply(FloatMatrix other) throws ArithmeticException {
        if (this.columns() != other.rows()) {
            throw new ArithmeticException("Invalid Matrix dimensions for product.");
        }

        int prodRows = this.rows();
        int prodCols = other.columns();
        FloatMatrix product = new FloatMatrix(prodRows, prodCols);

        int i, j;  //indices in product matrix
        int k;     //index for dot product
        int N = this.columns(); // dot product length

        for (i = 0; i < prodRows; ++i) {
            for (j = 0; j < prodCols; ++j) {
                float entry = product.get(i, i);
                for (k = 0; k < N; ++k) {
                    entry += this.get(i,k) * other.get(k, j);
                }
                product.set(i, j, entry);
            }
        }
        return product;
    }

    /**
     * A simple private helper method that checks for valid
     * row and column indices.
     * If the indices are valid, do nothing.
     * If the indices are invalid, throw an exception.
     * @param i: the 0-indexed row number
     * @param j: the 0-indexed column number
     * @throws IndexOutOfBoundsException if either i or j is invalid for this matrix.
     */
    private void _validateIndices(int i, int j) throws IndexOutOfBoundsException {
        if (i < 0 || i >= this.rows()) {
            throw new IndexOutOfBoundsException();
        }
        if (j < 0 || j >= this.columns()) {
            throw new IndexOutOfBoundsException();
        }
    }


}


