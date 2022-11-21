package Classes;
import Classes.Enum.Currencies;
import Classes.Enum.TransactionStatus;
import Classes.Enum.TransactionType;

import java.util.ArrayList;


public class IBPA {
    public static ArrayList<Bank> bankList = new ArrayList();

    public IBPA() {
    }

    public static ArrayList<Bank> getBank() {
        return bankList;
    }

    public static void setBank(ArrayList<Bank> bankList) {
        IBPA.bankList = bankList;
    }

    public static TransactionStatus InterbankPayment(Account sender, Account receiver, double amount, Currencies currencies) {
        if (sender.currencies == receiver.currencies && currencies == receiver.currencies && amount <= sender.getTotalBalance()) {
            sender.setTotalBalance(sender.getTotalBalance() - amount);
            receiver.setTotalBalance(receiver.getTotalBalance() + amount);
            return TransactionStatus.DONE;
        } else {
            return TransactionStatus.REJECTED;
        }
    }
}
