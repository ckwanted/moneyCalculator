package model;

import java.util.HashMap;
import java.util.Iterator;

public class CurrencySet extends HashMap<String,Currency> implements Iterable<String> {

    public CurrencySet() {
        super();
    }
    
    public Currency getCurrency(String code) {
        return this.get(code);
    }
    
    public void add(Currency currency) {
        this.put(currency.getCode(), currency);
    }

    @Override
    public Iterator<String> iterator() {
        return this.keySet().iterator();
    }
    
}
