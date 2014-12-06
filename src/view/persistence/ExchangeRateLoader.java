package view.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import model.Currency;
import model.ExchangeRate;

public class ExchangeRateLoader {
    
    public static ExchangeRate load(Currency from, Currency to) {
        
        ExchangeRate exchangeRate = null;
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("exchangeRate.txt")));
            
            String line;
            
            while( (line = reader.readLine()) != null ) {
                String[] exchangeRateFile = line.split("\\s+");
                if(from.getCode().equals(exchangeRateFile[0]) &&
                        to.getCode().equals(exchangeRateFile[1])) {
                    exchangeRate = new ExchangeRate(from, to, Double.parseDouble(exchangeRateFile[2]));
                    break;
                }
            }
            
            reader.close();
        } catch (Exception exception) {
            System.out.println("Error file not found ...");
        }
        
        return exchangeRate;
    }
    
}
