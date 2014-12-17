package view.ui.swing;

import static java.awt.BorderLayout.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import model.CurrencySet;
import view.ui.ExchangeDialog;

public class ApplicationFrame extends JFrame {
    
    private final CurrencySet currencySet;
    private Map<String,ActionListener> listeners;
    private ExchangeDialog exchangeDialog;

    public ApplicationFrame(CurrencySet currencySet) {
        super("Money Calculator 1.0");
        loadLookAndFeel();
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
