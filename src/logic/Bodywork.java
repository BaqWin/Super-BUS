package logic;

import java.io.Serializable;
import java.util.*;

public class Bodywork extends ObjectPlus implements Serializable {
    private String bodyType;
    private String internalDimensions;
    private List<Vehicle> vehicleList = new ArrayList<>();

    public Bodywork(String bodyType, String internalDimensions) {
        super();

        this.bodyType = bodyType;
        this.internalDimensions = internalDimensions;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(Bodywork.class);
    }

    public void addVehicle(Vehicle vehicle){
        if(vehicle == null){
            throw new NullPointerException();
        }
        if(!vehicleList.contains(vehicle)){
            vehicleList.add(vehicle);
            vehicle.addBodywork(this);
        }
    }

    @Override
    public String toString() {
        return "Bodywork{" +
                "bodyType='" + bodyType + '\'' +
                ", internalDimensions='" + internalDimensions + '\'' +
                '}';
    }
}
