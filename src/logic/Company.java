package logic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Company extends Client implements Serializable {
    private String name;
    private String nip; //TODO Make it unique

    public Company(String name, String nip, String address, double discount, String phoneNumber) {
        super(address, discount, phoneNumber);

        this.name = name;
        this.nip = nip;
    }

    public static void showExtent() throws Exception{
        ObjectPlus.showExtent(Company.class);
    }

    public List<String> showAllRentedVehicles(){
        List<String> list = new ArrayList<>();
        for(var reservation : this.getReservations()){
            for(var vehicle : reservation.getVehicles()){
                list.add(vehicle.toString());
            }
        }
        return list;
    }

    public String getName() {
        return name;
    }

    public String getNip() {
        return nip;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                ", address='" + getAddress() + '\'' +
                ", discount=" + getDiscount() +
                ", phoneNumber='" + getPhoneNumber() + '\'' +
                '}';
    }
}
