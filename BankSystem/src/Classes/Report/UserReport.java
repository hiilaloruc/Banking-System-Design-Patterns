package Classes.Report;
import Classes.*;
import Classes.Enum.ReportType;

import java.util.Iterator;


public class UserReport implements Report {
    private ReportType type;
    private String content;
    private String generationDate;
    private Users user;
    private Bank bank;

    public UserReport(Users user) {
        this.user = user;
        this.type = ReportType.USER;
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
        this.content = "********* USER REPORT ********* \n";
        String var10001 = this.content;
        this.content = var10001 + "User Id : " + this.user.getUserId() + "\n";
        var10001 = this.content;
        this.content = var10001 + "User Name : " + this.user.getName() + "\n";

        for(Iterator var1 = this.user.getAccount().iterator(); var1.hasNext(); this.content = this.content + "************************* \n") {
            Account account = (Account)var1.next();
            this.content = this.content + "************************* \n";
            var10001 = this.content;
            this.content = var10001 + "AccountId : " + account.getAccountId() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Total Balance: " + account.getTotalBalance() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Currency : " + account.getCurrencies() + "\n";
        }

    }
}