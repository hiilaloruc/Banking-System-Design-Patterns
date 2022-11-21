package Classes;

import Classes.Enum.Currencies;
import Classes.Enum.TransactionStatus;
import Classes.Enum.TransactionType;
import java.util.ArrayList;
public class Transfer {
    public double amount;
    public Currencies currencies;
    public Account recipientAccount;
    public Account senderAccount;
    public boolean isInSameBank = false;

    public Transfer(double amount, Currencies currencies, Account recipientAccount, Account senderAccount) {
        this.amount = amount;
        this.currencies = currencies;
        this.recipientAccount = recipientAccount;
        this.senderAccount = senderAccount;
    }

    public void transferOperationCaller(boolean isInSameBank) {
        if (isInSameBank) {
            this.TransferOperation_Direct(this.senderAccount, this.recipientAccount);
        } else {
            this.TransferOperation_Interbank(this.senderAccount, this.recipientAccount);
        }

    }

    public void TransferOperation_Interbank(Account sender, Account receiver) {
        Transaction transaction = new Transaction(TransactionType.INTERBANKTRANSFER, this.amount, this.currencies);
        sender.setTotalBalance(sender.getTotalBalance() - this.amount);
        receiver.setTotalBalance(receiver.getTotalBalance() + this.amount);
        sender.getAccountTransactions().add(transaction);
        receiver.getAccountTransactions().add(transaction);
    }

    public void TransferOperation_Direct(Account sender, Account receiver) {
        Transaction transaction = new Transaction(TransactionType.TRANSFER, this.amount, this.currencies);
        sender.getAccountTransactions().add(transaction);
        receiver.getAccountTransactions().add(transaction);
    }

    public static void rejectTransfer(Transfer request) {
        Transaction transaction;
        if (request.isInSameBank) {
            transaction = new Transaction(TransactionType.TRANSFER, request.amount, request.currencies);
        } else {
            transaction = new Transaction(TransactionType.INTERBANKTRANSFER, request.amount, request.currencies);
        }

        transaction.setStatus(TransactionStatus.REJECTED);
        request.senderAccount.getAccountTransactions().add(transaction);
    }
}
