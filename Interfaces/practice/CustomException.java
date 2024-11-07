package Interfaces;

class InsufficientFundsException extends Exception {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance = 1000;

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Insufficient funds. Available balance: " + balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful! New balance: " + balance);
    }
}

public class CustomException {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        try {
            try {
                account.withdraw(1200);  // Triggers insufficient funds exception
            } catch (InsufficientFundsException e) {
                System.out.println(e.getMessage());
                account.withdraw(500);  // Another attempt with sufficient balance
            }
            account.withdraw(600);     // Should cause insufficient funds exception
        } catch (InsufficientFundsException e) {
            System.out.println("Final attempt failed: " + e.getMessage());
        }
    }
}
