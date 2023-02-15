import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DataBaseTest {
    //action_object_result
    //ex: given_corrCred_conNotClosed
    @Test
    public void given_correctCredentials_connectionNotClosed() throws SQLException {
        DataBase db = new DataBase("jdbc:postgresql://localhost:5432/users_test", "postgres", "postgres");
        assertEquals(db.connect().isClosed(), false);
    }

    @Test
    public void given_userFirstName_insertedSuccessfully() throws SQLException{
        DataBase db = new DataBase("jdbc:postgresql://localhost:5432/users_test", "postgres", "postgres");
        db.connect();
        assertNotEquals(db.insertUser("test"), 0);
    }

    @Test
    public void requested_users_returnAllUsers() throws SQLException {
        DataBase db = new DataBase("jdbc:postgresql://localhost:5432/users_test", "postgres", "postgres");
        db.connect();
        db.deleteAllUsers();
        db.insertUser("max");
        db.insertUser("williams");

        assertArrayEquals(db.getAllUsersName().toArray(), new String[]{"max", "williams"});
    }


}