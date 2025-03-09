
package javaapplication10;

import java.util.Scanner;

public class JavaApplication10 {


    public static void main(String[] args) {
        NoteManager noteManager = new NoteManager();
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("=== Aplikasi Catatan ===");
        do {
            System.out.println("\nPerintah: [add, list, remove, exit]");
            System.out.print("Masukkan perintah: ");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.print("Masukkan judul catatan: ");
                    String title = scanner.nextLine();
                    System.out.print("Masukkan isi catatan: ");
                    String content = scanner.nextLine();
                    noteManager.addNote(title, content);
                    break;
                case "list":
                    noteManager.displayNotes();
                    break;
                case "remove":
                    System.out.print("Masukkan nomor catatan yang ingin dihapus: ");
                    int index = scanner.nextInt() - 1; // Mengurangi 1 untuk indeks array
                    scanner.nextLine(); // membersihkan newline
                    noteManager.removeNote(index);
                    break;
                case "exit":
                    System.out.println("Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("Perintah tidak dikenali.");
            }
        } while (!command.equals("exit"));

        scanner.close();
    }
}
