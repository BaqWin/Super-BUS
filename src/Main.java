import logic.Client;
import logic.ObjectPlus;
import logic.PersonClient;

import java.io.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String extentFile = "extent.bin";
//        if(new File(extentFile).isFile()){
//            try{
//                ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(extentFile));
//                ObjectPlus.readExtents(objectInputStream);
//            }catch (IOException | ClassNotFoundException e){
//                throw new RuntimeException(e);
//            }
//        }

        PersonClient p1 = new PersonClient("Janusz", "Tracz",
                LocalDate.of(1990, 04, 20), "B", "12345678901",
                "tracz@tulczyn.net", "Tulczyn", 0.2, "555-676-888");
        PersonClient p2 = new PersonClient("Adam", "Pracz",
                LocalDate.of(1994, 05, 02), "C", "12345678902",
                "pracz@tulczyn.net", "Tulczyn", 0.2, "555-676-878");
        p2.addLicense("CE");

        try {
            PersonClient.showExtent();

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(extentFile));
            ObjectPlus.writeExtents(objectOutputStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}