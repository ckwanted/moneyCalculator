package application;

import controller.ConsoleExchangeOperator;
import model.CurrencySet;
import view.persistence.CurrencySetLoader;

public class ConsoleMoneyCalculator {
    
    public static void main(String[] args) {
        CurrencySet currencySet = CurrencySetLoader.load();
        new ConsoleExchangeOperator().execute(currencySet);
    }
    
}
