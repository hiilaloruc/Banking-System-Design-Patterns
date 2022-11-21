package Classes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
public class Card {
    private final long cardNumber = 1111111111111111L + (long)((new Random()).nextDouble() * 8.888888888888888E15);
    private final int cvc = (int)Math.floor(Math.random() * 900.0 + 100.0);
    private final String expireDate;

    public Card() {
        SimpleDateFormat formatter = new SimpleDateFormat("MM/yyyy");
        Date date = new Date();
        date.setYear(date.getYear() + 2);
        this.expireDate = formatter.format(date);
    }

    public long getCardNumber() {
        return this.cardNumber;
    }

    public int getCvc() {
        return this.cvc;
    }

    public String getExpireDate() {
        return this.expireDate;
    }

    public String toString() {
        return "com.BankSystem.Card{cardNumber=" + this.cardNumber + ", cvc=" + this.cvc + ", expireDate='" + this.expireDate + "'}";
    }
}