package controller;

import model.CurrencySet;
import model.Exchange;
import view.ui.console.ConsoleExchangeDialog;

public class ConsoleExchangeOperator {
    
    public void execute(CurrencySet currencySet) {
        Exchange exchange = ConsoleExchangeDialog.execute(currencySet);
        System.out.println("Your money : " + exchange.getMoney() + " " + exchange.getCurrency());
    }

}
