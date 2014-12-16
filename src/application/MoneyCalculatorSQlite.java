package application;

import controller.ExchangeOperation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import model.CurrencySet;
import view.persistence.DB.SQliteConnection;
import view.ui.swing.ApplicationFrame;

public class MoneyCalculatorSQlite {
    
    public static void main(String[] args) throws SQLException {
        
        Connection connection = createConnection("money-calculator.db");
        SQliteConnection dbSQlite = new SQliteConnection(connection);
        
        CurrencySet currencySet = dbSQlite.loadCurrencySet();
        ApplicationFrame frame = new ApplicationFrame(currencySet);
        frame.register("Calcular", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                new ExchangeOperation(frame.getDialog()).execute();
            }
            
        });
        
    }

    private static Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new org.sqlite.JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }
    
}
