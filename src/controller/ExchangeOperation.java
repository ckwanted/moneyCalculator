package controller;

import model.Currency;
import model.CurrencySet;
import model.Money;
import view.ui.ExchangeDialog;
import view.ui.swing.ShowMoney;

public class ExchangeOperation {
    
    private final ExchangeDialog dialog;

    public ExchangeOperation(ExchangeDialog dialog) {
        this.dialog = dialog;
    }
    
    public void execute(CurrencySet currencySet) {
        System.out.println(dialog.getExchange().getMoney());
        System.out.println(dialog.getExchange().getMoney().getCurrency());
        System.out.println(dialog.getExchange().getCurrency());
        new ShowMoney(new Money(50, new Currency("EUR", "EURO", "€")));
    }
    
}
