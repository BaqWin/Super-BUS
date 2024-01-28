package logic;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompanyWorker extends PersonClient implements Serializable, ICompany {
    private String position;
    private Company company;

    public CompanyWorker(String firstName, String lastName, LocalDate birthDate, String license,
                         String pesel, String email, String address, double discount, String phoneNumber,
                         String position, String companyName, String companynNip) {
        super(firstName, lastName, birthDate, license, pesel, email, address, discount, phoneNumber);

        this.position = position;

        company = new Company(companyName, companynNip, null, 0, null);
    }

    public CompanyWorker(String firstName, String lastName, LocalDate birthDate, String license,
                         String pesel, String email, String address, double discount, String phoneNumber,
                         String position, Company company) {
        super(firstName, lastName, birthDate, license, pesel, email, address, discount, phoneNumber);

        this.position = position;
        this.company = company;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(CompanyWorker.class);
    }

    public String getPosition() {
        return position;
    }

    public Company getCompany() {
        return company;
    }

    @Override
    public List<String> showAllRentedVehicles(){
        List<String> list = new ArrayList<>();
        for(var reservation : this.getReservations()){
            for(var vehicle : reservation.getVehicles()){
                list.add(vehicle.toString());
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "CompanyWorker{" +
                "company={name='" + company.getName() + '\'' +
                ", NIP='" + company.getNip() + '\'' + "}" +
                ", position='" + position + '\'' +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", birthDate='" + getBirthDate() + '\'' +
                ", yearsOld='" + getYearsOld() + '\'' +
                ", licenses='" + getLicenses() + '\'' +
                ", pesel='" + getPesel() + '\'' +
                ", email='" + getEmail() + '\'' +
                ",personal address='" + getAddress() + '\'' +
                ",personal phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}
