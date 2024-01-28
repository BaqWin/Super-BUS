package gui;

import logic.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SummaryFrame extends JFrame {
    private JTable clientTable, vehicleTable;
    private JTextField startDateField, endDateField;
    private JButton acceptButton, backButton;
    private DateFrame dateFrame;

    public SummaryFrame(DateFrame dateFrame, Client client, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        this.dateFrame = dateFrame;
        setTitle("Podsumowanie");
        setSize(600, 400);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] clientColumnNames = {"Pole", "Wartość"};
        String[][] clientData = new String[0][];
        if(client instanceof PersonClient){
            clientData = new String[][]{
                    {"Imię", ((PersonClient) client).getFirstName()},
                    {"Nazwisko", ((PersonClient) client).getLastName()},
                    {"Wiek", String.valueOf(((PersonClient) client).getYearsOld())},
                    {"PESEL:", ((PersonClient) client).getPesel()}
            };
        }else if(client instanceof CompanyWorker){
            clientData = new String[][]{
                    {"Imię", ((CompanyWorker) client).getFirstName()},
                    {"Nazwisko", ((CompanyWorker) client).getLastName()},
                    {"Wiek", String.valueOf(((CompanyWorker) client).getYearsOld())},
                    {"PESEL:", ((CompanyWorker) client).getPesel()},
                    {"Nazwa Firmy:", ((CompanyWorker) client).getCompany().getName()},
                    {"NIP:", ((CompanyWorker) client).getCompany().getNip()},
                    {"Pozycja:", ((CompanyWorker) client).getPosition()},
            };
        }else if(client instanceof Company){
            clientData = new String[][]{
                    {"Nazwa Firmy:", ((Company) client).getName()},
                    {"NIP:", ((Company) client).getNip()},
            };
        }
        clientTable = new JTable(new DefaultTableModel(clientData, clientColumnNames));
        add(new JScrollPane(clientTable));


        String[] vehicleColumnNames = {"Pole", "Wartość"};
        String[][] vehicleData = new String[0][];
        if(vehicle instanceof Car){
            vehicleData = new String[][]{
                    {"Car Brand:", ((Car) vehicle).getBrand()},
                    {"Car Model:", ((Car) vehicle).getModel()},
                    {"Car Engine:", ((Car) vehicle).getEngine()}
            };
        }else if(vehicle instanceof Trailer){
            vehicleData = new String[][]{
                    {"Przyczepa Typ:", ((Trailer) vehicle).getBodywork().getBodyType()},
                    {"Przyczepa Wymiary:", ((Trailer) vehicle).getBodywork().getInternalDimensions()},
            };
        }

        vehicleTable = new JTable(new DefaultTableModel(vehicleData, vehicleColumnNames));
        add(new JScrollPane(vehicleTable));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new FlowLayout());
        startDateField = new JTextField(10);
        endDateField = new JTextField(10);
        startDateField.setText(startDate.format(formatter));
        endDateField.setText(endDate.format(formatter));
        startDateField.setEditable(false);
        endDateField.setEditable(false);
        datePanel.add(new JLabel("Data rozpoczęcia:"));
        datePanel.add(startDateField);
        datePanel.add(new JLabel("Data zakończenia:"));
        datePanel.add(endDateField);
        add(datePanel);

        JPanel buttonPanel = new JPanel();
        acceptButton = new JButton("Akceptuj");
        backButton = new JButton("Wróć");
        buttonPanel.add(acceptButton);
        buttonPanel.add(backButton);
        add(buttonPanel);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reservation reservation = Reservation.createReservation(client);
                reservation.addVehicle(vehicle);
                try {
                    reservation.addRentalDates(startDate, endDate);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(SummaryFrame.this, "Niepoprawna data", "Błąd", JOptionPane.ERROR_MESSAGE);
                }
                SummaryFrame.this.setVisible(false);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SummaryFrame.this.setVisible(false);
                SummaryFrame.this.dateFrame.setVisible(true);
            }
        });

        setLocationRelativeTo(null);
    }
}
