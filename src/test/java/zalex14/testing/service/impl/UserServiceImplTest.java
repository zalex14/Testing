package zalex14.testing.service.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import zalex14.testing.dao.UserDao;
import zalex14.testing.model.User;

import static org.mockito.Mockito.when;
import static zalex14.testing.constants.UserNameConstants.*;

/**
 * Тест метода checkUserExist из класса UserService
 * с использованием Mockito
 */
@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    private final User existUser = new User(PETR_NAME);
    private final User absentUser = new User(VERA_NAME);

    @Mock
    private UserDao repositoryMosk;
    @InjectMocks
    private UserServiceImpl out;

    @Test
    void shouldReturnTrueForExistUser() {
        when(repositoryMosk.getUserByName(PETR_NAME)).thenReturn(existUser);
        Assertions.assertEquals(existUser, repositoryMosk.getUserByName(existUser.getName()));
        Assertions.assertTrue(out.checkUserExist(existUser));
    }

    @Test
    public void shouldReturnFalseForNotExistUser() {
        when(repositoryMosk.getUserByName(VERA_NAME)).thenReturn(null);
        Assertions.assertNull(repositoryMosk.getUserByName(absentUser.getName()));
        Assertions.assertFalse(out.checkUserExist(absentUser));
    }
}