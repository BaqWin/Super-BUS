package logic;

import java.io.Serializable;

public class CargoVan extends Car implements Serializable {
    private static String permission = "B";
    public CargoVan(String brand, String model, String engine, double powerHp, String vin, double maxPayload, double price) {
        super(brand, model, engine, powerHp, vin, maxPayload, price);
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(CargoVan.class);
    }

    public static String getPermission() {
        return permission;
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
                '}';
    }
}
