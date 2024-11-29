package dev.lpa;

import javax.swing.*;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        for (Locale l : List.of(Locale.US, Locale.CANADA_FRENCH,
                Locale.CANADA)) {
            ResourceBundle rb = ResourceBundle.getBundle("BasicText", l);
//            System.out.println(rb.getClass().getName());
//            System.out.println(rb.getBaseBundleName());
//            System.out.println(rb.keySet());

            String message = "%s %s!%n".formatted(
                    rb.getString("hello"), rb.getString("world"));

            ResourceBundle ui = ResourceBundle.getBundle("UIComponents", l);

            JOptionPane.showOptionDialog(null,
                    message,
                    ui.getString("first.title"),
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    new Object[]{rb.getString("yes"), rb.getString("no")},
                    null);
        }
    }
}
