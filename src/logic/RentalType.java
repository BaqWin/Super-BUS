package logic;

import java.io.Serializable;

public abstract class RentalType extends ObjectPlus implements Serializable {
    private double additionalPayment;

    public abstract void countAdditionalPayment();
}
