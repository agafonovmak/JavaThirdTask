package Test;

import Homework.Matrix;
import org.junit.Test;

import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void add() throws Exception {
        Matrix first = new Matrix(2, 2);

        first.setElement(0, 0, 1);
        first.setElement(0, 1, 5);
        first.setElement(1, 0, 9);
        first.setElement(1, 1, 2);

        Matrix second = new Matrix(2, 2);

        second.setElement(0, 0, 2);
        second.setElement(0, 1, 3);
        second.setElement(1, 0, 1);
        second.setElement(1, 1, 6);

        Matrix result = new Matrix(2, 2);

        result.setElement(0, 0, 3);
        result.setElement(0, 1, 8);
        result.setElement(1, 0, 10);
        result.setElement(1, 1, 8);

        Matrix sum = first.add(second);

        assertTrue(sum.equals(result));

    }

    @Test
    public void multiply() throws Exception {
        Matrix first = new Matrix(2, 2);

        first.setElement(0, 0, 1);
        first.setElement(0, 1, 5);
        first.setElement(1, 0, 9);
        first.setElement(1, 1, 2);

        Matrix second = new Matrix(2, 2);

        second.setElement(0, 0, 2);
        second.setElement(0, 1, 3);
        second.setElement(1, 0, 1);
        second.setElement(1, 1, 6);

        Matrix result = new Matrix(2, 2);

        result.setElement(0, 0, 7);
        result.setElement(0, 1, 33);
        result.setElement(1, 0, 20);
        result.setElement(1, 1, 39);

        Matrix multiplication = first.multiply(second);

        assertTrue(multiplication.equals(result));
    }

    @Test
    public void getDeterminant() throws Exception {
        Matrix a = new Matrix(4, 4);

        a.setElement(0, 0, 1);
        a.setElement(0, 1, 18);
        a.setElement(0, 2, 20);
        a.setElement(0, 3, 17);

        a.setElement(1, 0, 13);
        a.setElement(1, 1, 16);
        a.setElement(1, 2, 8);
        a.setElement(1, 3, 11);

        a.setElement(2, 0, 3);
        a.setElement(2, 1, 19);
        a.setElement(2, 2, 4);
        a.setElement(2, 3, 14);

        a.setElement(3, 0, 15);
        a.setElement(3, 1, 10);
        a.setElement(3, 2, 12);
        a.setElement(3, 3, 7);

        assertEquals(-656, a.getDeterminant());
    }

}