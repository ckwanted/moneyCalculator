package view.ui.swing;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import model.Money;

public class ShowMoney extends JFrame {

    public ShowMoney(Money money) {
        super("Result");
        loadLookAndFeel();
        add(new JLabel(money + " " + money.getCurrency()));
        setSize(new Dimension(200,100));
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void loadLookAndFeel() {
        try {
            System.setProperty("Quaqua.tabLayoutPolicy","wrap");
            UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeel());
        } 
        catch (Exception event) {
            System.out.println("Error in Look And Feel");
        }
    }
    
}
