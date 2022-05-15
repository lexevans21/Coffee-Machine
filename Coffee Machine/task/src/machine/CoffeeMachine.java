package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static State state = State.MAIN;
    static int moneyAmount = 550;
    static int waterAmount = 400;
    static int milkAmount = 540;
    static int coffeeAmount = 120;
    static int cupsAmount = 9;

    public static void main(String[] args) {

        while (!state.toString().equals("OFF")) {
            switch (state) {
                case MAIN:
                    mainMenu();
                    break;
                case BUY:
                    buy();
                    state = State.MAIN;
                    break;
                case FILL:
                    fill();
                    state = State.MAIN;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + state);
            }
        }

    }

    private static void mainMenu() {

            System.out.println("Write action (buy, fill, take, remaining, exit)");


            switch (getInput()) {
                case "buy":
                    state = State.BUY;
                    break;
                case "fill":
                    state = State.FILL;
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    displayAmounts();
                    break;
                case "exit":
                    state = State.OFF;
                    break;
            }
    }

    private static void buy() {


        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        String choice = getInput();

        switch (choice) {
            case "1":
                if (waterAmount >= 250 && coffeeAmount >= 16 && cupsAmount >= 1) {
                    waterAmount -= 250;
                    coffeeAmount -= 16;
                    cupsAmount--;
                    moneyAmount += 4;
                    System.out.println("Making you an espresso!");
                } else {
                    notEnoughSupplies(250, 16, 0, 1);
                }
                break;
            case "2":
                if (waterAmount >= 350 && coffeeAmount >= 20 && milkAmount >= 75 && cupsAmount >= 1) {
                    waterAmount -= 350;
                    coffeeAmount -= 20;
                    milkAmount -= 75;
                    cupsAmount--;
                    moneyAmount += 7;
                } else {
                    notEnoughSupplies(350, 20, 75, 1);
                }
                break;
            case "3":
                if (waterAmount >= 20 && coffeeAmount >- 12 && milkAmount >= 100 && cupsAmount >= 1) {
                    waterAmount -= 200;
                    coffeeAmount -= 12;
                    milkAmount -= 100;
                    cupsAmount--;
                    moneyAmount += 6;
                } else {
                    notEnoughSupplies(20, 12, 100 ,1);
                }
                break;
            case "back":
                break;
        }
    }

    private static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        waterAmount += Integer.parseInt(getInput());
        System.out.println("Write how many ml of milk you want to add: ");
        milkAmount += Integer.parseInt(getInput());
        System.out.println("Write how many grams of coffee beans you want to add: ");
        coffeeAmount += Integer.parseInt(getInput());
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cupsAmount += Integer.parseInt(getInput());
    }

    private static void take() {
        System.out.println("I gave you $" + moneyAmount);
        moneyAmount = 0;
    }

    public static void displayAmounts() {
        System.out.println("The coffee machine has:");
        System.out.println(waterAmount + " ml of water");
        System.out.println(milkAmount + " ml of milk");
        System.out.println(coffeeAmount + " g of coffee beans");
        System.out.println(cupsAmount + " disposable cups");
        System.out.println("$" + moneyAmount + " of money");
    }

    public static void notEnoughSupplies(int water, int coffee, int milk, int cups) {
        if (waterAmount < water) {
            System.out.println("Not enough water!");
        } else if (coffeeAmount < coffee) {
            System.out.println("Not enough coffee beans!");
        } else if (cupsAmount < cups) {
            System.out.println("Not enough cups!");
        } else if (milkAmount < milk) {
            System.out.println("Not enough milk!");
        }
    }

    private static String getInput() {
        Scanner input = new Scanner(System.in);

        return input.next();
    }

    enum State {
        MAIN, BUY, FILL, OFF
    }
}

