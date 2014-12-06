package CurrencySetLoader;

import model.Currency;
import model.CurrencySet;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import view.persistence.CurrencySetLoader;

public class TestCurrencySetLoader {
    
    private CurrencySet currencySet;
    private CurrencySetLoader currencySetLoader;
    
    @Before
    public void setUp() {
        currencySet = new CurrencySet();
        currencySet.add(new Currency("EUR", "EURO", "€"));
        currencySet.add(new Currency("USD", "DOLAR", "$"));
        
        currencySetLoader = new CurrencySetLoader();
        currencySetLoader.load(currencySet);
    }
    
    @Test
    public void testCurrency() {
        CurrencySet currencySet2 = this.currencySetLoader.getCurrencySet();
        
        for (String key : currencySet2) {
            assertEquals(currencySet2.get(key),this.currencySet.get(key));
        }
        
        assertTrue(this.currencySet.size() == this.currencySetLoader.getCurrencySet().size());
        
        CurrencySet currencySet3 = new CurrencySet();
        currencySet3.add(new Currency("DEL", "DELETE", "D"));
        this.currencySetLoader.load(currencySet3);
        
        assertFalse(this.currencySet.size() == this.currencySetLoader.getCurrencySet().size());
        
    }
}
