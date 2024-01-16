package logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Hashtable;
import java.util.Map;

public abstract class Vehicle extends ObjectPlus implements Serializable {
    private String vin;
    private double maxPayload;
    private double price;

    private Map<LocalDate, LocalDate> reservationDates = new Hashtable<>();

    public Vehicle(String vin, double maxPayload, double price){
        super();

        this.vin = vin;
        this.maxPayload = maxPayload;
        this.price = price;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(PersonClient.class);
    }

    public boolean isDateAvailable(LocalDate newStartDate, LocalDate newEndDate) {
        for (var entry : reservationDates.entrySet()) {
            LocalDate startDate = entry.getKey();
            LocalDate endDate = entry.getValue();

            if (newStartDate.isBefore(endDate) && newEndDate.isAfter(startDate)) {
                return false;
            }
        }
        return true;
    }

    public void addReservationDate(LocalDate start, LocalDate end) {
        reservationDates.put(start, end);
    }
}
