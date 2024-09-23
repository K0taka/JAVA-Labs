package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * LR2 in HSE Perm (in Java instead of C#)
 * 1. In all tasks I should use console input via keyboard
 * 2. I mustn't use arrays
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tasks task = chooseTask(scanner);
        activateTask(scanner, task);
    }

    private static int getInt(Scanner scanner){
        boolean isCorrect = false;
        int number = 0;
        do {
            try {
                number = scanner.nextInt();
                isCorrect = true;
            } catch (InputMismatchException e) {
                System.out.printf("There is an error in input data, make sure it is integer number from %d to %d >>> ",
                        Integer.MIN_VALUE, Integer.MAX_VALUE);
            }
        } while (!isCorrect);
        return number;
    }

    private static Tasks chooseTask(Scanner scanner){
        System.out.println("Choose task:");
        System.out.println("1. Task 1: The sequence of n integer numbers. Find the sum of min and max");
        System.out.println("2. Task 2: The sequence of integer numbers. Find the place of min");
        System.out.println("3. Task 3: Determine if the k is the pow of 3");
        System.out.println("4. Exit");
        System.out.print("Select task by its number >>> ");

        boolean isCorrect = false;
        Tasks choose = null;

        do {
            int number = getInt(scanner);
            switch (number){
                case 1:
                    choose = Tasks.First;
                    isCorrect = true;
                    break;
                case 2:
                    choose = Tasks.Second;
                    isCorrect = true;
                    break;
                case 3:
                    choose = Tasks.Third;
                    isCorrect = true;
                    break;
                case 4:
                    choose = Tasks.Leave;
                    isCorrect = true;
                default:
                    System.out.printf("There is no such task! Number from 1 to %d >>> ", Tasks.values().length);
            }
        } while(!isCorrect);
        return choose;
    }

    private static void activateTask(Scanner scanner, Tasks task){
        switch (task){
            case Tasks.First -> firstTask(scanner);
            case Tasks.Second -> secondTask(scanner);
            case Tasks.Third -> thirdTask(scanner);
            case Tasks.Leave -> System.exit(0);
        }
    }

    private static void firstTask(Scanner scanner){

    }

    private static void secondTask(Scanner scanner){

    }

    private static void thirdTask(Scanner scanner){

    }
}