package mock;

import model.Currency;
import model.ExchangeRate;
import view.persistence.ExchangeRateLoader;


public class ExchangeRateLoaderMock implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency) {
        if(fromCurrency.getCode().equals("EUR")) return new ExchangeRate(fromCurrency, toCurrency, 1.2);
        return new ExchangeRate(fromCurrency, toCurrency, 1.9);
    }
    
}
