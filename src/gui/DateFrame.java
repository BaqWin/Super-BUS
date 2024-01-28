package gui;

import logic.Client;
import logic.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;

public class DateFrame extends JFrame {
    private JTextField dayField, monthField, yearField, endDayField, endMonthField, endYearField;

    private JButton saveButton, backButton;
    private CarFrame carFrame;
    private Client client;
    private Vehicle vehicle;

    public DateFrame(CarFrame carFrame, Client client, Vehicle vehicle) {
        this.carFrame = carFrame;
        this.client = client;
        this.vehicle = vehicle;
        setTitle("Wprowadź datę");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel startDateLabel = new JLabel("Data rozpoczęcia");
        startDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(startDateLabel);

        JPanel datePanel = new JPanel();
        datePanel.setLayout(new GridLayout(0, 2));
        dayField = new JTextField();
        monthField = new JTextField();
        yearField = new JTextField();
        datePanel.add(new JLabel("Dzień:"));
        datePanel.add(dayField);
        datePanel.add(new JLabel("Miesiąc:"));
        datePanel.add(monthField);
        datePanel.add(new JLabel("Rok:"));
        datePanel.add(yearField);
        add(datePanel);

        JLabel endDateLabel = new JLabel("Data zakończenia");
        endDateLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(endDateLabel);

        JPanel endDatePanel = new JPanel();
        endDatePanel.setLayout(new GridLayout(0, 2));
        endDayField = new JTextField();
        endMonthField = new JTextField();
        endYearField = new JTextField();
        endDatePanel.add(new JLabel("Dzień:"));
        endDatePanel.add(endDayField);
        endDatePanel.add(new JLabel("Miesiąc:"));
        endDatePanel.add(endMonthField);
        endDatePanel.add(new JLabel("Rok:"));
        endDatePanel.add(endYearField);
        add(endDatePanel);

        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Zapisz");
        backButton = new JButton("Wróć");
        buttonPanel.add(saveButton);
        buttonPanel.add(backButton);
        add(buttonPanel);

        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validateAndSaveDate();
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DateFrame.this.setVisible(false);
                DateFrame.this.carFrame.setVisible(true);
            }
        });
    }

    private void validateAndSaveDate() {
        try {
            int day = Integer.parseInt(dayField.getText());
            int month = Integer.parseInt(monthField.getText());
            int year = Integer.parseInt(yearField.getText());

            int endDay = Integer.parseInt(endDayField.getText());
            int endMonth = Integer.parseInt(endMonthField.getText());
            int endYear = Integer.parseInt(endYearField.getText());

            LocalDate date = LocalDate.of(year, month, day);
            LocalDate endDate = LocalDate.of(endYear, endMonth, endDay);

            validateIfCarHaveFreeDate(date, endDate);

        } catch (DateTimeException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Wprowadzono niepoprawną datę!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void validateIfCarHaveFreeDate(LocalDate date, LocalDate endDate) {
        if(vehicle.isDateAvailable(date, endDate)){
            nextFrame(date, endDate);
        }else{
            JOptionPane.showMessageDialog(this, "Wprowadzono datę która jest zajęta!", "Błąd", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void nextFrame(LocalDate date, LocalDate endDate){
        SummaryFrame summaryFrame = new SummaryFrame(this, client, vehicle, date, endDate);

        this.setVisible(false);
        summaryFrame.setVisible(true);
    }
}
