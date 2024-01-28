package gui;

import logic.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
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

    private void showReservations(Client client){
        ClientInfoFrame frame = new ClientInfoFrame(client);
        frame.setVisible(true);
    }
}
