// File: src/Main.java
import edu.bank.*;

public class Main {
    public static void main(String[] args) {
        Loan homeLoan = new HomeLoan();
        homeLoan.applyLoan(5000000, 20); // 50 lakh for 20 years
        System.out.println("Home loan interest: " + homeLoan.calculateInterest());

        System.out.println("----------------------");

        Loan carLoan = new CarLoan();
        carLoan.applyLoan(1500000, 5); // 15 lakh for 5 years
        System.out.println("Car loan interest: " + carLoan.calculateInterest());
    }
}
