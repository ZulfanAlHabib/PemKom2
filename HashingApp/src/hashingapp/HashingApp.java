package hashingapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.Files;
import java.security.spec.InvalidKeySpecException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.mindrot.jbcrypt.BCrypt;
import com.lambdaworks.crypto.SCrypt;

public class HashingApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new HashingApp().createGUI());
    }

    private JTextArea inputArea;
    private JComboBox<String> algorithmBox;
    private JTextArea outputArea;

    public void createGUI() {
        JFrame frame = new JFrame("Hashing App - PBKDF2, bcrypt, scrypt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 500);

        inputArea = new JTextArea(5, 40);
        outputArea = new JTextArea(5, 40);
        outputArea.setEditable(false);

        String[] algorithms = {"PBKDF2", "bcrypt", "scrypt"};
        algorithmBox = new JComboBox<>(algorithms);

        JButton hashButton = new JButton("Hash Text");
        JButton loadFileButton = new JButton("Load File");

        hashButton.addActionListener(e -> hashInput());
        loadFileButton.addActionListener(e -> loadFile());

        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(new JScrollPane(inputArea), BorderLayout.CENTER);

        JPanel controls = new JPanel();
        controls.add(algorithmBox);
        controls.add(hashButton);
        controls.add(loadFileButton);

        topPanel.add(controls, BorderLayout.SOUTH);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(new JLabel("Output Hash:"), BorderLayout.CENTER);
        panel.add(new JScrollPane(outputArea), BorderLayout.SOUTH);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    private void hashInput() {
        String text = inputArea.getText();
        String algorithm = (String) algorithmBox.getSelectedItem();

        try {
            String hash;
            switch (algorithm) {
                case "PBKDF2":
                    hash = hashPBKDF2(text);
                    break;
                case "bcrypt":
                    hash = hashBCrypt(text);
                    break;
                case "scrypt":
                    hash = hashSCrypt(text);
                    break;
                default:
                    hash = "Unsupported algorithm";
            };
            outputArea.setText(hash);
        } catch (Exception e) {
            outputArea.setText("Error: " + e.getMessage());
        }
    }

    private void loadFile() {
        JFileChooser fileChooser = new JFileChooser();
        int opt = fileChooser.showOpenDialog(null);
        if (opt == JFileChooser.APPROVE_OPTION) {
            try {
                File file = fileChooser.getSelectedFile();
                String content = new String(Files.readAllBytes(file.toPath()));
                inputArea.setText(content);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Gagal membaca file: " + e.getMessage());
            }
        }
    }

    private String hashPBKDF2(String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = "random_salt".getBytes(); // Ganti dengan salt aman
        PBEKeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 256);
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
        byte[] hash = skf.generateSecret(spec).getEncoded();
        return Base64.getEncoder().encodeToString(hash);
    }

    private String hashBCrypt(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    private String hashSCrypt(String password) throws Exception {
        byte[] salt = "random_salt".getBytes(); // Ganti dengan salt aman
        byte[] hash = SCrypt.scrypt(password.getBytes(), salt, 16384, 8, 1, 32);
        return Base64.getEncoder().encodeToString(hash);
    }
}
