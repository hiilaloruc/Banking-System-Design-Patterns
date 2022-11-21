package Classes;

import java.util.Iterator;

public class isInSameBank extends VerificationParameter {
    public isInSameBank() {
    }

    public void ProcessVerification(Transfer request) {
        Bank recipientBank = null;
        Iterator var3 = IBPA.bankList.iterator();

        Iterator var5;
        label49:
        while(var3.hasNext()) {
            Bank bank = (Bank)var3.next();
            var5 = bank.getUsers().iterator();

            while(true) {
                while(true) {
                    if (!var5.hasNext()) {
                        continue label49;
                    }

                    Users user = (Users)var5.next();
                    Iterator var7 = user.getAccount().iterator();

                    while(var7.hasNext()) {
                        Account account = (Account)var7.next();
                        if (account == request.recipientAccount) {
                            recipientBank = bank;
                            break;
                        }
                    }
                }
            }
        }

        var3 = recipientBank.getUsers().iterator();

        while(var3.hasNext()) {
            Users user = (Users)var3.next();
            var5 = user.getAccount().iterator();

            while(var5.hasNext()) {
                Account account = (Account)var5.next();
                if (account == request.senderAccount) {
                    request.isInSameBank = true;
                }
            }
        }

        this.NextVerificator.ProcessVerification(request);
    }
}