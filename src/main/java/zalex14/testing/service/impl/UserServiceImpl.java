package zalex14.testing.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zalex14.testing.dao.UserDao;
import zalex14.testing.dao.impl.UserDaoImpl;
import zalex14.testing.model.User;
import zalex14.testing.service.UserService;

/**
 *  Метод определения существования юзера
 */
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    /**
     * Метод определения наличия юзера
     *
     * @param user юзер
     * @return true/false наличия юзера в списке
     */
    @Override
    public boolean checkUserExist(User user) {
        return userDao.findAllUsers().contains(user);
    }
}