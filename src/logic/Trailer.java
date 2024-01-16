package logic;

import java.io.Serializable;

public class Trailer extends Vehicle implements Serializable {
    String externalDimensions;
    double axleHeight;
    public Trailer(String externalDimensions, double axleHeight, String vin, double maxPayload, double price) {
        super(vin, maxPayload, price);

        this.externalDimensions = externalDimensions;
        this.axleHeight = axleHeight;
    }

    public String getExternalDimensions() {
        return externalDimensions;
    }

    public double getAxleHeight() {
        return axleHeight;
    }
}
