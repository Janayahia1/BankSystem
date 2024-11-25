# Bank Management System

This project simulates a simple banking system where users can create virtual accounts, check balances, deposit money, withdraw money, transfer funds, and view account details. It is a console-based application in Java.

## Features

1. **User Authentication**:
   - Users can enter their account number and password to log in.
   
2. **Main Menu**:
   - After login, the user is presented with a menu to:
     - View current balance.
     - Withdraw cash (with predefined amounts or custom amounts).
     - Deposit funds.
     - Transfer funds to another account.
     - View account details.
     - Exit the system.

3. **Account Operations**:
   - **View Balance**: Displays the current balance of the logged-in user.
   - **Withdraw Cash**: Allows the user to withdraw specific amounts (50$, 100$, 200$, 300$, 500$, or a custom amount).
   - **Deposit Funds**: Allows the user to deposit a specified amount into their account.
   - **Transfer Funds**: Allows the user to transfer money to another account within the system.
   - **Account Details**: Displays account information, including account number, balance, account creation date, and card type (Basic, Platinum, or Gold).

## Classes

### 1. `Bank.java`
   - Contains the main logic of the banking system, including:
     - User registration and login.
     - Displaying the main menu and performing operations based on user input.

### 2. `User.java`
   - Represents a user account with attributes like `name`, `accountNumber`, `balance`, `password`, `income`, and `date` of account creation.
   
### 3. `Operations.java`
   - Contains methods to perform various account operations:
     - Viewing balance.
     - Depositing funds.
     - Withdrawing funds.
     - Transferring funds.
     - Displaying account details.

## Usage
