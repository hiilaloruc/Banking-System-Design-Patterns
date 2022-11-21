import Classes.*;
import Classes.Enum.*;

public class Main {
    public static void main(String[] args) {

        Bank BNP = new Bank("BNP");
        Bank QNB = new Bank("QNB");

        Users Alex = BNP.CreateUser("Alex", 6220928, "contact@Alex.com");
        Users Hilal = BNP.CreateUser("Hilal", 6258741, "hilaloruc@gmail.com");

        Account HilalAccount = Hilal.CreateAccount(2000.0, Currencies.PLN);
        Account AlexAccount = Alex.CreateAccount(3000.0, Currencies.PLN);

        // Chain Of Responsibility Usage
        var transfer = new Transfer(1000,Currencies.PLN,AlexAccount,HilalAccount);
        VerificationParameter issamebankParameter = new VerificationParameter.isInSameBank();
        VerificationParameter currencyParameter = new VerificationParameter.currencyVerifier();
        VerificationParameter amountParameter = new VerificationParameter.amountVerifier();

        issamebankParameter.SetNextVerificator(currencyParameter);
        currencyParameter.SetNextVerificator(amountParameter);

        System.out.println("BEFORE: \nBalance of Hilal: "+ HilalAccount.getTotalBalance()+" \nBalance of Alex: "+ AlexAccount.getTotalBalance());
        issamebankParameter.ProcessVerification(transfer); // Triggers Operation
        System.out.println("AFTER: \nBalance of Hilal: "+ HilalAccount.getTotalBalance()+" \nBalance of Alex: "+ AlexAccount.getTotalBalance());



    }
}