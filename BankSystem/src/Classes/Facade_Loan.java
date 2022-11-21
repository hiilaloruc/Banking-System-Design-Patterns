package Classes;

import Classes.Enum.Currencies;

public class Facade_Loan {
    protected Bank bank;
    protected Users user;

    protected Account account;
    protected Loans loan;

    public Facade_Loan(String bankName, String userName, int userPhoneNumber, String userEmail, double accTotalBalance, Currencies accCurrency,
                       String loanDetails, double loanTotalAmount, String loanDueDate , double loanInterestRate) {
        this.bank = new Bank(bankName);
        this.user = new Users(userName,userPhoneNumber,userEmail);
        this.account = new Account(accTotalBalance,accCurrency);
        this.loan = new Loans(loanDetails,loanTotalAmount,loanDueDate,loanInterestRate);
        generateAccountWithLoan();
    }
    public void generateAccountWithLoan(){
        IBPA.getBank().add(this.bank);
        this.bank.getUsers().add(this.user);
        this.user.getAccount().add(this.account);
        this.account.setLoan(this.loan);
        this.account.setActiveLoan(true);

    }

    public Account getAccount() {
        return account;
    }

    @Override
    public String toString() {
        return "Facade_Loan{" +
                "bank=" + bank +"\n"+
                ", user=" + user +"\n"+
                ", account=" + account +"\n"+
                ", loan=" + loan +"\n"+
                '}';
    }
}

