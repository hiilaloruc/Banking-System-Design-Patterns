package Classes;


public class Debit {
    private double limit;
    private double spent;

    public Debit(double limit) {
        this.limit = limit;
        this.spent = 0.0;
    }

    public double getLimit() {
        return this.limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public double getBalance() {
        return this.spent;
    }

    public void setBalance(double spent) {
        this.spent = spent;
    }

    public double Deposit(double amount) {
        if (this.spent > 0.0) {
            if (this.spent >= amount) {
                this.spent -= amount;
                amount = 0.0;
            } else {
                amount -= this.spent;
                this.spent = 0.0;
            }
        }

        return amount;
    }

    public boolean Withdraw(double amount) {
        if (this.limit - this.spent >= amount) {
            this.spent += amount;
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return "com.BankSystem.Debit{limit=" + this.limit + ", spent=" + this.spent + "}";
    }
}
