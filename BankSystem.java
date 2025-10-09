abstract class Account {
    String accountHolder;
    double balance;

    Account(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    abstract void withdraw(double amount);

    void deposit(double amount) {
        balance += amount;
        System.out.println(" Deposited: " + amount + " | New Balance: " + balance);
    }

    void displayBalance() {
        System.out.println(" Account Holder: " + accountHolder);
        System.out.println(" Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    double interestRate;

    SavingsAccount(String accountHolder, double balance, double interestRate) {
        super(accountHolder, balance);
        this.interestRate = interestRate;
    }

    void withdraw(double amount) {
        if (balance - amount >= 1000) { 
            balance -= amount;
            System.out.println(" Withdrawn from Savings: " + amount + " | Remaining Balance: " + balance);
        } else {
            System.out.println(" Withdrawal denied! Minimum balance of 1000 must be maintained.");
        }
    }
}

class CurrentAccount extends Account {
    double overdraftLimit;

    CurrentAccount(String accountHolder, double balance, double overdraftLimit) {
        super(accountHolder, balance);
        this.overdraftLimit = overdraftLimit;
    }

    void withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println(" Withdrawn from Current: " + amount + " | Remaining Balance: " + balance);
        } else {
            System.out.println(" Withdrawal denied! Overdraft limit exceeded.");
        }
    }
}

public class BankSystem {
    public static void main(String[] args) {
        
        Account acc1 = new SavingsAccount("Rahul", 5000, 5.5);
        Account acc2 = new CurrentAccount("Sneha", 2000, 1000);

        System.out.println("\n--- Savings Account Operations ---");
        acc1.displayBalance();
        acc1.deposit(1000);
        acc1.withdraw(4500);  
        acc1.withdraw(2000);  

        System.out.println("\n--- Current Account Operations ---");
        acc2.displayBalance();
        acc2.withdraw(2500);  
        acc2.withdraw(2000); 
    }
}