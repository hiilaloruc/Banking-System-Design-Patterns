import Classes.*;
import Classes.Enum.*;
import Classes.Report.AccountReport;
import Classes.Report.BankReport;
import Classes.Report.UserReport;

public class Main {
    public static void main(String[] args) {

        IBPA ibpa = IBPA.getInstance(); //Singleton Usage
        Bank BNP = new Bank("BNP");
        Bank QNB = new Bank("QNB");

        ibpa.bankList.add(BNP);
        ibpa.bankList.add(QNB);

        Users Alex = BNP.CreateUser("Alex", 6220928, "contact@Alex.com");
        Users Hilal = QNB.CreateUser("Hilal", 6258741, "hilaloruc@gmail.com");

        Account acc_Hilal = Hilal.CreateAccount(1200,Currencies.EUR);
        Account acc_Alex = Alex.CreateAccount(600,Currencies.EUR);

        System.out.println("BEFORE: \nBalance of Hilal: "+ acc_Hilal.getTotalBalance()+" \nBalance of Alex: "+ acc_Alex.getTotalBalance());
        ibpa.InterbankPayment(acc_Hilal,acc_Alex,200,Currencies.EUR);
        System.out.println("AFTER: \nBalance of Hilal: "+ acc_Hilal.getTotalBalance()+" \nBalance of Alex: "+ acc_Alex.getTotalBalance());


    }
}