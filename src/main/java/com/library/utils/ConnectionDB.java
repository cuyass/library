import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
    private static final String URL = "jdbc: postgresql://localhost:5432/Library";
    private static final String USER = "postgres";
    private static final String PASS = "";

    private static Connection connection;
    public static Connection initConnection(){
        try{
            connection = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Connected successfully!");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static void closeConnection(){
        try{
            connection.close();
            System.out.println("Closed connection");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
} /* meter USER y PASS en .env, .gitignore */
