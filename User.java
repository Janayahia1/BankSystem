public class User {
    public String name;
    public String accountdNumber;
    public double balance;
    public String password;
    public String date;
    public double income;

    public User(String name, String password, String accountNumber, double balance, double income) {
        this.name = name;
        this.password = password;
        this.accountdNumber = accountNumber;
        this.balance = balance;
        this.date = java.time.LocalDate.now().toString();
        this.income = income;
    }
}
