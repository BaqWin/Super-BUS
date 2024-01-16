package logic;

import java.io.Serializable;
import java.util.*;

public abstract class Client extends ObjectPlus implements Serializable {
    String address;
    double discount;
    String phoneNumber;

    public Client(String address, double discount, String phoneNumber){
        super();

        this.address = address;
        this.discount = discount;
        this.phoneNumber = phoneNumber;
    }
}
