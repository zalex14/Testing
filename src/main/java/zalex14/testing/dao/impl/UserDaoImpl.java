package zalex14.testing.dao.impl;

import org.springframework.stereotype.Repository;
import zalex14.testing.dao.UserDao;
import zalex14.testing.model.User;

import java.util.List;

/**
 * Лист юзеров в конструкторе и методы обработки
 */
@Repository
public class UserDaoImpl implements UserDao {
    private final List<User> usersList;

    public UserDaoImpl() {
        usersList = List.of(new User("Ivan"), new User("Petr"), new User("Semen"),
                new User("Anton"), new User("Maria"), new User("Olga"), new User("Inna"));
    }

    /**
     * Метод принимает имя и возвращает юзера по этому имени (null когда юзер не существует)
     *
     * @param name имя юзера
     * @return возвращаем user
     */
    @Override
    public User getUserByName(String name) {
        for (User user : usersList) {
            if (user.getName().equals(name)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод возвращающий списое юзеров
     *
     * @return лист юзеров
     */
    @Override
    public List<User> findAllUsers() {
        return usersList;
    }
}