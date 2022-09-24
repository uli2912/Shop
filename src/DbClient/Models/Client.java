package DbClient.Models;

import java.sql.PreparedStatement;

public class Client {
    private int id;
    private String name;
    private String email;
    private Product product;
    public Client(){}
    public Client(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
