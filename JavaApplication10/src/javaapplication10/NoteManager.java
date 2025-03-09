
package javaapplication10;

import java.util.ArrayList;
import java.util.List;

class NoteManager {

    private final List<Note> notes;

    public NoteManager() {
        notes = new ArrayList<>();
    }

    public void addNote(String title, String content) {
        notes.add(new Note(title, content));
    }

    public void displayNotes() {
        if (notes.isEmpty()) {
            System.out.println("Tidak ada catatan.");
        } else {
            for (int i = 0; i < notes.size(); i++) {
                System.out.println("Catatan " + (i + 1) + ":");
                System.out.println(notes.get(i));
                System.out.println("-------------------------");
            }
        }
    }

    public void removeNote(int index) {
        if (index >= 0 && index < notes.size()) {
            notes.remove(index);
            System.out.println("Catatan berhasil dihapus.");
        } else {
            System.out.println("Index tidak valid.");
        }
    }
}
