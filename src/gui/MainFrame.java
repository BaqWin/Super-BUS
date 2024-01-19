package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    private JButton showCustomersButton, createReservationButton;

    public MainFrame() {
        setTitle("System Zarządzania Rezerwacjami");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        showCustomersButton = new JButton("Pokaż wszystkich klientów");
        add(showCustomersButton);
        showCustomersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAllCustomers();
            }
        });

        createReservationButton = new JButton("Stwórz nową rezerwację");
        add(createReservationButton);
        createReservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewReservation();
            }
        });
    }

    private void showAllCustomers() {
        JOptionPane.showMessageDialog(this, "Pokazuje wszystkich klientów");
    }

    private void createNewReservation() {
        this.setVisible(false);

        ClientFrame clientFrame = new ClientFrame(this);
        clientFrame.setVisible(true);
    }
}
