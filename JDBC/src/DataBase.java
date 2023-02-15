import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBase {
    private String url;
    private String user;
    private String password;



    private Connection conn;

    public DataBase(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    public Connection connect() {
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public int insertUser(String first_name) {
        String SQL =String.format("INSERT INTO public.\"user\" ( first_name) VALUES( '%s');", first_name);
        int updatedRows = 0;
        try {
            Statement stmt = conn.createStatement();
            updatedRows =  stmt.executeUpdate(SQL);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return updatedRows;
    }

    public int deleteAllUsers() {
        String SQL = "delete from public.\"user\"";
        int updatedRows = 0;
        try {
            Statement stmt = conn.createStatement();
            updatedRows =  stmt.executeUpdate(SQL);
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return updatedRows;
    }


    public List<String> getAllUsersName() {
        String SQL = "SELECT * FROM public.\"user\"";
        List<String> users = new ArrayList<String>();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while (rs != null) {
                rs.next();
                users.add(rs.getString("first_name"));
            }
        }
        catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return users;
    }

    public Connection getConn() {
        return conn;
    }

}
