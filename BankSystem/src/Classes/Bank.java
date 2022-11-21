package Classes;
import java.util.ArrayList;

public class Bank {
    private String name;
    private int id;
    public ArrayList<Users> users = new ArrayList();

    public Bank(String name) {
        this.name = name;
        this.id = (int)Math.floor(Math.random() * 900000.0 + 100000.0);
        IBPA.bankList.add(this);
    }

    public Users CreateUser(String name, int phoneNumber, String email) {
        Users user = new Users(name, phoneNumber, email);
        this.users.add(user);
        return user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Users> getUsers() {
        return this.users;
    }

    public void setUsers(ArrayList<Users> users) {
        this.users = users;
    }

    public String toString() {
        return "Bank{name='" + this.name + "', id=" + this.id + ", users=" + this.users + "}";
    }
}