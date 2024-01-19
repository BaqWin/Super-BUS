package logic;

import java.io.Serializable;

public class RentalType extends ObjectPlus implements Serializable {
    private String type;
    private double additionalDiscount;

    private Reservation reservation;

    public RentalType(Reservation reservation) {
        addReservation(reservation);
    }

    public void addReservation(Reservation reservation){
        if(reservation == null){
            throw new NullPointerException();
        }
        if(this.reservation == null){
            this.reservation = reservation;
        }
    }

    public void calculateAdditionalDiscount(){
        int tmp = reservation.getRentDays();
        if(tmp < 30){
            additionalDiscount = 0.05;
            type = "Krótkoterminowy";
        }else if(tmp < 90){
            additionalDiscount = 0.1;
            type = "Długoterminowy";
        }else{
            additionalDiscount = 0.3;
            type = "Długoterminowy";
        }
    }

    public String getType() {
        return type;
    }

    public double getAdditionalDiscount() {
        return additionalDiscount;
    }

    @Override
    public String toString() {
        return "RentalType{" +
                "type='" + type + '\'' +
                ", additionalDiscount=" + additionalDiscount +
                '}';
    }
}
