import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBase db = new DataBase("jdbc:postgresql://localhost:5432/users_test", "postgres", "postgres");
        db.connect();
        db.deleteAllUsers();
//        db.insertUser( "Andre");

//        List<String> users = db.getAllUsersName();
//        for (String user: users) {
//            System.out.println(user);
//        }
    }
}