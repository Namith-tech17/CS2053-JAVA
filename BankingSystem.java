public 
class LowBalanceException extends Exception {
    public LowBalanceException(String message) {
        super(message);
    }
}

class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String accountHolder, double balance) {
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void withdraw(double amount) throws LowBalanceException {
        if (amount > balance) {
            throw new LowBalanceException(" Insufficient balance! Withdrawal of " + amount + " denied.");
        } else {
            balance -= amount;
            System.out.println(" Withdrawal of " + amount + " successful. Remaining Balance: " + balance);
        }
    }

    public void displayBalance() {
        System.out.println(" Account Holder: " + accountHolder);
        System.out.println(" Current Balance: " + balance);
    }
}
c:\Users\HP\Downloads\Program5_HOUSE_PRICE.xlsx
public class BankingSystem {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Rahul", 5000);

        account.displayBalance();

        try {
            account.withdraw(2000); 
            account.withdraw(4000); 
        } catch (LowBalanceException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println(" Transaction process completed.");
        }
    }
} 