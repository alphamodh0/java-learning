package com.samuelmontalvoa;

import javax.swing.*;

public class Binary2Decimal {
    public static void main(String[] args) {
        try {

            // Make native Windows the default theme for the app
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");

            String binary = JOptionPane.showInputDialog(null, "Write a binary number: ");

            while (hasInvalidChar(binary)) {
                JOptionPane.showMessageDialog(null, "You cannot input invalid characters like " +
                        "letter or numbers different than 1 or 0!");
                binary = JOptionPane.showInputDialog(null, "Write a binary number: ");
            }

            int decimal = 0;

            for (int i = 0; i < binary.length(); i++) {
                char character = binary.charAt(i);
                if (character == '1') {
                    decimal = decimal * 2 + 1;
                } else if (character == '0') {
                    decimal = decimal * 2;
                }
            }

            JOptionPane.showMessageDialog(null, "Your decimal value is " + decimal);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean hasInvalidChar(String string) {
        boolean invalidChar = false;

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character != '1' && character != '0')
                return true;
        }
        return invalidChar;
    }
}
