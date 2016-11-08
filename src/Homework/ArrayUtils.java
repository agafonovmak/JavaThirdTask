package Homework;

import java.util.Arrays;
import java.util.Random;

public class ArrayUtils {
    public static boolean compareIgnoreOrder(int[] first, int[] second) {
        if (first == null || second == null) {
            return false;
        }
        if (first.length != second.length) {
            return false;
        }

        int[] firstCopy = Arrays.copyOf(first, first.length);
        int[] secondCopy = Arrays.copyOf(second, second.length);

        Arrays.sort(firstCopy);
        Arrays.sort(secondCopy);

        for (int i = 0; i < firstCopy.length; i++) {
            if (firstCopy[i] != secondCopy[i]) {
                return false;
            }
        }
        return true;
    }

    public static int[] changeSize(int[] array, int size) {
        if (array != null) {
            int[] result = new int[size];

            result = Arrays.copyOf(array, Math.min(size, array.length));

            if (size > array.length) {
                for (int i = array.length; i < size; i++) {
                    result[i] = 0;
                }
            }

            return result;
        }
        else{
            return null;
        }
    }

    public static int[] shuffle(int[] array) {
        Random random = new Random();

        int[] result = new int[array.length];
        result = Arrays.copyOf(array, array.length);

        for (int i = 0; i < array.length; i++) {
            int position = random.nextInt(array.length - 1);
            swap(array, i, position);
        }

        return result;
    }

    public static void swap(int[] array, int first, int second) {
        int temp;
        temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static int multiply(int[] left, int[] right) {
        if (left.length != right.length) {
            throw new IllegalArgumentException();
        }

        int result = 0;
        for (int i = 0; i < left.length; i++) {
            result += left[i] * right[i];
        }

        return result;
    }

    public static String toString(int[] array) {
        String result = "";
        for (int i = 0; i < array.length; i++) {
            result += String.valueOf(array[i]);
            result += " ";
        }

        return result;
    }
}
