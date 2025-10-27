package helloSwing;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Swing example demonstrating KeyListener.
 * Shows the last pressed key in a JLabel.
 */
public class KeyEventDemo {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("Key Event Demo");
        JLabel label = new JLabel("Press any key...");
        label.setBounds(50, 50, 200, 30);

        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 150, 30);
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {
                label.setText("Key Pressed: " + e.getKeyChar());
            }

            @Override
            public void keyReleased(KeyEvent e) {}
        });

        frame.add(label);
        frame.add(textField);
        frame.setSize(300, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
