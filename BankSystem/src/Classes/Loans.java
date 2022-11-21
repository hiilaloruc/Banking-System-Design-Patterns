package Classes;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Loans {
    private double totalAmount;
    private String details;
    private String dueDate;
    private double interestRate;
    private double monthlyPayment;
    private Interest interest;
    private double remainingAmount;

    public Loans(String details, double totalAmount, String dueDate, double interestRate) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        long monthsBetween = ChronoUnit.MONTHS.between(LocalDate.parse(dtf.format(now)).withDayOfMonth(1), LocalDate.parse(dueDate).withDayOfMonth(1));
        this.details = details;
        this.totalAmount = totalAmount;
        this.dueDate = dueDate;
        this.interestRate = interestRate;
        this.interest = new Interest((int)monthsBetween, totalAmount, interestRate);
        this.monthlyPayment = this.interest.getMonthlyPayment();
        this.remainingAmount = totalAmount;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getDetails() {
        return this.details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Interest getInterest() {
        return this.interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    public double getRemainingAmount() {
        return this.remainingAmount;
    }

    public void setRemainingAmount(double remainingAmount) {
        this.remainingAmount = remainingAmount;
    }

    public String toString() {
        return "com.BankSystem.Loans{totalAmount=" + this.totalAmount + ", details='" + this.details + "', dueDate='" + this.dueDate + "', interestRate=" + this.interestRate + ", monthlyPayment=" + this.monthlyPayment + ", interest=" + this.interest + "}";
    }
}

