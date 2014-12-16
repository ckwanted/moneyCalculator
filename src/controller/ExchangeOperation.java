package controller;

import view.ui.ExchangeDialog;

public class ExchangeOperation {
    
    private final ExchangeDialog dialog;

    public ExchangeOperation(ExchangeDialog dialog) {
        this.dialog = dialog;
    }
    
    public void execute() {
        System.out.println(dialog.getExchange().getMoney().getAmount());
        System.out.println(dialog.getExchange().getMoney().getCurrency().getCode());
        System.out.println(dialog.getExchange().getCurrency().getCode());
    }
    
}
