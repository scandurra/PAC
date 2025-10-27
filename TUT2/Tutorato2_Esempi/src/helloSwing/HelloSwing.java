package helloSwing;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple Swing example showing a JFrame with a JLabel and JButton.
 * Clicking the button updates the label text.
 */
public class HelloSwing {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Swing Example");
        JLabel label = new JLabel("Hello, Swing!");
        label.setBounds(50, 50, 200, 30);

        JButton button = new JButton("Click Me");
        button.setBounds(50, 100, 100, 30);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.setText("Button Clicked!");
            }
        });

        frame.add(label);
        frame.add(button);
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
