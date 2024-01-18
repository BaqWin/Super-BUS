package logic;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservation extends ObjectPlus implements Serializable {
    private LocalDate bookingDate;
    private LocalDate beginDate;
    private LocalDate endDate;
    private String status;
    private int rentDays;
    private double finalPrice;
    private Client client;

    private Reservation(Client client, Vehicle vehicle, LocalDate bookingDate, LocalDate beginDate,
                        LocalDate endDate){
        this.bookingDate = bookingDate;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.client = client;
    }

    public static Reservation createReservation(Client client, Vehicle vehicle, LocalDate bookingDate,
                                                LocalDate beginDate, LocalDate endDate) throws Exception{
        if(client == null){
            throw new Exception("Client doesnot exist");
        }

        Reservation reservation = new Reservation(client, vehicle, bookingDate, beginDate, endDate);
        client.addReservation(reservation);

        return reservation;
    }
}
