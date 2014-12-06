package view.persistence;

import model.CurrencySet;

public class CurrencySetLoader {
    
    private CurrencySet currencySet;

    public CurrencySetLoader() {
        this.currencySet = new CurrencySet();
    }
    
    public void load(CurrencySet currencySet) {
        for (String key : currencySet) {
            this.currencySet.put(key, currencySet.get(key));
        }
    }

    public CurrencySet getCurrencySet() {
        return currencySet;
    }
    
}
