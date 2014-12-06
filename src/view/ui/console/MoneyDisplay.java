package view.ui.console;

import model.Money;

public class MoneyDisplay {
    
    public static void display(Money money) {
        System.out.println("Your money : " + money.getAmount() + money.getCurrency().getSymbol() + "\n");
    }
    
}
