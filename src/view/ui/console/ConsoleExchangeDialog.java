package view.ui.console;

import java.util.Scanner;
import model.Currency;
import model.CurrencySet;
import model.Exchange;
import model.ExchangeRate;
import model.Money;
import view.persistence.ExchangeRateLoader;
import view.persistence.MoneyLoader;
import view.process.Exchanger;

public class ConsoleExchangeDialog {
    
    public static Exchange execute(CurrencySet currencySet) {
        showTitle();
        Money yourMoney = MoneyLoader.load();
        currencySet.remove(yourMoney.getCurrency().getCode());
        MoneyDisplay.display(yourMoney);
        showCurrency(currencySet,yourMoney);
        Currency option = readOption();
        ExchangeRate exchangeRate = ExchangeRateLoader.load(yourMoney.getCurrency(), option);
        return new Exchange(Exchanger.exchangeRate(yourMoney, exchangeRate),option);
    }
    
    private static void showTitle() {
        System.out.println("##################################");
        System.out.println("######## MONEY CALCULATOR ########");
        System.out.println("##################################\n");
    }
    
    private static void showCurrency(CurrencySet currencySet, Money yourMoney) {
        System.out.println("1. Choose one currency :\n");
        for (String code : currencySet) {
            System.out.println(code);
        }
    }

    private static Currency readOption() {
        System.out.print("\n-> ");
        Scanner scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        scanner.close();
        
        if(option.equals("EUR")) return new Currency("EUR", "EURO", "€");
        else if(option.equals("USD")) return new Currency("USD", "DOLAR", "$");
        else return new Currency("BGP", "LIBRA", "£");
    }

}
