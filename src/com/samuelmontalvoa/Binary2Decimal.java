package com.samuelmontalvoa;

import org.jetbrains.annotations.NotNull;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Binary2Decimal {
    public static void main() {
        try {

            Scanner in = new Scanner(System.in);
            System.out.print("Write a binary number: ");
            String binary = in.nextLine();

            while (hasInvalidChar(binary)) {
                System.out.println("You cannot input invalid characters like " +
                        "letter or numbers different than 1 or 0!");
                System.out.print("Write a binary number: ");
                binary = in.nextLine();
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

            System.out.printf("Your decimal value is %,d", decimal);
        } catch (Exception e) {
            Logger.getLogger(Binary2Decimal.class.getName()).log(Level.SEVERE, "Exception occurred", e);
        }

    }
    public static boolean hasInvalidChar(@NotNull String string) {
        boolean invalidChar = false;

        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (character != '1' && character != '0')
                return true;
        }
        return invalidChar;
    }
}



