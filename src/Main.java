import gui.MainFrame;
import logic.*;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String extentFile = "extent.bin";
//        try {
//            loadExampleData();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
        loadData(extentFile);
        new MainFrame().setVisible(true);
        saveData(extentFile);
    }

    public static void loadExampleData() throws Exception {
        PersonClient p1 = new PersonClient("Janusz", "Tracz",
                LocalDate.of(1990, 04, 20), "B", "12345678901",
                "tracz@tulczyn.net", "Tulczyn", 0.2, "555-676-888");
        PersonClient p2 = new PersonClient("Adam", "Pracz",
                LocalDate.of(1994, 05, 02), "C", "12345678902",
                "pracz@tulczyn.net", "Tulczyn", 0.2, "555-676-878");
        p2.addLicense("CE");

        Trailer t1 = new Trailer("10x10", 20,"123", 2000, 80);
        Trailer t2 = new Trailer("200x50", 10,"1234", 2000, 90);
        Bodywork b1 = new Bodywork("Chlodnia", "200x200");
        Bodywork b2 = new Bodywork("Plandeka", "200x200");
        Vehicle c1 = new CargoVan("Renault", "Master", "2.5l Diesel", 200, "123456",
                1500, 150);
        Vehicle c2 = new Truck("Renault", "Mascott", "2.5l Diesel", 300, "1234567",
                3500, 250, true);
        Vehicle c3 = new CargoVan("Mercedes", "Sprinter", "2.5l Diesel", 400, "12345678",
                7500, 550);
        Vehicle c4 = new TractorTruck("Renault", "Giga", "2.5l Diesel", 400, "123456710",
                7500, 550, false);
        b1.addVehicle(t1);
        t1.addBodywork(b2);
        t2.addBodywork(b1);
        c1.addBodywork(b1);
        c2.addBodywork(b1);
        Client cl1 = new CompanyWorker("Janusz", "Tracz",
                LocalDate.of(1990, 04, 20), "B", "12345678904",
                "tracz@tulczyn.net", "Tulczyn", 0.2, "555-676-888",
                "Kierowca", "Tracz sp.z.o.o", "456543");
        Reservation r1 = Reservation.createReservation(cl1);
        r1.addVehicle(c1);
        r1.addRentalDates(LocalDate.of(2024, 01, 30),
                LocalDate.of(2024, 02, 04));

        Reservation r2 = Reservation.createReservation(cl1);
        r2.addVehicle(c3);
        r2.addRentalDates(LocalDate.of(2024, 01, 30),
                LocalDate.of(2024, 02, 04));

        Reservation r3 = Reservation.createReservation(p2);
        r3.addVehicle(c2);
        r3.addRentalDates(LocalDate.of(2024, 01, 30),
                LocalDate.of(2024, 02, 04));

        Reservation r4 = Reservation.createReservation(cl1);
        r4.addVehicle(c2);
        r4.addRentalDates(LocalDate.of(2025, 01, 30),
                LocalDate.of(2025, 02, 04));
    }

    public static void loadData(String extentFile){
        if(new File(extentFile).isFile()){
            try{
                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(extentFile));
                ObjectPlus.readExtents(objectInputStream);
            }catch (IOException | ClassNotFoundException e){
                throw new RuntimeException(e);
            }
        }
    }

    public static void saveData(String extentFile){
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(extentFile));
            ObjectPlus.writeExtents(objectOutputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}