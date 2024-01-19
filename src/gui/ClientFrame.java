package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class ClientFrame extends JFrame {
    private JButton addButton, backButton;
    private JList<String> customerList;
    private DefaultListModel<String> listModel;
    private MainFrame mainFrame;
    public ClientFrame(MainFrame mainFrame) { // Zmodyfikowany konstruktor
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

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCustomer();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

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

    private void addCustomer() {

    }
}
