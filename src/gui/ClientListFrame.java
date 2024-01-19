package gui;

import logic.Client;
import logic.CompanyWorker;
import logic.ObjectPlus;
import logic.PersonClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ClientListFrame extends JFrame {
    private JList<Client> customerList;
    private DefaultListModel<Client> listModel;

    public ClientListFrame() {
        setTitle("Lista Klientów");
        setSize(2000, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        customerList = new JList<>(listModel);
        add(new JScrollPane(customerList), BorderLayout.CENTER);

        loadCustomers();

        customerList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(e.getClickCount() == 2){
                    showReservations(customerList.getSelectedValue());
                }
            }
        });
    }

    private void loadCustomers() {
        try {
            List<ObjectPlus> customers = PersonClient.getListOfExtents(CompanyWorker.class);
            for (ObjectPlus customer : customers) {
                listModel.addElement((Client) customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Błąd podczas ładowania klientów: " + e.getMessage(), "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showReservations(Client client){
        ClientInfoFrame frame = new ClientInfoFrame(client);
        frame.setVisible(true);
    }
}
