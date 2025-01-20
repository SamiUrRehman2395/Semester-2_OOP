class Account {
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }


    public static void printBankInfo() {
        System.out.println("Welcome to Meezan Bank!");
    }


    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount + ", New Balance: " + balance);
    }


    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayBalance() {
        System.out.println("Current Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        System.out.println("Savings Account Deposit: Adding interest of " + (amount * interestRate));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Savings Account Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Savings Account!");
        }
    }

    @Override
    public void displayBalance() {
        System.out.println("Savings Account Balance: " + balance);
    }
}

class CheckingAccount extends Account {
    private double overdraftLimit;

    public CheckingAccount(double balance, double overdraftLimit) {
        super(balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
        System.out.println("Checking Account Deposit: No interest added.");
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= (balance + overdraftLimit)) {
            balance -= amount;
            System.out.println("Checking Account Withdrawn: " + amount + ", New Balance: " + balance);
        } else {
            System.out.println("Insufficient funds in Checking Account!");
        }
    }

    @Override
    public void displayBalance() {
        System.out.println("Checking Account Balance: " + balance);
    }
}

public class BankTest {
    public static void main(String[] args) {

        Account.printBankInfo();


        Account myAccount = new Account(5000);
        SavingsAccount mySavingsAccount = new SavingsAccount(3000, 0.05);
        CheckingAccount myCheckingAccount = new CheckingAccount(2000, 1000);


        Account myAccountRef = new SavingsAccount(4000, 0.07);
        myAccountRef.deposit(1000);
        myAccountRef.withdraw(500);
        myAccountRef.displayBalance();

        Account myAccountRef2 = new CheckingAccount(1500, 2000);
        myAccountRef2.deposit(500);
        myAccountRef2.withdraw(3000);
        myAccountRef2.displayBalance();


        myAccount.deposit(500);
        mySavingsAccount.withdraw(1000);

    }
}
