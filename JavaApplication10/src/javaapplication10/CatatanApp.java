package javaapplication10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class CatatanApp {
    private JFrame frame;
    private JTextArea textArea;
    private JTextField titleField; // Field untuk judul
    private JTextField contentField; // Field untuk isi
    private ArrayList<Note> notes; // Menggunakan kelas Note untuk menyimpan catatan

    public CatatanApp() {
        notes = new ArrayList<>();
        frame = new JFrame("Aplikasi Catatan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel untuk input judul dan isi catatan
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        inputPanel.add(new JLabel("Judul Catatan:"));
        titleField = new JTextField();
        inputPanel.add(titleField);

        inputPanel.add(new JLabel("Isi Catatan:"));
        contentField = new JTextField();
        inputPanel.add(contentField);

        frame.add(inputPanel, BorderLayout.NORTH);

        JButton addButton = new JButton("Add");
        JButton listButton = new JButton("List");
        JButton removeButton = new JButton("Remove");
        JButton exitButton = new JButton("Exit");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(listButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(exitButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String content = contentField.getText();
                if (!title.isEmpty() && !content.isEmpty()) {
                    notes.add(new Note(title, content)); // Menambahkan catatan baru
                    titleField.setText("");
                    contentField.setText("");
                    JOptionPane.showMessageDialog(frame, "Catatan ditambahkan!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Masukkan judul dan isi catatan terlebih dahulu!");
                }
            }
        });

        listButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textArea.setText("");
                for (Note note : notes) {
                    textArea.append("Judul: " + note.getTitle() + "\nIsi: " + note.getContent() + "\n\n");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                boolean removed = false;
                for (int i = 0; i < notes.size(); i++) {
                    if (notes.get(i).getTitle().equals(title)) {
                        notes.remove(i);
                        removed = true;
                        break;
                    }
                }
                if (removed) {
                    titleField.setText("");
                    contentField.setText("");
                    JOptionPane.showMessageDialog(frame, "Catatan dengan judul '" + title + "' dihapus!");
                } else {
                    JOptionPane.showMessageDialog(frame, "Catatan dengan judul '" + title + "' tidak ditemukan!");
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CatatanApp();
            }
        });
    }
}