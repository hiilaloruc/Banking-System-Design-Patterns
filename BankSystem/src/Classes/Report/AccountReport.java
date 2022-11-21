package Classes.Report;
import java.util.Iterator;
import Classes.*;
import Classes.Enum.ReportType;

public class AccountReport implements Report {
    private ReportType type;
    private String content;
    private String generationDate;
    private Account account;
    private Transaction transaction;

    public AccountReport(Account account) {
        this.type = ReportType.ACCOUNT;
        this.account = account;
        this.generateReport();
    }

    public ReportType getType() {
        return this.type;
    }

    public String getReportContent() {
        return this.content;
    }

    public String ReportDate() {
        return this.generationDate;
    }

    public void generateReport() {
        this.content = "********* ACCOUNT REPORT ********* \n";
        String var10001 = this.content;
        this.content = var10001 + "Id : " + this.account.getAccountId() + "\n";
        var10001 = this.content;
        this.content = var10001 + "Balance : " + this.account.getTotalBalance() + "\n";
        var10001 = this.content;
        this.content = var10001 + "Currency : " + this.account.getCurrencies() + "\n";
        this.content = this.content + "************************* \n";
        var10001 = this.content;
        this.content = var10001 + "Debit : " + this.account.getDebit() + "\n";
        var10001 = this.content;
        this.content = var10001 + "Loan : " + this.account.isActiveLoan() + "\n";
        if (this.account.getCard() != null) {
            this.content = this.content + "***** CARD **** \n";
            var10001 = this.content;
            this.content = var10001 + "Number : " + this.account.getCard().getCardNumber() + "\n";
            var10001 = this.content;
            this.content = var10001 + "CVC : " + this.account.getCard().getCvc() + "\n";
            var10001 = this.content;
            this.content = var10001 + "EXP : " + this.account.getCard().getExpireDate() + "\n";
            this.content = this.content + "*************** \n";
        }

        if (this.account.isDebit()) {
            this.content = this.content + "***** DEBIT **** \n";
            var10001 = this.content;
            this.content = var10001 + "Limit : " + this.account.getDebit().getLimit() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Balance : " + this.account.getDebit().getBalance() + "\n";
            this.content = this.content + "**************** \n";
        }

        if (this.account.isActiveLoan()) {
            this.content = this.content + "***** LOAN ***** \n";
            var10001 = this.content;
            this.content = var10001 + "Details : " + this.account.getLoan().getDetails() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Total Amount : " + this.account.getLoan().getTotalAmount() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Due Date : " + this.account.getLoan().getDueDate() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Monthly Payment : " + this.account.getLoan().getMonthlyPayment() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Interest Rate : " + this.account.getLoan().getInterestRate() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Remaining Amount : " + this.account.getLoan().getRemainingAmount() + "\n";
            this.content = this.content + "*************** \n";
        }

        this.content = this.content + "***** TRANSACTIONS ***** \n";

        for(Iterator var1 = this.account.getAccountTransactions().iterator(); var1.hasNext(); this.content = this.content + "************************ \n") {
            Transaction transaction = (Transaction)var1.next();
            var10001 = this.content;
            this.content = var10001 + "Type : " + transaction.getType() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Amount : " + transaction.getAmount() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Status : " + transaction.getStatus() + "\n";
        }

        this.content = this.content + "************************* \n";
    }
}
