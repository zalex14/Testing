package zalex14.testing.dao.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import zalex14.testing.dao.UserDao;

import static zalex14.testing.constants.UserNameConstants.*;

/**
 * Test без применения Mockito
 * тестируем метод getUserByName из класса UserDaoImpl
 */
class UserDaoImplTest {
    /**
     * Тест нового юзера с существующим именем из списка
     * Проверка возврата true
     */
    private final UserDao userDao = new UserDaoImpl();

    @Test
    void shouldReturnExistUser() {
        Assertions.assertEquals(IVAN_NAME, userDao.getUserByName(IVAN_NAME).getName());
    }

    /**
     * Обратный тест юзера именем, отсутствующим в списке
     * Проверка возврата null
     */
    @Test
    void shouldReturnNotExistUser(){
        Assertions.assertNull(userDao.getUserByName(TOM_NAME));
    }
}