package view.persistence.Oracle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Currency;
import model.CurrencySet;
import view.persistence.CurrencySetLoader;

public class OracleCurrencySetLoader implements CurrencySetLoader {

    @Override
    public CurrencySet loadCurrency() {
        try {
            CurrencySet currencySet = new CurrencySet();
            OracleConnection oracleConnection = new OracleConnection();
            Statement statement = oracleConnection.connect();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM currency");
            
            while(resultSet.next()) {
                currencySet.add(processCurrency(resultSet));
            }
            
            return currencySet;
        } 
        catch (SQLException exception) {
            System.out.println("Error loading CurrencySet");
            return null;
        }
    }

    private Currency processCurrency(ResultSet resultSet) throws SQLException {
        return new Currency(
                resultSet.getString("1"),
                resultSet.getString("2"),
                resultSet.getString("3")
        );
    }
    
}
