import Classes.*;
import Classes.Enum.*;
import Classes.Report.AccountReport;
import Classes.Report.BankReport;
import Classes.Report.UserReport;

public class Main {
    public static void main(String[] args) {
        //While Facade decreases the overall complexity of the application, it also helps to move unwanted dependencies to one place.


        //BEFORE FACADE IMPLEMENTATION
        /*
        Bank BNP = new Bank("BNP");
        Users Hilal = BNP.CreateUser("Hilal", 6258741, "hilaloruc@gmail.com");
        Account HilalAccount = Hilal.CreateAccount(2000.0, Currencies.PLN);
        Loans loan = new Loans("Loan for buying BMW.",100000.0,"2024-06-01",0.01);
        HilalAccount.setLoan(loan);
        HilalAccount.setActiveLoan(true);
        System.out.println(HilalAccount);
        */

        //AFTER FACADE IMPLEMENTATION
        Facade_Loan loanFacade = new Facade_Loan("BNP","hiilaloruc",053555555,
                "hilaloruc@gmail.com",3000,Currencies.USD,"new job offer in Poland",
                100000.0,"2024-06-01",0.01);
        System.out.println(loanFacade.getAccount());

    }
}