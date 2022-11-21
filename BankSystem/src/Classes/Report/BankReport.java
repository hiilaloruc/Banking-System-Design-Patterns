package Classes.Report;

import java.util.Iterator;
import Classes.*;
import Classes.Enum.ReportType;

public class BankReport implements Report {
    private ReportType type;
    private String content;
    private String generationDate;
    private Bank bank;

    public BankReport(Bank bank) {
        this.type = ReportType.BANK;
        this.bank = bank;
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
        this.content = "********* BANK REPORT ********* \n";
        String var10001 = this.content;
        this.content = var10001 + "Bank Id : " + this.bank.getId() + "\n";
        var10001 = this.content;
        this.content = var10001 + "Bank Name : " + this.bank.getName() + "\n";
        var10001 = this.content;
        this.content = var10001 + "Total Users : " + this.bank.getUsers().size() + "\n";
        this.content = this.content + "************ USERS ************* \n";

        for(Iterator var1 = this.bank.getUsers().iterator(); var1.hasNext(); this.content = this.content + "************************* \n") {
            Users user = (Users)var1.next();
            var10001 = this.content;
            this.content = var10001 + "User Id : " + user.getUserId() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Name: " + user.getName() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Email : " + user.getEmail() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Phone Number : " + user.getPhoneNumber() + "\n";
            var10001 = this.content;
            this.content = var10001 + "Number of accounts : " + user.getAccount().size() + "\n";
        }

    }
}

