package org.example;

public class Main {
    public static void main(String[] args) {
        Integer[] a1 = {1, 2, 3, 4, 5};
        Integer[] a2 = {1, 2, 3, 4, 5};
        Integer[] result = ArrayUnion(a1, a2);
    }
    public static Integer[] ArrayUnion(Integer[] array1, Integer[] array2) {
        Integer[] finalResult = {};
        int lengthCount = 0;
        try {
            if (array1 == null || array2 == null) {
                throw new NullPointerException("null");
            }
            Integer m = array1.length;
            Integer n = array2.length;
            Integer[] result = new Integer[m + n];
            Integer i = 0, j = 0, k = 0;
            while (i < m && j < n) {
                if (array1[i] < array2[j]) {
                    result[k++] = array1[i++];
                    lengthCount++;
                } else if (array2[j] < array1[i]) {
                    result[k++] = array2[j++];
                    lengthCount++;
                } else {
                    result[k++] = array2[j++];
                    i++;
                    lengthCount++;
                }
            }
            while (i < m) {
                result[k++] = array1[i++];
                lengthCount++;
            }
            while (j < n) {
                result[k++] = array2[j++];
                lengthCount++;
            }
            finalResult = new Integer[lengthCount];
            for (int size = 0; size < lengthCount; size++) {
                finalResult[size] = result[size];
            }
        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return finalResult;
    }
}