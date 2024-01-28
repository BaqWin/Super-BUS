package gui;

import logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class ClientFrame extends JFrame {
    private JButton addButton, backButton;
    private JList<Client> customerList;
    private DefaultListModel<Client> listModel;
    private MainFrame mainFrame;
    public ClientFrame(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setTitle("Wybierz Klienta");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        customerList = new JList<>(listModel);
        add(new JScrollPane(customerList), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Dodaj klienta");
        backButton = new JButton("Wróć");
        buttonPanel.add(addButton);
        buttonPanel.add(backButton);
        add(buttonPanel, BorderLayout.SOUTH);

        loadCustomers();

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedCustomer = customerList.getSelectedValue();
                if (selectedCustomer != null) {
                    addCustomer((Client) selectedCustomer);
                } else {
                    JOptionPane.showMessageDialog(ClientFrame.this, "Proszę wybrać klienta z listy.");
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientFrame.this.setVisible(false);
                ClientFrame.this.mainFrame.setVisible(true);
            }
        });
    }

    private void loadCustomers() {
        try {
            List<List<ObjectPlus>> customers = new ArrayList<>();
            customers.add(PersonClient.getListOfExtents(PersonClient.class));
            customers.add(CompanyWorker.getListOfExtents(CompanyWorker.class));
            customers.add(Company.getListOfExtents(Company.class));
            //TODO Błąd - duplikacja klienta jezeli dziedziczy on po PersonClient
            for (List<ObjectPlus> customerList : customers) {
                for (ObjectPlus customer : customerList) {
                    listModel.addElement((Client) customer);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Błąd podczas ładowania klientów: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addCustomer(Client client) {
        Reservation reservation = Reservation.createReservation(client);
        CarFrame carFrame = new CarFrame(this, reservation);

        this.setVisible(false);
        carFrame.setVisible(true);
    }
}
