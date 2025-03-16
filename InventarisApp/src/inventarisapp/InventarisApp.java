
package inventarisapp;

import javax.swing.*;

public class InventarisApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InventoryApp app = new InventoryApp();
            app.setVisible(true);
        });
    }
}
