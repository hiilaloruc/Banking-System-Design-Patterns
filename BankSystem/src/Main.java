import Classes.*;
import Classes.Enum.*;
import Classes.Report.AccountReport;
import Classes.Report.BankReport;
import Classes.Report.ReportFactory;
import Classes.Report.UserReport;

public class Main {
    public static void main(String[] args) {

        Bank BNP = new Bank("BNP");
        Bank QNB = new Bank("QNB");

        Users Alex = BNP.CreateUser("Alex", 6220928, "contact@Alex.com");
        Users Hilal = BNP.CreateUser("Hilal", 6258741, "hilaloruc@gmail.com");

        Account HilalAccount = Hilal.CreateAccount(2000.0, Currencies.PLN);
        Account AlexAccount = Alex.CreateAccount(500.0, Currencies.PLN);

        System.out.println("Alex Balance: " + AlexAccount.getTotalBalance());
        System.out.println("Hilal Balance: " + HilalAccount.getTotalBalance());

        AlexAccount.Deposit(3500,Currencies.PLN);
        AlexAccount.Withdraw(500,Currencies.PLN);
        AlexAccount.Withdraw(500,Currencies.EUR);
        AlexAccount.OpenLoan(2000,"Loan for buying house","2023-05-28" , 0.01 );

        AlexAccount.createCard();
        System.out.println("Alex Balance: " + AlexAccount.getTotalBalance());
        System.out.println("Hilal Balance: " + HilalAccount.getTotalBalance());
        HilalAccount.Transfer(3000,Currencies.PLN,AlexAccount);

        System.out.println(new ReportFactory().getReport("BANK",BNP).getReportContent());
        System.out.println(new ReportFactory().getReport("USER",Alex).getReportContent());
        System.out.println(new ReportFactory().getReport("ACCOUNT",AlexAccount).getReportContent());


    }
}