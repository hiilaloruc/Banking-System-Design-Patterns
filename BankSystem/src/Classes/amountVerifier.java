package Classes;

public class amountVerifier extends VerificationParameter {
    public amountVerifier() {
    }

    public void ProcessVerification(Transfer request) {
        if (request.senderAccount.getTotalBalance() >= request.amount) {
            Transfer transferObject = new Transfer(request.amount, request.currencies, request.recipientAccount, request.senderAccount);
            transferObject.transferOperationCaller(request.isInSameBank);
        } else {
            Transfer.rejectTransfer(request);
        }

    }
}
