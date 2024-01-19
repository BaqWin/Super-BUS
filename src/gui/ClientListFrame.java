package gui;

import logic.Client;
import logic.ObjectPlus;
import logic.PersonClient;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClientListFrame extends JFrame {
    private JList<String> customerList;
    private DefaultListModel<String> listModel;

    public ClientListFrame() {
        setTitle("Lista Klientów");
        setSize(2000, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        customerList = new JList<>(listModel);
        add(new JScrollPane(customerList), BorderLayout.CENTER);

        loadCustomers();
    }

    private void loadCustomers() {
        try {
            List<ObjectPlus> customers = PersonClient.getListOfExtents(PersonClient.class);
            for (ObjectPlus customer : customers) {
                // Zakładając, że ObjectPlus ma metodę toString() lub inną metodę do reprezentacji tekstowej
                listModel.addElement(customer.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Błąd podczas ładowania klientów: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }
}
