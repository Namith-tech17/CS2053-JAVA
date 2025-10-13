package edu.bank;

public interface Loan {
    void applyLoan(double amount, int tenure); // tenure in years
    double calculateInterest(); // returns interest amount
}