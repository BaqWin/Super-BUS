package gui;

import logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class CarFrame extends JFrame {
    private JButton addButton, backButton;
    private JList<Vehicle> vehicleList;
    private DefaultListModel<Vehicle> listModel;
    private ClientFrame clientFrame;
    private Client client;
    public CarFrame(ClientFrame clientFrame, Client client) {
        this.clientFrame = clientFrame;
        this.client = client;
        setTitle("Wybierz Pojazd");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        vehicleList = new JList<>(listModel);
        add(new JScrollPane(vehicleList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Dodaj pojazd");
        backButton = new JButton("Wróć");
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadVehicles();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedVehicle = vehicleList.getSelectedValue();
                if (selectedVehicle != null) {
                    addVehicle((Vehicle) selectedVehicle);
                } else {
                    JOptionPane.showMessageDialog(CarFrame.this, "Proszę wybrać pojazd z listy.");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CarFrame.this.setVisible(false);
                CarFrame.this.clientFrame.setVisible(true);
            }
        });
    }

    private void loadVehicles() {
        try{
            List<List<ObjectPlus>> vehicles = new ArrayList<>();
            vehicles.add(CargoVan.getListOfExtents(CargoVan.class));
            vehicles.add(Truck.getListOfExtents(Truck.class));
            vehicles.add(TractorTruck.getListOfExtents(TractorTruck.class));
            vehicles.add(Trailer.getListOfExtents(Trailer.class));
            for (List<ObjectPlus> vehicleList : vehicles) {
                for (ObjectPlus vehicle : vehicleList) {
                    listModel.addElement((Vehicle) vehicle);
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Błąd podczas ładowania pojazdów: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addVehicle(Vehicle vehicle) {
        DateFrame dateFrame = new DateFrame(this, client, vehicle);

        this.setVisible(false);
        dateFrame.setVisible(true);
    }
}
