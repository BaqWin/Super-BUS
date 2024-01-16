package logic;

import java.io.Serializable;

public abstract class Vehicle extends ObjectPlus implements Serializable {
    private String vin;
    private double maxPayload;
    private double price;

    public Vehicle(String vin, double maxPayload, double price){
        super();

        this.vin = vin;
        this.maxPayload = maxPayload;
        this.price = price;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(PersonClient.class);
    }
}
