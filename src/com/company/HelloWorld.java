package com.company;

import java.util.Scanner;

public class HelloWorld {
    public static int add(int i, int j) {
        int add = i + j;
        return add;
    }

    public void main2(String[] args) throws Exception {
        Scanner eingabe = new Scanner(System.in);

        System.out.println("Hello World!");
        System.out.println("Bitte geben Sie zwei Zahlen ein: ");
        int i = eingabe.nextInt();
        int j = eingabe.nextInt();
        int x = add(i, j);
        System.out.println("Die Zahlen " + i + " und " + j + " ergeben zusammen " + x + ".");
    }
}
