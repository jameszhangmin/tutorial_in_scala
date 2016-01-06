package com.airwalker.scala.advanced;

/**
 * @author: Zhang.Min
 * @since: 2016/1/6
 * @version: 1.7
 */
public class JavaConvariance {

    public static void main(String[] args) {
        String[] arr1 = {"abc"};
        Object[] arr2 = arr1;
        arr2[0] = new Integer(7);
        String s = arr1[0];
        System.out.println(arr1 + "\n" + arr2);
    }
}
