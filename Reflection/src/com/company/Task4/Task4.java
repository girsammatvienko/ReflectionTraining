package com.company.Task4;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task4 {
    private static Object arr;
    private static Object matrix;
    private static int m, n;

    public static Object createAnArray() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a type name: ");
        String className = scan.nextLine();
        System.out.print("Enter a size of an array: ");
        n = scan.nextInt();
        if (className.intern() == "byte" || className.intern() == "short"
                || className.intern() == "int" || className.intern() == "long"
                || className.intern() == "float" || className.intern() == "double"
                || className.intern() == "boolean") {
            String result = "";
            switch (className) {
                case "byte":
                    arr = new byte[n];
                    showAnArray(arr);
                    break;
                case "short":
                    arr = new short[n];
                    showAnArray(arr);
                    break;
                case "int":
                    arr = new int[n];
                    for(int i = 0;i < n;i++) {
                        Array.set(arr, i, i+1);
                    }
                    showAnArray(arr);
                    break;
                case "long":
                    arr = new long[n];
                    showAnArray(arr);
                    break;
                case "float":
                    arr = new float[n];
                    showAnArray(arr);
                    break;
                case "double":
                    arr = new double[n];
                    showAnArray(arr);
                    break;
                case "boolean":
                    arr = new boolean[n];
                    showAnArray(arr);
                    break;
                default:
                    System.out.print("Unknown type");
            }
        } else {
            Class c = Class.forName(className);
            arr = Array.newInstance(c, n);
            showAnArray(arr);
        }

        return arr;
    }

    public static void createAnMatrix() throws ClassNotFoundException {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a type name: ");
        String className = scan.nextLine();
        if (className.intern() == "byte" || className.intern() == "short"
                || className.intern() == "int" || className.intern() == "long"
                || className.intern() == "float" || className.intern() == "double"
                || className.intern() == "boolean") {
            System.out.print("Enter n and m: ");
            n = scan.nextInt();
            m = scan.nextInt();
            String result = "";
            switch (className) {
                case "byte":
                    matrix = Array.newInstance(byte.class, n, m);
                    showMatrix(matrix);
                    break;
                case "short":
                    matrix = Array.newInstance(short.class, n, m);
                    showMatrix(matrix);
                    break;
                case "int":
                    matrix = Array.newInstance(int.class, n, m);
                    int counter = 1;
                    for(int i = 0;i < Array.getLength(matrix);i++) {
                        for(int j = 0;j < Array.getLength(Array.get(matrix,i));j++) {
                            Array.set(Array.get(matrix,i),j,counter);
                            counter++;
                        }
                    }
                    showMatrix(matrix);
                    break;
                case "long":
                    matrix = Array.newInstance(long.class, n, m);
                    showMatrix(matrix);
                    break;
                case "float":
                    matrix = Array.newInstance(float.class, n, m);
                    showMatrix(matrix);
                    break;
                case "double":
                    matrix = Array.newInstance(double.class, n, m);
                    showMatrix(matrix);
                    break;
                case "boolean":
                    matrix = Array.newInstance(boolean.class, n, m);
                    showMatrix(matrix);
                    break;
                default:
                    System.out.print("Unknown type");
            }
        } else {
            Class c = Class.forName(className);
            System.out.print("Enter n and m: ");
            n = scan.nextInt();
            m = scan.nextInt();
            matrix = Array.newInstance(c, n, m);
            showMatrix(matrix);
        }
    }
    public static void changeSizeOfAnArray() {
        System.out.print("Enter a new size of an array: ");
        int n = Array.getLength(arr), size = new Scanner(System.in).nextInt();
        if (size < n) {
            Object newArr = Array.newInstance(arr.getClass().getComponentType(), size);
            for (int i = 0; i < Array.getLength(newArr); i++) {
                Array.set(newArr, i, Array.get(arr, i));
            }
            arr = newArr;
            showAnArray(arr);
        } else if (size > n) {
            Object newArr = Array.newInstance(arr.getClass().getComponentType(), size);
            for(int i = 0;i < Array.getLength(arr);i++) {
                Array.set(newArr, i, Array.get(arr, i));
            }
            arr = newArr;
            showAnArray(arr);
        }
    }
    public static String ArrToString() {
        String result = "";
        if(arr != null) {
            for (int i = 0; i < Array.getLength(arr); i++) {
                result += Array.get(arr, i) + " ";
            }
        }
        return result;
    }
    public static String MatrixToString() {
        String result = "";
        if(matrix != null) {
            for (int i = 0; i < Array.getLength(matrix); i++) {
                for (int j = 0; j < Array.getLength(Array.get(matrix, i)); j++) {
                    result += Array.get(Array.get(matrix, i), j) + " ";
                }
                result += "\n";
            }
        }
        return result;
    }
    private static void showAnArray(Object arr) {
            String result = arr.getClass().getTypeName() + " = {";
            for(int i = 0;i < Array.getLength(arr);i++) {
                result += Array.get(arr,i) + (i + 1 != Array.getLength(arr)? ", " : "");
            }
            result += "};";
            System.out.println(result);
    }

    public static void showMatrix(Object matrix) {
        String result = matrix.getClass().getTypeName() + " = {";
        int n = Array.getLength(matrix);
        for(int i = 0;i < Array.getLength(matrix);i++) {
            result += "{";
            for(int j = 0;j < Array.getLength(Array.get(matrix,i));j++) {
                result += Array.get(Array.get(matrix,i),j) + (i != m? ", ":"");
            }
            result += i + 1!= n? "}, ":"}";
        }
        result += "};";
        System.out.println(result);
    }


}
