package zalex14.testing.service;

import zalex14.testing.model.User;

/**
 * Интерфейс метода присутствия юзера в списке
 */
public interface UserService {
    boolean checkUserExist(User user);
}