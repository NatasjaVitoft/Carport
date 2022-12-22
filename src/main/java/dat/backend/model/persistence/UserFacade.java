package dat.backend.model.persistence;

import dat.backend.model.entities.User;
import dat.backend.model.exceptions.DatabaseException;

import javax.servlet.http.HttpServletRequest;

public class UserFacade
{
    public static User login(String username, String password, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.login(username, password, connectionPool);
    }

    public static User createUser(String username, String password, String email, String role, String address, String city, int postcode, String name, int phoneNumber, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.createUser(username, password, role, email, address, city, postcode, name, phoneNumber, connectionPool);
    }

    public static User getUserByUsername(String username, ConnectionPool connectionPool) throws DatabaseException {
        return UserMapper.getUserByUsername(username, connectionPool);
    }

    public static void readUser(HttpServletRequest request, ConnectionPool connectionPool, String username) {
        UserMapper.readUser(request, connectionPool, username);
    }
}
