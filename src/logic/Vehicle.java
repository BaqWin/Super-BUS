package logic;

import java.io.Serializable;

public abstract class Vehicle extends ObjectPlus implements Serializable {
    String vin;
    double maxPayload;
    double price;

    public Vehicle(String vin, double maxPayload, double price){
        super();

        this.vin = vin;
        this.maxPayload = maxPayload;
        this.price = price;
    }
}
