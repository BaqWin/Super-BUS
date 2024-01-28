package gui;

import logic.Client;
import logic.Company;
import logic.PersonClient;
import logic.Reservation;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClientInfoFrame extends JFrame {
    private JLabel nameLabel;
    private JTextField nameField;
    private JLabel reservationsLabel;
    private JList<String> reservationsList;
    private DefaultListModel<String> reservationsModel;

    public ClientInfoFrame(Client client) {
        setTitle("Informacje o Kliencie");
        setSize(2000, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        nameLabel = new JLabel("Imię i nazwisko: ");
        if (client instanceof PersonClient) {
            nameField = new JTextField(((PersonClient) client).getFirstName() + " "
                    + ((PersonClient) client).getLastName(), 20);
        } else if (client instanceof Company) {
            nameField = new JTextField(((Company) client).getName(), 20);
        }
        nameField.setEditable(false);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        add(namePanel, BorderLayout.NORTH);

        JPanel reservationsPanel = new JPanel(new BorderLayout());
        reservationsLabel = new JLabel("Rezerwacje:");
        reservationsPanel.add(reservationsLabel, BorderLayout.WEST);

        reservationsModel = new DefaultListModel<>();
        reservationsList = new JList<>(reservationsModel);
        reservationsPanel.add(new JScrollPane(reservationsList), BorderLayout.CENTER);

        add(reservationsPanel, BorderLayout.CENTER);

        loadReservations(client);
    }

    private void loadReservations(Client client){
        List<Reservation> reservationList = client.getReservations();
        if (reservationList != null && !reservationList.isEmpty()) {
            for (Reservation reservation : reservationList) {
                reservationsModel.addElement(reservation.toString());
            }
        } else {
            reservationsModel.addElement("Brak rezerwacji");
        }
    }
}