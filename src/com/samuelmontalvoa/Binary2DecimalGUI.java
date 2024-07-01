package com.samuelmontalvoa;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Binary2DecimalGUI extends JFrame {
    private final JTextField binaryField;
    private final JLabel resultLabel;

    public Binary2DecimalGUI() {
        setTitle("Binary to Decimal Converter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        setLocationRelativeTo(null);

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Create the binary input field
        JLabel binaryLabel = new JLabel("Binary Number:");
        binaryField = new JTextField(10);
        mainPanel.add(binaryLabel);
        mainPanel.add(binaryField);

        // Create the result label
        JLabel resultTextLabel = new JLabel("Decimal Value:");
        resultLabel = new JLabel();
        mainPanel.add(resultTextLabel);
        mainPanel.add(resultLabel);

        // Add the main panel to the frame
        add(mainPanel, BorderLayout.CENTER);

        // Add a button to convert the binary number
        JButton convertButton = new JButton("Convert");
        convertButton.addActionListener(_ -> convertBinary());
        add(convertButton, BorderLayout.SOUTH);
    }

    private void convertBinary() {
        String binary = binaryField.getText();

        if (hasInvalidChar(binary)) {
            resultLabel.setText("Invalid binary number!");
        } else {
            int decimal = 0;
            for (int i = 0; i < binary.length(); i++) {
                char character = binary.charAt(i);
                if (character == '1') {
                    decimal = decimal * 2 + 1;
                } else if (character == '0') {
                    decimal = decimal * 2;
                }
            }
            resultLabel.setText(String.format("%,d", decimal));
        }
    }

    private static boolean hasInvalidChar(String string) {
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character != '1' && character != '0')
                return true;
        }
        return false;
    }

    public static void main() {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            } catch (Exception e) {
                Logger.getLogger(Binary2DecimalGUI.class.getName()).log(Level.SEVERE, "Exception occurred");
            }
            new Binary2DecimalGUI().setVisible(true);
        });
    }
}
