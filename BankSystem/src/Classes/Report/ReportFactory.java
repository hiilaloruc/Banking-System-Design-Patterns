package Classes.Report;

import Classes.Bank;
import Classes.Users;
import Classes.Account;

public class ReportFactory {

    public Report getReport(String reportType, Bank bank) {
        if (reportType == null) {
            return null;
        }
        if (reportType.equalsIgnoreCase("BANK")) {
            return new BankReport(bank);
        }

        return null;
    }

    public Report getReport(String reportType, Users user) {
        if (reportType == null) {
            return null;
        }
        if (reportType.equalsIgnoreCase("USER")) {
            return new UserReport(user);
        }

        return null;
    }

    public Report getReport(String reportType, Account account) {
        if (reportType == null) {
            return null;
        }
        if (reportType.equalsIgnoreCase("ACCOUNT")) {
            return new AccountReport(account);

        }
        return null;
    }

}


