import Classes.*;
import Classes.Enum.*;
import Classes.Report.AccountReport;
import Classes.Report.BankReport;
import Classes.Report.UserReport;

public class Main {
    public static void main(String[] args) {

        Bank BNP = new Bank("BNP");
        Users Alex = BNP.CreateUser("Alex", 6220928, "contact@Alex.com");
        Users Hilal = BNP.CreateUser("Hilal", 6258741, "hilaloruc@gmail.com");

        Account HilalAccount = Hilal.CreateAccount(2000.0, Currencies.PLN);
        Account AlexAccount = Alex.CreateAccount(500.0, Currencies.PLN);

        UserReport  Hilal_UserReport = new UserReport(Hilal); //user report test
        System.out.println(Hilal_UserReport.getReportContent());

        AccountReport Alex_AccountReport = new AccountReport(AlexAccount); //account report test
        System.out.println(Alex_AccountReport.getReportContent());

        BankReport BNP_BankReport = new BankReport(BNP); //bank report test
        System.out.println(BNP_BankReport.getReportContent());

    }
}