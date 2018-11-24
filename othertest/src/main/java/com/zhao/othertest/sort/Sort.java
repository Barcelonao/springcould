package com.zhao.othertest.sort;

import java.util.Arrays;

public class Sort {


    static int num[] = {45, 78, 132, 854, 8, 45, 46123, 86, 879, 789564, 123, 8645, 879, 7849, 156, 123, 564, 8794897, 894, 654, 13223, 45, 56, 898, 97, 546};

    static int[] num_one = {1, 3, 5, 7, 9};
    static int[] num_two = {2, 4, 6, 8, 10, 11};


    public static void main(String[] args) {
        //xuanze(num);
        //maopao(num);
        //kuaipai(num, 0, num.length - 1);
        //[8, 45, 45, 45, 56, 78, 86, 97, 123, 123, 132, 156, 546, 564, 654, 854, 879, 879, 894, 898, 7849, 8645, 13223, 46123, 789564, 8794897]
        //[8, 45, 45, 45, 56, 78, 86, 97, 123, 123, 132, 156, 546, 564, 654, 854, 879, 879, 894, 898, 7849, 8645, 13223, 46123, 789564, 8794897]
        // System.out.println(Arrays.toString(num));

        int[] hebing = hebing(num_one, num_two);

        System.out.println(Arrays.toString(hebing));

    }

    public static void xuanze(int num[]) {

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {

                if (num[i] > num[j]) {
                    int temp = num[i];
                    num[i] = num[j];
                    num[j] = temp;
                }

            }
        }

        System.out.println(Arrays.toString(num));

    }

    public static void maopao(int num[]) {
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = 0; j < num.length - 1 - i; j++) {
                if (num[j] > num[j + 1]) {
                    int temp = num[j];
                    num[j] = num[j + 1];
                    num[j + 1] = temp;
                }
            }
        }
    }

    public static void kuaipai(int num[], int low, int high) {


        if (low >= high) {
            return;
        }

        int flag = num[low];
        int end = high;

        while (low < high) {
            while (low < high && num[high] >= flag) {
                high--;
            }
            num[low] = num[high];
            while (low < high && num[low] < flag) {
                low++;
            }
            num[high] = num[low];

        }
        num[low] = flag;

        kuaipai(num, 0, low - 1);
        kuaipai(num, low + 1, end);

    }

    public static int[] hebing(int a[], int b[]) {

        int[] c = new int[a.length + b.length];

        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                c[k] = a[i];
                i++;
            } else {
                c[k] = b[j];
                j++;
            }
            k++;
        }

        while (i < a.length) {

            c[k] = a[i];
            k++;
            i++;
        }

        while (j < b.length) {
            c[k] = b[j];
            j++;
            k++;
        }
        return c;
    }
}
