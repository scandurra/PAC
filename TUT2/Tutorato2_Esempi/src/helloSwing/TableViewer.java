package helloSwing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Swing example demonstrating JTable with scroll and dynamic row addition.
 */
public class TableViewer {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Table Viewer");

        String[] columns = {"ID", "Name", "Age"};
        Object[][] data = {
                {1, "Alice", 25},
                {2, "Bob", 30}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 300, 100);

        JButton addButton = new JButton("Add Row");
        addButton.setBounds(50, 200, 100, 30);
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] newRow = {model.getRowCount() + 1, "New Name", 20};
                model.addRow(newRow);
            }
        });

        frame.add(scrollPane);
        frame.add(addButton);
        frame.setSize(400, 300);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
