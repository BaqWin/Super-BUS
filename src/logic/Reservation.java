package logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

public class Reservation extends ObjectPlus implements Serializable {
    private LocalDate bookingDate;
    private LocalDate beginDate;
    private LocalDate endDate;
    private String status;
    private int rentDays;
    private double finalPrice;

    private Client client;
    private List<Vehicle> vehicles = new ArrayList<>();
    private RentalType rentalType;

    private Reservation(Client client, LocalDate bookingDate, LocalDate beginDate,
                        LocalDate endDate){
        this.bookingDate = bookingDate;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.client = client;
    }

    public static Reservation createReservation(Client client, LocalDate bookingDate,
                                                LocalDate beginDate, LocalDate endDate){
        if(client == null){
            throw new NullPointerException();
        }

        Reservation reservation = new Reservation(client, bookingDate, beginDate, endDate);
        client.addReservation(reservation);

        return reservation;
    }

    public String reservationDetails(){
        return "";//TODO
    }

    public void extendReservation(int days){
        //TODO
    }

    public void cancelReservation(){
        //TODO
    }

    public void countFinalPrice(){
        //TODO
    }

    public void addRentalType(){
        //TODO
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status){
        if(status.equals("Planowana") || status.equals("W trakcie realizacji") ||
                status.equals("Anulowana") || status.equals("Zakończona")){
            this.status = status;
        }
    }

    public void addVehicle(Vehicle vehicle){
        if(vehicle == null){
            throw new NullPointerException();
        }
        if(!vehicles.contains(vehicle)){
            vehicles.add(vehicle);
            vehicle.addReservation(this);
        }
    }

    public void addRentalType(RentalType rentalType){
        if(rentalType == null){
            throw new NullPointerException();
        }
        if(this.rentalType == null){
            this.rentalType = rentalType;
        }
    }

    public boolean checkForLicense(){
        return false;//TODO
    }

    public int getRentDays() {
        return rentDays;
    }
}
