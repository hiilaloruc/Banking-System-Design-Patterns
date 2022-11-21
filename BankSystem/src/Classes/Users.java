package Classes;
import Classes.Enum.Currencies;
import Classes.Enum.TransactionStatus;
import Classes.Enum.TransactionType;
import java.util.ArrayList;

public class Users {
    private int userId = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
    private String name;
    private int phoneNumber;
    private String email;
    private final ArrayList<Account> account = new ArrayList();

    public Users(String name, int phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public Account CreateAccount(double totalBalance, Currencies currencies) {
        Account account = new Account(totalBalance, currencies);
        this.account.add(account);
        return account;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Account> getAccount() {
        return this.account;
    }

    public String toString() {
        return "com.BankSystem.Users{userId=" + this.userId + ", name='" + this.name + "', phoneNumber=" + this.phoneNumber + ", email='" + this.email + "', account=" + this.account + "}";
    }
}