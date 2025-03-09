
package javaapplication10;

public class Note {
    private final String title;
    private final String content;

    public Note(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Judul: " + title + "\nIsi: " + content;
    }
}    