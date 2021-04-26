package com.company.Task4;


import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        int choice = 0;
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.println("1 - Create an array\n2 - Create a matrix\n3 - Change size of an array\n" +
                    "4 - Transform array to String and print it\n5 - Transform matrix to String and print it\n6 - Exit");
            System.out.print("Введите число от 1 до 5: ");
            choice = scan.nextInt();
            switch(choice) {
                case 1:
                    Task4.createAnArray();
                    break;
                case 2:
                    Task4.createAnMatrix();
                    break;
                case 3:
                    Task4.changeSizeOfAnArray();
                    break;
                case 4:
                    System.out.println(Task4.ArrToString());
                    break;
                case 5:
                    System.out.println(Task4.MatrixToString());
                case 6:
                    System.exit(4);
                    break;
                default:
                    System.out.println("Incorrect input!");
                    break;
            }
        }
    }

    }

