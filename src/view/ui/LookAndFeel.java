package view.ui;

import javax.swing.UIManager;

public class LookAndFeel {
    
    public static void loadLookAndFeel() {
        try {
            System.setProperty("Quaqua.tabLayoutPolicy","wrap");
            UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
        } 
        catch (Exception event) {
            System.out.println("Error in Look And Feel");
        }
    }
    
}
