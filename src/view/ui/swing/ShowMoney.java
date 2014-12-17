package view.ui.swing;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.UIManager;
import model.Money;

public class ShowMoney extends JFrame {

    public ShowMoney(Money money) {
        super("Result");
        loadLookAndFeel();
        add(new JTextField(money + " " + money.getCurrency()));
        setMinimumSize(new Dimension(200,100));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void loadLookAndFeel() {
        try {
            UIManager.setLookAndFeel(ch.randelshofer.quaqua.QuaquaManager.getLookAndFeelClassName());
        } 
        catch (Exception event) {
            System.out.println("Error in Look And Feel");
        }
    }
    
}
