package view.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import model.Currency;
import model.CurrencySet;

public class CurrencySetLoader {
    
    public static CurrencySet load() {
        CurrencySet currencySet = new CurrencySet();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("currency.txt")));
            
            String line;
            
            while( (line = reader.readLine()) != null ) {
                String[] currencyFile = line.split("\\s+");
                currencySet.add(new Currency(currencyFile[0], currencyFile[1], currencyFile[2]));
            }
            
            reader.close();
        }
        catch (Exception exception) {
            System.out.println("Error file not found ...");
        }
        
        return currencySet;
    }
    
}
