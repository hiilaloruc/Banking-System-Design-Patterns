package Classes;


public abstract class VerificationParameter {
    protected VerificationParameter NextVerificator;

    public VerificationParameter() {
    }

    public void SetNextVerificator(VerificationParameter supervisor) {
        this.NextVerificator = supervisor;
    }

    public abstract void ProcessVerification(Transfer var1);
}

