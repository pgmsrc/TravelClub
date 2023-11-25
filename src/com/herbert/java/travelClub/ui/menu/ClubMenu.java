package com.herbert.java.travelClub.ui.menu;

import com.herbert.java.travelClub.ui.console.ClubConsole;

import java.util.Scanner;

public class ClubMenu {

    private Scanner scanner;
    private ClubConsole console;

    public ClubMenu() {
        this.scanner = new Scanner(System.in);
        this.console = new ClubConsole();
    }
    public void show() {
        int inputNumber = 0;

        while(true) {
            displayMenu();
            inputNumber = selectMenu();
            System.out.println(inputNumber);
            switch (inputNumber) {
                case 1:
                    console.register();
                    break;
                case 2:
                    console.findAll();
                    break;
                case 3:
                    //
                    break;
                case 4:
                    //
                    break;
                case 5:
                    //
                    break;
                case 6:
                    //
                    break;
                case 0:
                    //
                    return;
                default:
                    System.out.println("Choose again!");
            }
        }
    }
    private void displayMenu() {
        System.out.println("----------------------------");
        System.out.println("Club Menu");
        System.out.println("----------------------------");
        System.out.println("1. Register");
        System.out.println("2. Find (All)");
        System.out.println("3. Find (ID)");
        System.out.println("4. Find (Name)");
        System.out.println("5. Modify");
        System.out.println("6. Remove");
        System.out.println("0. Previous");
    }

    private int selectMenu() {
        System.out.print("Select : ");
        int menuNumber = scanner.nextInt();
        if (menuNumber >= 0 && menuNumber <= 6) {
            scanner.nextLine();
            return menuNumber;
        } else {
            System.out.println("Valid Number --> " + menuNumber);
            return -1;
        }
    }

}
