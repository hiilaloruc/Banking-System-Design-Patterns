package Classes;


public class Interest {
    private final int months;
    private final double totalAmount;
    private final double interestRate;
    private double monthlyPayment;

    public Interest(int months, double totalAmount, double interestRate) {
        this.months = months;
        this.totalAmount = totalAmount;
        this.interestRate = interestRate;
        this.monthlyPayment = this.CalculateMonthlyPayment(months, totalAmount, interestRate);
    }

    public double CalculateMonthlyPayment(int months, double totalAmount, double interestRate) {
        double monthlyRate = this.totalAmount * this.interestRate * (double)this.months / 1200.0;
        double monthlyPaymentWithoutInterest = this.totalAmount / (double)this.months;
        return monthlyPaymentWithoutInterest + monthlyPaymentWithoutInterest * monthlyRate;
    }

    public void setMonthlyPayment(double monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public double getMonthlyPayment() {
        return this.monthlyPayment;
    }

    public int getMonths() {
        return this.months;
    }

    public double getTotalAmount() {
        return this.totalAmount;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public String toString() {
        return "com.BankSystem.Interest{months=" + this.months + "}";
    }
}
