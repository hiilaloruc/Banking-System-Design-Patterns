import Classes.*;
import Classes.Enum.*;

public class Main {
    public static void main(String[] args) {

        Bank BNP = new Bank("BNP");
        Bank QNB = new Bank("QNB");
        Users ibrahim = BNP.CreateUser("bob", 6220928, "contact@ibrahimcherri.com");
        Users Hilal = QNB.CreateUser("hilal", 6258741, "hilaloruc@gmail.com");
        Account HilalAccount = Hilal.CreateAccount(2000.0, Currencies.PLN);
        Account ibrahimaccount = ibrahim.CreateAccount(500.0, Currencies.PLN);
        System.out.println("-------BEFORE--------");
        System.out.println(HilalAccount);
        System.out.println(ibrahimaccount);
        Transfer transfer = new Transfer(1000.0, Currencies.PLN, ibrahimaccount, HilalAccount);
        VerificationParameter issamebankParameter = new isInSameBank();
        VerificationParameter currencyParameter = new currencyVerifier();
        VerificationParameter amountParameter = new amountVerifier();
        issamebankParameter.SetNextVerificator(currencyParameter);
        currencyParameter.SetNextVerificator(amountParameter);
        issamebankParameter.ProcessVerification(transfer);
        System.out.println("-------AFTER TRANSFER OPERATION---------");
        System.out.println(HilalAccount);
        System.out.println(ibrahimaccount);
    }
}