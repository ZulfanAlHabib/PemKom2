package inventarisapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryApp extends JFrame {
    private Inventory<Item> inventory;
    private JTextArea textArea;
    private JTextField nameField;
    private JTextField quantityField;

    public InventoryApp() {
        inventory = new Inventory<>();
        setTitle("Inventory Management");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        nameField = new JTextField(10);
        quantityField = new JTextField(5);
        JButton addButton = new JButton("Add Item");
        JButton showButton = new JButton("Show Items");
        JButton editButton = new JButton("Edit Item");
        JButton removeButton = new JButton("Remove Item");

        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(quantityField);
        inputPanel.add(addButton);
        inputPanel.add(showButton);
        inputPanel.add(editButton);
        inputPanel.add(removeButton);

        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Action listener for adding items
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int quantity;
                try {
                    quantity = Integer.parseInt(quantityField.getText());
                    inventory.addItem(new Item(name, quantity));
                    textArea.append("Item added: " + name + " (Quantity: " + quantity + ")\n");
                } catch (NumberFormatException ex) {
                    textArea.append("Invalid quantity. Please enter a number.\n");
                }
                nameField.setText("");
                quantityField.setText("");
            }
        });

        // Action listener for showing items
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Item item : inventory.getItems()) {
                    textArea.append(item.toString() + "\n");
                }
            }
        });

        // Action listener for removing items
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                Item itemToRemove = null;
                for (Item item : inventory.getItems()) {
                    if (item.getName().equals(name)) {
                        itemToRemove = item;
                        break;
                    }
                }
                if (itemToRemove != null) {
                    inventory.removeItem(itemToRemove);
                    textArea.append("Item removed: " + itemToRemove + "\n");
                } else {
                    textArea.append("Item not found: " + name + "\n");
                }
                nameField.setText("");
                quantityField.setText("");
            }
        });

        // Action listener for editing items
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int newQuantity;
                try {
                    newQuantity = Integer.parseInt(quantityField.getText());
                    boolean found = false;

                    for (Item item : inventory.getItems()) {
                        if (item.getName().equals(name)) {
                            // Update the quantity of the found item
                            inventory.removeItem(item); // Remove the old item
                            inventory.addItem(new Item(name, newQuantity)); // Add the updated item
                            found = true;
                            textArea.append("Item updated: " + name + " (New Quantity: " + newQuantity + ")\n");
                            break;
                        }
                    }
                    if (!found) {
                        textArea.append("Item not found: " + name + "\n");
                    }
                } catch (NumberFormatException ex) {
                    textArea.append("Invalid quantity. Please enter a number.\n");
                }
                nameField.setText("");
                quantityField.setText("");
            }
        });
    }
}