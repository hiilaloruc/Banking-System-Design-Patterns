package Classes;

public class currencyVerifier extends VerificationParameter {
    public currencyVerifier() {
    }

    public void ProcessVerification(Transfer request) {
        if (request.senderAccount.currencies == request.currencies && request.currencies == request.recipientAccount.currencies) {
            this.NextVerificator.ProcessVerification(request);
        } else {
            Transfer.rejectTransfer(request);
        }

    }
}
