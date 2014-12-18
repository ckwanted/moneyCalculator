package controller;

import model.ExchangeRate;
import view.persistence.SQlite.SQliteConnection;
import view.process.Exchanger;
import view.ui.ExchangeDialog;
import view.ui.swing.ShowMoney;

public class ExchangeOperation {
    
    private final ExchangeDialog dialog;

    public ExchangeOperation(ExchangeDialog dialog) {
        this.dialog = dialog;
    }
    
    public void execute(SQliteConnection dbSQlite) {
        ExchangeRate exchangeRate = dbSQlite.getExchangeRate(
                dialog.getExchange().getMoney().getCurrency(),
                dialog.getExchange().getCurrency()
        );
        
        new ShowMoney(Exchanger.exchangeRate(dialog.getExchange().getMoney(), exchangeRate));
    }
    
}
