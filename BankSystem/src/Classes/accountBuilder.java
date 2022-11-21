package Classes;


import Classes.Enum.*;

import java.util.ArrayList;

public class accountBuilder {
    private int accountId;
    private double totalBalance;
    public Card card;
    private Debit debit;
    private Loans loan;
    protected  Currencies currencies;
    private  boolean isDebit = false;
    private boolean ActiveLoan = false;
    private final ArrayList<Transaction> accountTransactions  = new ArrayList<>();

    public static accountBuilder startAccountBuilder_WithDebit( double totalBalance , Currencies currencies , double limit){
        accountBuilder accountBuilder = new accountBuilder();
        accountBuilder.totalBalance = totalBalance;
        accountBuilder.currencies = currencies;
        accountBuilder.accountId = (int)Math.floor(Math.random()*(999999-100000+1)+100000);
        accountBuilder.isDebit = true;
        Debit debit = new Debit(limit);
        accountBuilder.debit = debit;

        return accountBuilder;
    }

    public static accountBuilder startAccountBuilder_WithCard( double totalBalance , Currencies currencies ){
        accountBuilder accountBuilder = new accountBuilder();
        accountBuilder.totalBalance = totalBalance;
        accountBuilder.currencies = currencies;
        accountBuilder.accountId = (int)Math.floor(Math.random()*(999999-100000+1)+100000);
        accountBuilder.card = new Card();

        return accountBuilder;
    }

    public static accountBuilder startAccountBuilder_WithLoan( double totalBalance , Currencies currencies,double amount , String details , String dueDate , double interestRate){
        accountBuilder accountBuilder = new accountBuilder();
        accountBuilder.totalBalance = totalBalance;
        accountBuilder.currencies = currencies;
        accountBuilder.accountId = (int)Math.floor(Math.random()*(999999-100000+1)+100000);
        Loans loan = new Loans(details,amount,dueDate , interestRate);
        accountBuilder.loan= loan;
        accountBuilder.ActiveLoan = true;

        return accountBuilder;
    }

    public static accountBuilder startAccountBuilder_Standard( double totalBalance , Currencies currencies){
        accountBuilder accountBuilder = new accountBuilder();
        accountBuilder.totalBalance = totalBalance;
        accountBuilder.currencies = currencies;
        accountBuilder.accountId = (int)Math.floor(Math.random()*(999999-100000+1)+100000);

        return accountBuilder;
    }
    public Account build(){
        Account account = new Account();
        account.setAccountId(accountId);
        account.setTotalBalance(totalBalance);
        account.setDebitObject(debit);
        account.setisDebit(isDebit);
        account.setCard(card);
        account.setActiveLoan(ActiveLoan);
        account.setLoan(loan);
        account.setCurrencies(currencies);
        return account;
    }



    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(double totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public Debit getDebit() {
        return debit;
    }

    public void setDebit(Debit debit) {
        this.debit = debit;
    }

    public Loans getLoan() {
        return loan;
    }

    public void setLoan(Loans loan) {
        this.loan = loan;
    }

    public Currencies getCurrencies() {
        return currencies;
    }

    public void setCurrencies(Currencies currencies) {
        this.currencies = currencies;
    }

    public boolean isDebit() {
        return isDebit;
    }

    public void setDebit(boolean debit) {
        isDebit = debit;
    }

    public boolean isActiveLoan() {
        return ActiveLoan;
    }

    public void setActiveLoan(boolean activeLoan) {
        ActiveLoan = activeLoan;
    }

    public ArrayList<Transaction> getAccountTransactions() {
        return accountTransactions;
    }
}