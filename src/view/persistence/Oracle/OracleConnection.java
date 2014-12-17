package view.persistence.Oracle;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConnection {
    
    private final String  server, user, password;

    public OracleConnection() {
        this.server = "jdbc:oracle:thin:@" + "localhost:101:orcl";
        this.user = "system";
        this.password = "orcl";
    }

    public Statement connect() throws SQLException {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        return DriverManager.getConnection(server,user,password).createStatement();
    }
    
}
