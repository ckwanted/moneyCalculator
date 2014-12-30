package view.ui.swing;

import static java.awt.BorderLayout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.CurrencySet;
import view.ui.ExchangeDialog;
import view.ui.LookAndFeel;

public class ApplicationFrame extends JFrame {
    
    private final CurrencySet currencySet;
    private Map<String,ActionListener> listeners;
    private ExchangeDialog exchangeDialog;

    public ApplicationFrame(CurrencySet currencySet) {
        super("Money Calculator 2.1");
        LookAndFeel.loadLookAndFeel();
        this.loadIcon();
        this.currencySet = currencySet;
        this.listeners = new HashMap<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.createWidgets();
        this.pack();
        this.setVisible(true);
    }
    
    public void register(String command, ActionListener actionListener) {
        this.listeners.put(command, actionListener);
    }
    
    public ExchangeDialog getDialog() {
        return this.exchangeDialog;
    }

    private void createWidgets() {
        this.add(createCalculateButton(),SOUTH);
        this.add(createDialog());
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(createListener("Calculate"));
        return button;
    }

    private ActionListener createListener(final String text) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if(exchangeDialog.getExchange() != null)
                    listeners.get(text).actionPerformed(event);
            }
        };
    }

    private JPanel createDialog() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencySet);
        this.exchangeDialog = panel;
        return panel;
    }

    private void loadIcon() {
        try {
            setIconImage(ImageIO.read(new FileInputStream("money.png")));
        } catch (Exception exception) {
            System.out.println("Error ico not found ...");
        }
    }
    
}
