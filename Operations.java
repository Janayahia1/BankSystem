package com.mycompany.bank;
import java.util.Scanner;

public class Operations extends Bank {

    public static double Balance() {
        return currentUser.balance;
    }

    public static void deposit() {
        loop: while (true) {
            Scanner kb = new Scanner(System.in);
            System.out.print("Enter an amount for the deposit: ");
            double amount = kb.nextDouble();

            if (amount <= 0) {
                clear();
                System.out.println("Enter a valid amount!");
                continue;
            }
            currentUser.balance += amount;
            clear();
            System.out.println("Successfully deposited %s$ Your account balance is %s$".formatted(amount, Balance()));
            continueOrleave();
            kb.close();
            break loop;
        }
    }

    public static void withDrawList() {
        Scanner kb = new Scanner(System.in);
        clear();
        System.out.println("1- 50$ \t\t 4- 300$");
        System.out.println("2- 100$ \t 5- 500$");
        System.out.println("3- 200$ \t 6- Another amount");
        System.out.println("7- Main");
        System.out.print("Enter a choice: ");
        String choice = kb.next();

        while (true) {
            if (choice.equals("1")) {
                withDraw(50.0);
                break;
            } else if (choice.equals("2")) {
                withDraw(100.0);
                break;
            } else if (choice.equals("3")) {
                withDraw(200.0);
                break;
            } else if (choice.equals("4")) {
                withDraw(300.0);
                break;
            } else if (choice.equals("5")) {
                withDraw(500.0);
                break;
            } else if (choice.equals("6")) {
                clear();
                withdraw6();
            } else if (choice.equals("7")) {
                clear();
                list();
                break;
            } else {
                clear();
                withDrawList();
            }
        }
        kb.close();
    }

    public static void withdraw6() {
        while (true) {
            System.out.println("Your account balance is: %s$".formatted(Balance()));
            Scanner kbb = new Scanner(System.in);
            System.out.print("Enter an amount: ");
            Double amount = kbb.nextDouble();

            if (amount < 0) {
                clear();
                System.out.println("Enter a valid amount!");
                continue;
            }
            withDraw(amount);
            kbb.close();
            break;
        }
    }

    public static void withDraw(Double amount) {
        if (Balance() - amount < 0) {
            clear();
            System.out.println("Unfortunately, your account balance doesn't cover that. Try another amount.");
            withdraw6();
            return;
        }
        clear();
        currentUser.balance -= amount;
        System.out.println("Successfully withdrawn %s$ Your left balance is %s$".formatted(amount, Balance()));
        continueOrleave();
    }

    public static void transaction() {
        String accountNumber;
        User transfer = null;
        Scanner kb = new Scanner(System.in);

        while (true) {
            System.out.println("x - to get back");
            System.out.println("Your balance is: %s$".formatted(Balance()));
            System.out.print("Enter account number: ");
            String cardNumber = kb.next();

            transfer = checkAccount(cardNumber, "", true);
            if (transfer != null) {
                if (cardNumber.equals(currentUser.accountdNumber)) {
                    clear();
                    System.out.println("You can't transfer to yourself!");
                    continue;
                }
                accountNumber = cardNumber;
                break;
            } else if (cardNumber.equalsIgnoreCase("x")) {
                clear();
                list();
                break;
            } else {
                clear();
                System.out.println("Sorry, we can't find " + cardNumber);
            }
        }

        while (true) {
            System.out.print("The amount that will be transferred to %s%s is: ".formatted(transfer.name, accountNumber));
            double amount = kb.nextDouble();

            if (amount < 0) {
                clear();
                System.out.println("Enter a valid amount!");
                System.out.println("Your balance is: %s$".formatted(Balance()));
                continue;
            }

            if (Balance() - amount < 0) {
                clear();
                System.out.println("%s$ exceeds your balance!".formatted(amount));
                System.out.println("Your balance is: %s$".formatted(Balance()));
                continue;
            }

            currentUser.balance -= amount;
            transfer.balance += amount;
            clear();
            System.out.println("Successfully transferred %s$ to %s and your current balance is %s$".formatted(amount, transfer.name, transfer.accountdNumber, Balance()));
            continueOrleave();
            kb.close();
            break;
        }
    }

    public static void about() {
        System.out.println("--------------------------");
        System.out.println("- Name: %s".formatted(currentUser.name));
      System.out.println("- Card Number: %s".formatted(currentUser.accountdNumber));
        System.out.println("- Balance: %s$".formatted(currentUser.balance));
        System.out.println("- Created at: %s".formatted(currentUser.date));
        System.out.println("- Type: %s Card".formatted(currentUser.balance >= 250000 ? 
            (currentUser.balance >= 500000 ? "Gold" : "Platinum") : "Basic"));
        System.out.println("--------------------------");
        continueOrleave();
    }
}
