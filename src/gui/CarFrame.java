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
    private JList<Client> customerList;
    private DefaultListModel<Client> listModel;
    private ClientFrame clientFrame;

    private Reservation reservation;
    public CarFrame(ClientFrame clientFrame, Reservation reservation) {
        this.clientFrame = clientFrame;
        this.reservation = reservation;
        setTitle("Wybierz Pojazd");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        customerList = new JList<>(listModel);
        add(new JScrollPane(customerList), BorderLayout.CENTER);

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
                Object selectedCustomer = customerList.getSelectedValue();
//                if (selectedCustomer != null) {
//                    addCustomer((Client) selectedCustomer);
//                } else {
//                    JOptionPane.showMessageDialog(ClientFrame.this, "Proszę wybrać klienta z listy.");
//                }
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
        }catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Błąd podczas ładowania pojazdów: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCustomer(Client client) {

    }
}
