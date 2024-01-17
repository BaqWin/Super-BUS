package logic;

import java.io.Serializable;

public class Truck extends Car implements Serializable {
    private static String permission = "C";
    private boolean tachograph;

    public Truck(String brand, String model, String engine, double powerHp, String vin,
                 double maxPayload, double price, boolean tacho) {
        super(brand, model, engine, powerHp, vin, maxPayload, price);

        this.tachograph = tacho;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(Truck.class);
    }

    public static String getPermission() {
        return permission;
    }

    public boolean isTachograph() {
        return tachograph;
    }

    @Override
    public void addBodywork(Bodywork bodywork) {
        if(bodywork == null){
            throw new NullPointerException();
        }
        if(getBodywork() == null){
            setBodywork(bodywork);
            bodywork.addVehicle(this);
        }
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
                ", bodywork=" + getBodywork() +
                ", permission=" + permission +
                ", tachograph=" + tachograph +
                '}';
    }
}
