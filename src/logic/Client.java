package logic;

import java.io.Serializable;
import java.util.*;

public abstract class Client extends ObjectPlus implements Serializable {
    private String address;
    private double discount;
    private String phoneNumber;
    private List<Reservation> reservations = new ArrayList<>();

    public Client(String address, double discount, String phoneNumber){
        super();

        this.address = address;
        this.discount = discount;
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public double getDiscount() {
        return discount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void addReservation(Reservation reservation){
        if(reservation == null){
            throw new NullPointerException("Reservation is null");
        }
        if(!reservations.contains(reservation)){
            reservations.add(reservation);
        }
    }

    public List<Reservation> getReservations() {
        return reservations;
    }
}
