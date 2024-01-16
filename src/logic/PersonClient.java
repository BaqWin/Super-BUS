package logic;

import java.io.Serializable;
import java.time.*;
import java.util.*;

public class PersonClient extends Client implements Serializable {
    String firstName;
    String lastName;
    LocalDate birthDate;
    int yearsOld;
    List<String> licenses = new ArrayList();
    String pesel;
    String email;
    public PersonClient(String firstName, String lastName, LocalDate birthDate,
                        String license, String pesel, String email,
                        String address, double discount, String phoneNumber) {
        super(address, discount, phoneNumber);

        this.firstName = firstName;
        this.lastName = lastName;
        setBirthDate(birthDate);
        countYearsOld();
        licenses.add(license);
        this.pesel = pesel;
        this.email = email;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(PersonClient.class);
    }

    private void countYearsOld(){
        LocalDate currentDate = LocalDate.now();
        this.yearsOld = Period.between(birthDate, currentDate).getYears();
    }

    public void setBirthDate(LocalDate date){
        LocalDate currentDate = LocalDate.now();
        if (date != null && date.isBefore(currentDate)
                && Period.between(date, currentDate).getYears() >= 18) {
            this.birthDate = date;
        } else {
            throw new IllegalArgumentException("Data urodzenia musi być wcześniejsza niż obecna data.");
        }
    }

    @Override
    public String toString() {
        return "PersonClient{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", yearsOld=" + yearsOld +
                ", licenses=" + licenses +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", discount=" + discount +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
