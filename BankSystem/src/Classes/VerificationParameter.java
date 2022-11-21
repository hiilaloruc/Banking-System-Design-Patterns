package Classes;


import static Classes.Transfer.rejectTransfer;

public abstract class VerificationParameter {
    protected VerificationParameter NextVerificator;

    public void SetNextVerificator(VerificationParameter supervisor)
    {
        this.NextVerificator = supervisor;
    }
    public abstract void ProcessVerification(Transfer request);

    public static class isInSameBank extends VerificationParameter {
        @Override
        public void ProcessVerification(Transfer request) {
            Bank recipientBank = null;
            for (Bank bank : IBPA.bankList) {
                for (Users user : bank.getUsers()) {
                    for (Account account : user.getAccount()) {
                        if (account == request.recipientAccount) {
                            recipientBank = bank;
                            break;
                        }
                    }
                }
            }
            for (Users user : recipientBank.getUsers()) {
                for (Account account : user.getAccount()) {
                    if (account == request.senderAccount) {
                        request.isInSameBank = true;
                    }
                }
            }
            //different banks result call function
            NextVerificator.ProcessVerification(request);
        }
    }

    public static class currencyVerifier extends VerificationParameter {
        @Override
        public void ProcessVerification(Transfer request) {
            if (request.senderAccount.currencies == request.currencies && request.currencies == request.recipientAccount.currencies) {
                NextVerificator.ProcessVerification(request);
            } else {
                rejectTransfer(request);
            }
        }
    }

    public static class amountVerifier extends VerificationParameter {
        @Override
        public void ProcessVerification(Transfer request) {
            if (request.senderAccount.getTotalBalance() >= request.amount) {
                Transfer transferObject = new Transfer(request.amount, request.currencies, request.recipientAccount, request.senderAccount);
                transferObject.transferOperationCaller(request.isInSameBank);
            } else {
                rejectTransfer(request);
            }
        }
    }
}

