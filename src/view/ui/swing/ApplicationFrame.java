package view.ui.swing;

import static java.awt.BorderLayout.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import model.CurrencySet;
import view.ui.ExchangeDialog;

public class ApplicationFrame extends JFrame {
    
    private final CurrencySet currencySet;
    private Map<String,ActionListener> listeners;
    private ExchangeDialog exchangeDialog;

    public ApplicationFrame(CurrencySet currencySet) {
        super("Money Calculator");
        this.currencySet = currencySet;
        this.listeners = new HashMap<>();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.createWidgets();
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
        JButton button = new JButton("Calcular");
        button.addActionListener(createListener("Calcular"));
        return button;
    }

    private ActionListener createListener(String text) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                listeners.get(text).actionPerformed(event);
            }
        };
    }

    private JPanel createDialog() {
        ExchangeDialogPanel panel = new ExchangeDialogPanel(currencySet);
        this.exchangeDialog = panel;
        return panel;
    }
    
}
