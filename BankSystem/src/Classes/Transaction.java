package Classes;

import Classes.Enum.Currencies;
import Classes.Enum.TransactionStatus;
import Classes.Enum.TransactionType;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private TransactionType type;
    private String date;
    private double amount;
    private TransactionStatus status;
    private final Currencies currencies;

    public Transaction(TransactionType transactionType, double amount, Currencies currencies) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        this.type = transactionType;
        this.amount = amount;
        this.date = dtf.format(now);
        this.status = TransactionStatus.PENDING;
        this.currencies = currencies;
    }

    public void verifyTransfer() {
    }

    public TransactionType getType() {
        return this.type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TransactionStatus getStatus() {
        return this.status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public String toString() {
        return "com.BankSystem.Transaction{type=" + this.type + ", date='" + this.date + "', amount=" + this.amount + ", currency=" + this.currencies + ", status=" + this.status + "}";
    }
}
