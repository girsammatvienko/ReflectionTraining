package com.company.Task1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException {
    int choice = 0;
    Scanner scan = new Scanner(System.in);
    while(true) {
        System.out.println("1 - Получить информацию по полному имени типа\n2 - Выход\n");
        System.out.print("Введите число от 1 до 2: ");
        choice = scan.nextInt();
    switch(choice) {
        case 1:
            System.out.println(Task1.getInfo(getType()));
            break;
        case 2:
            System.exit(0);
            break;
        default:
            System.out.println("Выберите пункт от 1 до 2");
            break;
    }
    }
    }
    public static String getType() {
        System.out.print("Введите полное имя типа: ");
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        return s;
    }
}
