package view.persistence.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Currency;
import model.CurrencySet;

public class SQliteConnection {
    
    private final Connection connection;

    public SQliteConnection(Connection connection) {
        this.connection = connection;
    }
    
    public CurrencySet loadCurrencySet() throws SQLException {
        String query = "SELECT * FROM currency";
        return processCurrencySet(connection.createStatement().executeQuery(query));
    }
    
    private CurrencySet processCurrencySet(ResultSet resultSet) throws SQLException {
        CurrencySet currencySet = new CurrencySet();
        while(resultSet.next()) currencySet.add(processCurrency(resultSet));
        return currencySet;
    }

    private Currency processCurrency(ResultSet resultSet) throws SQLException {
        return new Currency(
                resultSet.getString("code"),
                resultSet.getString("name"),
                resultSet.getString("symbol")
        );
    }
}
