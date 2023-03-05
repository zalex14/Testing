package zalex14.testing.dao;

import zalex14.testing.model.User;

import java.util.List;

/**
 * Интерфейс методов для юзеров
 */
public interface UserDao {
    User getUserByName(String name);

    List<User> findAllUsers();
}