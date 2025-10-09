// File: src/edu/bank/CarLoan.java
package edu.bank;

public class CarLoan implements Loan {
    private double principal;
    private int tenure; // in years
    private final double rate = 9.0; // annual interest rate in %

    @Override
    public void applyLoan(double amount, int tenure) {
        this.principal = amount;
        this.tenure = tenure;
        System.out.println("Car loan applied for amount: " + amount + " for " + tenure + " years.");
    }

    @Override
    public double calculateInterest() {
        double interest = (principal * rate * tenure) / 100;
        return interest;
    }
}
