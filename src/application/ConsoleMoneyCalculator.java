package application;

import controller.ConsoleExchangeOperator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.CurrencySet;
import view.persistence.DB.SQliteConnection;

public class ConsoleMoneyCalculator {
    
    public static void main(String[] args) throws SQLException {
        Connection connection = createConnection("money-calculator.db");
        SQliteConnection dbSQlite = new SQliteConnection(connection);
        CurrencySet currencySet = dbSQlite.loadCurrencySet();
        new ConsoleExchangeOperator().execute(currencySet);
        connection.close();
    }

    private static Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }
    
}
