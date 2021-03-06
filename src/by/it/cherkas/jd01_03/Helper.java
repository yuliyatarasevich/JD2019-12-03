package by.it.cherkas.jd01_03;


import java.util.Arrays;

public class Helper {


    static double findMin(double[] arr) {
        double[] res = new double[arr.length];
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }

            return min;
        }
    }

    static double findMax(double[] arr) {
        double[] res = new double[arr.length];
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;
        }
    }

     static void sort(double[] arr) {
        double[] a = {0.1, 0.2, 0.2, 0.1, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 0.0, 1.0};
        Arrays.sort(arr);
        for (int i =0 ; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();

    }
            }




