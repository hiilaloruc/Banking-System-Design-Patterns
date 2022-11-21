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

        Account HilalAccount = Hilal.createAccount_WithCard(2000.0, Currencies.PLN);
        Account AlexAccount = Alex.createAccount_Standard(500.0, Currencies.PLN);

        System.out.println("Account Hilal: "+ HilalAccount);
        System.out.println("Account Hilal: "+ AlexAccount);


    }
}