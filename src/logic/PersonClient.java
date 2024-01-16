package logic;

import java.io.Serializable;
import java.time.*;
import java.util.*;

public class PersonClient extends Client implements Serializable {
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private int yearsOld;
    private List<String> licenses = new ArrayList();
    private String pesel;
    private String email;

    public PersonClient(String firstName, String lastName, LocalDate birthDate,
                        String license, String pesel, String email,
                        String address, double discount, String phoneNumber) {
        super(address, discount, phoneNumber);

        this.firstName = firstName;
        this.lastName = lastName;
        setBirthDate(birthDate);
        countYearsOld();
        addLicense(license);
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
            throw new IllegalArgumentException("Incorrect date of birth");
        }
    }

    public void addLicense(String license){
        if (license.equals("B") || license.equals("C") || license.equals("CE")) {
            licenses.add(license);
        } else {
            throw new IllegalArgumentException("Permitted licenses: B, C, CE");
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
                ", address='" + getAddress() + '\'' +
                ", discount=" + getDiscount() +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}
