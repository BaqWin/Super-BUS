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

    private Reservation(Client client){
        this.client = client;
    }

    public static Reservation createReservation(Client client){
        if(client == null){
            throw new NullPointerException();
        }

        Reservation reservation = new Reservation(client);
        client.addReservation(reservation);

        return reservation;
    }

    public void addRentalDates(LocalDate startDate, LocalDate endDate) throws Exception{
        if(!vehicles.isEmpty()){
            for (Vehicle vehicle : vehicles) {
                if(!vehicle.isDateAvailable(startDate, endDate)){
                    throw new Exception("Rent date is not available");
                }
            }
            for (Vehicle vehicle : vehicles) {
                vehicle.addReservationDate(startDate, endDate);
            }
            this.beginDate = startDate;
            this.endDate = endDate;
        }else{
            throw new Exception("There is no vehicle in reservation!");
        }
    }

    public String reservationDetails(){
        String ret = "Reservation Details: {";
        for (Vehicle vehicle : vehicles) {
            ret += vehicle;
        }
        ret += "}";
        return ret;//TODO
    }

    public void cancelReservation(){
        //TODO
    }

    public void countFinalPrice(){
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
