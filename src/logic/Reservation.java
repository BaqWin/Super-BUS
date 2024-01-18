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

    private Reservation(Client client, Vehicle vehicle, LocalDate bookingDate, LocalDate beginDate,
                        LocalDate endDate){
        this.bookingDate = bookingDate;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.client = client;
    }

    public static Reservation createReservation(Client client, Vehicle vehicle, LocalDate bookingDate,
                                                LocalDate beginDate, LocalDate endDate){
        if(client == null){
            throw new NullPointerException();
        }

        Reservation reservation = new Reservation(client, vehicle, bookingDate, beginDate, endDate);
        client.addReservation(reservation);

        return reservation;
    }

    public String reservationDetails(){
        return "";
    }

    public void extendReservation(int days){

    }

    public void cancelReservation(){

    }

    public void countFinalPrice(){

    }

    public void addRentalType(){

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

    public boolean checkForLicense(){
        return false;
    }
}
