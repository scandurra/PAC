package helloSwing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Simple Swing example demonstrating JColorChooser. Allows user to select a
 * color and updates panel background.
 */
public class ColorSelector {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("Color Selector");
		JPanel panel = new JPanel();
		panel.setBounds(50, 50, 200, 100);
		panel.setBackground(Color.LIGHT_GRAY);

		JButton button = new JButton("Choose Color");
		button.setBounds(50, 200, 150, 30);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color selectedColor = JColorChooser.showDialog(frame, "Select a color", panel.getBackground());
				if (selectedColor != null) {
					panel.setBackground(selectedColor);
				}
			}
		});

		frame.add(panel);
		frame.add(button);
		frame.setSize(300, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}