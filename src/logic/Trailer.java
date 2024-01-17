package logic;

import java.io.Serializable;

public class Trailer extends Vehicle implements Serializable {
    private String externalDimensions;
    private double axleHeight;
    public Trailer(String externalDimensions, double axleHeight, String vin, double maxPayload, double price) {
        super(vin, maxPayload, price);

        this.externalDimensions = externalDimensions;
        this.axleHeight = axleHeight;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(Trailer.class);
    }

    public String getExternalDimensions() {
        return externalDimensions;
    }

    public double getAxleHeight() {
        return axleHeight;
    }

    public void addBodywork(Bodywork bodywork){
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
        return "Trailer{" +
                "vin='" + getVin() + '\'' +
                ", maxPayload=" + getMaxPayload() +
                ", price=" + getPrice() +
                ", bodywork=" + getBodywork() +
                ", externalDimensions='" + externalDimensions + '\'' +
                ", axleHeight=" + axleHeight +
                '}';
    }
}
