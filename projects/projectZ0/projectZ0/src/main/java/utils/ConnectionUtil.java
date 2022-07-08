package utils;



import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
    private static ConnectionUtil cu =null;
    private static Properties props;

    private ConnectionUtil() {
        props = new Properties();
        //setting properties from connection.properties file
        InputStream dbProps = ConnectionUtil.class.getClassLoader().getResourceAsStream("connection.properties");
        try {
        	//loading db connection properties
            props.load(dbProps);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static synchronized ConnectionUtil getConnectionUtil() {
        if (cu == null) {
            cu = new ConnectionUtil();
        }

        return cu;
    }

    public Connection getConnection() {
    	//making db connection by passing username, pass and db url to jdbc connection
    	Connection conn = null;

        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }
}