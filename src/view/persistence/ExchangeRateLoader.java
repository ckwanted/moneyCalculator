package view.persistence;

import java.util.ArrayList;
import model.ExchangeRate;

public class ExchangeRateLoader extends ArrayList<ExchangeRate> {
    
    public ExchangeRateLoader() {
        super();
    }
    
    public void load(ExchangeRate exchangeRate) {
        this.add(exchangeRate);
    }
    
}
