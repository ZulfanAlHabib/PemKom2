package multithreadingapp;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MultiThreadingApp extends JFrame {
    private JLabel label;
    private JButton startButton;
    private JButton stopButton;
    private volatile boolean isRunning;

    public MultiThreadingApp() {
        setTitle("Aplikasi Multi-Threading Sederhana");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        label = new JLabel("Tekan tombol untuk memulai proses.");
        add(label);

        startButton = new JButton("Mulai Proses");
        startButton.addActionListener(new StartButtonListener());
        add(startButton);

        stopButton = new JButton("Hentikan Proses");
        stopButton.addActionListener(new StopButtonListener());
        stopButton.setEnabled(false);
        add(stopButton);
    }

    private class StartButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            isRunning = true;
            startButton.setEnabled(false);
            stopButton.setEnabled(true);
            label.setText("Proses dimulai...");

            Thread thread = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    if (!isRunning) {
                        break;
                    }
                    try {
                        Thread.sleep(1000); // Simulasi proses yang memakan waktu
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                    }
                    final int progress = i + 1;
                    SwingUtilities.invokeLater(() -> label.setText("Proses berjalan... " + progress + "/10"));
                }
                isRunning = false;
                SwingUtilities.invokeLater(() -> {
                    label.setText("Proses selesai!");
                    startButton.setEnabled(true);
                    stopButton.setEnabled(false);
                });
            });
            thread.start();
        }
    }

    private class StopButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            isRunning = false;
            label.setText("Proses dihentikan.");
            startButton.setEnabled(true);
            stopButton.setEnabled(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MultiThreadingApp app = new MultiThreadingApp();
            app.setVisible(true);
        });
    }
}