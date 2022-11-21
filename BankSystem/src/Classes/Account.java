package Classes;
import java.util.ArrayList;
import java.util.Iterator;

import Classes.Enum.Currencies;
import Classes.Enum.TransactionStatus;
import Classes.Enum.TransactionType;


public class Account {
    private int accountId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
    private double totalBalance;
    public Card card;
    private Debit debit;
    private Loans loan;
    protected final Currencies currencies;
    private boolean isDebit = false;
    private boolean ActiveLoan = false;
    private int bankId;
    private IBPA ibpa;
    private final ArrayList<Transaction> accountTransactions = new ArrayList();

    public Account(double totalBalance, Currencies currencies) {
        this.currencies = currencies;
        this.totalBalance = totalBalance;
    }

    public void createCard() {
        this.card = new Card();
    }

    public int getAccountId() {
        return this.accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTotalBalance() {
        return this.totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public void Deposit(double amount, Currencies currencies) {
        Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, currencies);
        if (currencies == this.currencies) {
            if (this.isDebit) {
                amount = this.debit.Deposit(amount);
            }

            this.setTotalBalance(amount + this.getTotalBalance());
            transaction.setStatus(TransactionStatus.DONE);
        } else {
            transaction.setStatus(TransactionStatus.REJECTED);
        }

        this.accountTransactions.add(transaction);
    }

    public void Withdraw(double amount, Currencies currencies) {
        Transaction transaction = new Transaction(TransactionType.WITHDRAW, amount, currencies);
        if (currencies == this.currencies) {
            if (amount <= this.getTotalBalance()) {
                this.setTotalBalance(this.getTotalBalance() - amount);
                transaction.setStatus(TransactionStatus.DONE);
            } else if (this.isDebit) {
                if (this.debit.Withdraw(amount)) {
                    transaction.setStatus(TransactionStatus.DONE);
                } else {
                    transaction.setStatus(TransactionStatus.REJECTED);
                }
            } else {
                transaction.setStatus(TransactionStatus.REJECTED);
            }
        } else {
            transaction.setStatus(TransactionStatus.REJECTED);
        }

        this.accountTransactions.add(transaction);
    }
    public void Transfer(double amount, Currencies currencies, Account recipientAccount) {
        Transaction transaction;
        if (this.isInSameBank(recipientAccount)) {
            transaction = new Transaction(TransactionType.TRANSFER, amount, currencies);
            transaction.setStatus(this.TransferVerification(amount, currencies, recipientAccount));
            this.accountTransactions.add(transaction);
            recipientAccount.accountTransactions.add(transaction);
        } else {
            transaction = new Transaction(TransactionType.INTERBANKTRANSFER, amount, currencies);
            transaction.setStatus(IBPA.InterbankPayment(this, recipientAccount, amount, currencies));
            this.accountTransactions.add(transaction);
            recipientAccount.accountTransactions.add(transaction);
        }

    }

    private TransactionStatus TransferVerification(double amount, Currencies currencies, Account recipientAccount) {
        if (this.currencies == currencies && currencies == recipientAccount.currencies && amount <= this.getTotalBalance()) {
            this.setTotalBalance(this.getTotalBalance() - amount);
            recipientAccount.setTotalBalance(recipientAccount.getTotalBalance() + amount);
            return TransactionStatus.DONE;
        } else {
            return TransactionStatus.REJECTED;
        }
    }

    public boolean isInSameBank(Account recipientAccount) {
        Bank recipientBank = null;
        Iterator var3 = IBPA.bankList.iterator();

        Iterator var5;
        label49:
        while(var3.hasNext()) {
            Bank bank = (Bank)var3.next();
            var5 = bank.getUsers().iterator();

            while(true) {
                while(true) {
                    if (!var5.hasNext()) {
                        continue label49;
                    }

                    Users user = (Users)var5.next();
                    Iterator var7 = user.getAccount().iterator();

                    while(var7.hasNext()) {
                        Account account = (Account)var7.next();
                        if (account == recipientAccount) {
                            recipientBank = bank;
                            break;
                        }
                    }
                }
            }
        }

        var3 = recipientBank.getUsers().iterator();

        while(var3.hasNext()) {
            Users user = (Users)var3.next();
            var5 = user.getAccount().iterator();

            while(var5.hasNext()) {
                Account account = (Account)var5.next();
                if (account == this) {
                    return true;
                }
            }
        }

        return false;
    }
    public void AddDebit(double limit) {
        if (!this.isDebit) {
            Debit debit = new Debit(limit);
            this.debit = debit;
            this.isDebit = true;
        }

    }

    public void OpenLoan(double amount, String details, String dueDate, double interestRate) {
        if (!this.ActiveLoan) {
            Loans loan = new Loans(details, amount, dueDate, interestRate);
            this.loan = loan;
            this.ActiveLoan = true;
        }

    }

    public void payLoan() {
        double monthlyPayment = this.loan.getMonthlyPayment();
        Transaction transaction = new Transaction(TransactionType.LOAN, monthlyPayment, this.currencies);
        if (this.ActiveLoan) {
            if (this.loan.getRemainingAmount() > 0.0) {
                if (monthlyPayment <= this.getTotalBalance()) {
                    this.setTotalBalance(this.getTotalBalance() - monthlyPayment);
                    this.loan.setRemainingAmount(this.loan.getRemainingAmount() - monthlyPayment);
                    transaction.setStatus(TransactionStatus.DONE);
                    if (this.loan.getRemainingAmount() == 0.0) {
                        this.CloseLoan();
                    }
                } else {
                    transaction.setStatus(TransactionStatus.REJECTED);
                }
            } else {
                transaction.setStatus(TransactionStatus.REJECTED);
            }
        } else {
            transaction.setStatus(TransactionStatus.REJECTED);
        }

    }

    public Card getCard() {
        return this.card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Debit getDebit() {
        return this.debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    public Loans getLoan() {
        return this.loan;
    }

    public void setLoan(Loans loan) {
        this.loan = loan;
    }

    public boolean isDebit() {
        return this.isDebit;
    }

    public void setDebit(boolean debit) {
        this.isDebit = debit;
    }

    public boolean isActiveLoan() {
        return this.ActiveLoan;
    }

    public void setActiveLoan(boolean activeLoan) {
        this.ActiveLoan = activeLoan;
    }

    public ArrayList<Transaction> getAccountTransactions() {
        return this.accountTransactions;
    }

    private void CloseLoan() {
        if (this.ActiveLoan) {
            this.loan = null;
            this.ActiveLoan = false;
        }

    }

    public Currencies getCurrencies() {
        return this.currencies;
    }

    public String toString() {
        return "Account{accountId=" + this.accountId + ", totalBalance=" + this.totalBalance + ", card=" + this.card + ", debit=" + this.debit + ", loan=" + this.loan + ", currencies=" + this.currencies + ", isDebit=" + this.isDebit + ", ActiveLoan=" + this.ActiveLoan + ", accountTransactions=" + this.accountTransactions + "}";
    }
}