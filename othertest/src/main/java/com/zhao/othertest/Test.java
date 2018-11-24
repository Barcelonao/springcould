package com.zhao.othertest;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        String ver_one = "1.9.10c";
        String ver_two = "1.9.11a";
        String partten_num = "[a-zA-Z]";
        String partten_not_num = "[^a-zA-Z]";
        //先比较数字部分 再比较字母部分

        int res_one = compareNum(ver_one.replaceAll(partten_num, ""), ver_two.replaceAll(partten_num, ""));

        if (res_one == 0) {
            int res_two = compareNotNum(ver_one.replaceAll(partten_not_num, ""), ver_two.replaceAll(partten_not_num, ""));

            if (res_two == 1) {
                System.out.println(true);
            } else if (res_two == -1) {
                System.out.println(false);
            } else {
                System.out.println("版本号相等");
            }

        } else if (res_one == 1) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
        //2.0 test
       //3.0 test
      //3.3333 test
        //3.1 test
        //3.2 test
    }

    public static int compareNum(String versionOne, String versionTwo) {

        String[] versionOneStrs = versionOne.split("\\.");
        String[] versionTwoStrs = versionTwo.split("\\.");

        int i = 0;
        for (i = 0; i < versionOneStrs.length && i < versionTwoStrs.length; i++) {

            if (Integer.parseInt(versionOneStrs[i]) > Integer.parseInt(versionTwoStrs[i])) {
                return 1;
            } else if (Integer.parseInt(versionOneStrs[i]) < Integer.parseInt(versionTwoStrs[i])) {
                return -1;
            }
        }

        if (i < versionOneStrs.length) {
            return 1;
        } else if (i < versionTwoStrs.length) {
            return -1;
        } else {
            return 0;
        }


    }

    //假定只有最后一位版本号存在字母 若三位均存在字母与比较数字的思路一值
    public static int compareNotNum(String versionOne, String versionTwo) {
        byte[] versionOneBytes = versionOne.getBytes();
        byte[] versionTwoBytes = versionTwo.getBytes();
        int i = 0;

        for (i = 0; i < versionOneBytes.length && i < versionTwoBytes.length; i++) {
            if (versionOneBytes[i] > versionTwoBytes[i]) {
                return 1;
            } else if (versionOneBytes[i] < versionTwoBytes[i]) {
                return -1;
            }
        }

        if (i < versionOneBytes.length) {
            return 1;
        } else if (i < versionTwoBytes.length) {
            return -1;
        } else {
            return 0;
        }
    }
}
