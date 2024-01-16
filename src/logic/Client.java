package logic;

import java.io.Serializable;
import java.util.*;

public abstract class Client extends ObjectPlus implements Serializable {
    private String address;
    private double discount;
    private String phoneNumber;

    public Client(String address, double discount, String phoneNumber){
        super();

        this.address = address;
        this.discount = discount;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public double getDiscount() {
        return discount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
