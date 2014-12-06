package view.persistence;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import model.Currency;
import model.Money;

public class MoneyLoader {
    
    public static Money load() {
        Money money = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("money.txt")));
            
            String line;
            
            while( (line = reader.readLine()) != null ) {
                String[] currencyFile = line.split("\\s+");
                Currency currency = new Currency(currencyFile[1], currencyFile[2], currencyFile[3]);
                money = new Money(Double.parseDouble(currencyFile[0]),currency);
                break;
            }
            
            reader.close();
        }
        catch (Exception exception) {
            System.out.println("Error file not found ...");
        }
        
        return money;
    }
    
}
