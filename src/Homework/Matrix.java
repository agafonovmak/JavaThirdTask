package Homework;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Matrix implements Cloneable {
    private int[][] elements;

    public Matrix() {
        elements = new int[0][0];
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Matrix result = new Matrix(getRowCount(), getColCount());

        for (int i = 0; i < getRowCount(); i++) {
            result.elements[i] = elements[i].clone();
        }

        return result;
    }

    public Matrix(int rowCount, int colCount) {
        elements = new int[rowCount][colCount];
    }

    public int getRowCount() {
        return elements.length;
    }

    public int getColCount() {
        return elements[0].length;
    }

    public int getElement(int row, int col) {
        if (row > elements.length || col > elements[row].length) {
            throw new IllegalArgumentException();
        }

        return elements[row][col];
    }

    public void setElement(int row, int col, int element) {
        if (row > elements.length || col > elements[row].length) {
            throw new IllegalArgumentException();
        }

        elements[row][col] = element;
    }

    public Matrix add(Matrix right) {
        if (getRowCount() != right.getRowCount()) {
            return new Matrix();
        }
        if (getColCount() != right.getColCount()) {
            return new Matrix();
        }

        Matrix result = new Matrix(getRowCount(), getColCount());

        for (int row = 0; row < getRowCount(); row++) {
            for (int col = 0; col < getColCount(); col++) {
                result.setElement(row, col, getElement(row, col) + right.getElement(row, col));
            }
        }

        return result;
    }

    private int[] getColumn(int columnNumber) {
        int[] result = new int[getRowCount()];

        for (int i = 0; i < getRowCount(); i++) {
            result[i] = getElement(i, columnNumber);
        }

        return result;
    }

    private int[] getRow(int rowNumber) {
        int[] result = new int[getRowCount()];

        for (int i = 0; i < getRowCount(); i++) {
            result[i] = getElement(rowNumber, i);
        }

        return result;
    }

    public Matrix multiply(Matrix right) {
        if (getColCount() != right.getRowCount()) {
            return new Matrix();
        }

        Matrix result = new Matrix(getRowCount(), getColCount());
        for (int rowNumber = 0; rowNumber < getRowCount(); rowNumber++) {
            for (int colNumber = 0; colNumber < right.getColCount(); colNumber++) {
                result.setElement(rowNumber, colNumber,
                        Homework.ArrayUtils.multiply(getRow(rowNumber), right.getColumn(colNumber)));

            }
        }

        return result;
    }

    public Matrix removeRowAndCol(int row, int col) {
        Matrix result = new Matrix(getRowCount() - 1, getColCount() - 1);

        for (int rowNumber = 0; rowNumber < getRowCount(); rowNumber++) {

            if (rowNumber == row) {//Пропускаем строку row
                continue;
            }

            for (int colNumber = 0; colNumber < getColCount(); colNumber++) {

                if (colNumber == col) {
                    continue;
                }

                int resultRow = rowNumber;
                int resultCol = colNumber;

                if (rowNumber > row) {
                    resultRow--;
                }
                if (colNumber > col) {
                    resultCol--;
                }

                result.setElement(resultRow, resultCol, getElement(rowNumber, colNumber));
            }
        }
        return result;
    }

    public int getDeterminant() {
        if (getColCount() == 2 && getRowCount() == 2) {
            return elements[0][0] * elements[1][1] - elements[1][0] * elements[0][1];
        }

        int determinant = 0;
        for (int i = 0; i < getColCount(); i++) {
            determinant += getCofactor(0, i) * getElement(0, i);
        }

        return determinant;
    }

    private int getMinor(int row, int col) {
        return removeRowAndCol(row, col).getDeterminant();
    }

    private int getCofactor(int row, int col) {
        return (int) Math.pow(-1, row + col) * getMinor(row, col);
    }

    public void print() {
        for (int i = 0; i < getRowCount(); i++) {
            for (int j = 0; j < getColCount(); j++) {
                System.out.print(String.valueOf(getElement(i, j)) + " ");
            }
            System.out.print("\n");
        }
    }

    public boolean equals(Matrix another) {
        return Arrays.deepEquals(this.elements, another.elements);
    }

}
