package logic;

import java.io.Serializable;

public abstract class Car extends Vehicle implements Serializable {
    private String brand;
    private String model;
    private String engine;
    private double powerHp;


    public Car(String brand, String model, String engine, double powerHp,
               String vin, double maxPayload, double price) {
        super(vin, maxPayload, price);

        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.powerHp = powerHp;
    }
}
