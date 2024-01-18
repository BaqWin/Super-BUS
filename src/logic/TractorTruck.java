package logic;

import java.io.IOException;
import java.io.Serializable;

public class TractorTruck extends Car implements Serializable {
    private String permission = "CE";
    private boolean tachograph;
    public TractorTruck(String brand, String model, String engine, double powerHp, String vin,
                        double maxPayload, double price, boolean tacho) {
        super(brand, model, engine, powerHp, vin, maxPayload, price);

        this.tachograph = tacho;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(TractorTruck.class);
    }

    public String getPermission() {
        return permission;
    }

    public boolean isTachograph() {
        return tachograph;
    }

    @Override
    public void addBodywork(Bodywork bodywork) {
        throw new IllegalArgumentException("Tractor truck cannot have Bodywork");
    }

    @Override
    public String toString() {
        return "CargoVan{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", engine='" + getEngine() + '\'' +
                ", powerHp=" + getPowerHp() + '\'' +
                ", vin='" + getVin() + '\'' +
                ", maxPayload=" + getMaxPayload() +
                ", price=" + getPrice() +
                ", permission=" + permission +
                ", tachograph=" + tachograph +
                '}';
    }
}
