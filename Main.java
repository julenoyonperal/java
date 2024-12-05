import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class HelloWorldWindow {
    public static void main(String[] args) {
        // Create a new JFrame (the window)
        JFrame frame = new JFrame("Hello World Window");

        // Set default close operation to exit the application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a JLabel with the "Hello, World!" text
        JLabel label = new JLabel("Hello, World!", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24)); // Set font style and size

        // Add the label to the frame
        frame.add(label);

        // Set the window size
        frame.setSize(400, 200);

        // Center the window on the screen
        frame.setLocationRelativeTo(null);

        // Make the window visible
        frame.setVisible(true);

        // Create a timer to close the window after 10
