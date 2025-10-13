package edu.bank;

public class HomeLoan implements Loan {
    private double principal;
    private int tenure; // in years
    private final double rate = 7.5; // annual interest rate in %

    @Override
    public void applyLoan(double amount, int tenure) {
        this.principal = amount;
        this.tenure = tenure;
        System.out.println("Home loan applied for amount: " + amount + " for " + tenure + " years.");
    }

    @Override
    public double calculateInterest() {
        double interest = (principal * rate * tenure) / 100;
        return interest;
    }
}