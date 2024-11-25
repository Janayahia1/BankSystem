package com.mycompany.bank;
import java.util.ArrayList;
import java.util.Scanner;

public class Bank {
    public static ArrayList<User> usersDB = new ArrayList<>();
    public static User currentUser;

    public static void main(String[] args) {
        createVirtualUser("Nourh", "123", "111-111-111", 250000, 15000);
        createVirtualUser("Ahmad", "000", "222-222-222", 7800, 9000);
        welcome();
    }

    public static void createVirtualUser(String name, String password, String accountNumber, double balance, double income) {
        User u = new User(name, password, accountNumber, balance, income);
        usersDB.add(u);
    }

    public static void welcome() {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.print("Please Enter your account number: ");
            String accountNumber = kb.nextLine();

            User u = checkAccount(accountNumber, "", true);
            if (u != null) {
                currentUser = u;
                break;
            }
            clear();
        }

        System.out.print("Please Enter the password: ");
        while (true) {
            String password = kb.nextLine();
            if (password.equals(currentUser.password)) {
                break;
            }
            clear();
        }

        System.out.println("Welcome %s!".formatted(currentUser.name));
        list();
        kb.close();
    }

    public static void list() {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.println("Main menu: ");
            System.out.println("1 - View My Balance");
            System.out.println("2 - Withdraw cash");
            System.out.println("3 - Deposit funds");
            System.out.println("4 - Transaction");
            System.out.println("5 - About your account");
            System.out.println("6 - Exit");
            System.out.print("Enter a choice: ");
            String choice = kb.nextLine();

            if (choice.equals("1")) {
                clear();
                System.out.println("Your account balance is: " + Operations.Balance() + "$");
                continueOrleave();
            } else if (choice.equals("2")) {
                Operations.withDrawList();
            } else if (choice.equals("3")) {
                clear();
                Operations.deposit();
            } else if (choice.equals("4")) {
                clear();
                Operations.transaction();
            } else if (choice.equals("5")) {
                clear();
                Operations.about();
            } else if (choice.equals("6")) {
                Exit();
                break;
            } else {
                clear();
                continue;
            }
        }
        kb.close();
    }

    public static void continueOrleave() {
        Scanner kb = new Scanner(System.in);
        while (true) {
            System.out.println("1 - Main");
            System.out.println("2 - Exit");
            System.out.print("Enter a choice: ");
            String choice = kb.nextLine();

            if (choice.equals("1")) {
                clear();
                list();
            } else if (choice.equals("2")) {
                Exit();
                break;
            } else {
                clear();
                continue;
            }
        }
        kb.close();
    }

    public static void Exit() {
        clear();
        currentUser = null;
        welcome();
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static User checkAccount(String accountNumber, String password, boolean choice) {
        for (User u : usersDB) {
            if (choice == true) {
                if (u.accountdNumber.equals(accountNumber)) {
                    return u;
                }
            } else {
                if (u.accountdNumber.equals(accountNumber) && u.password.equals(password)) {
                    return u;
                }
            }
        }
        return null;
    }
}
