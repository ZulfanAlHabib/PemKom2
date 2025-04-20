package simpleapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class SimpleApp extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;
    private JButton loadButton;

    public SimpleApp() {
        // Set up the frame
        setTitle("Simple Serialization App");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create text area
        textArea = new JTextArea();
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        saveButton = new JButton("Save to File");
        loadButton = new JButton("Load from File");

        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveToFile();
            }
        });

        loadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadFromFile();
            }
        });
    }

    private void saveToFile() {
        String data = textArea.getText();
        if (data.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Text area is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(data);
                JOptionPane.showMessageDialog(this, "Data saved successfully!");
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saving data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void loadFromFile() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                String data = (String) ois.readObject();
                textArea.setText(data);
                JOptionPane.showMessageDialog(this, "Data loaded successfully!");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error loading data!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SimpleApp app = new SimpleApp();
            app.setVisible(true);
        });
    }
}