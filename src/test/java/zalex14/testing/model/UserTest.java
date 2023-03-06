package zalex14.testing.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static zalex14.testing.constants.UserTestConstants.*;

/**
 * JUnit тестирование
 * SpringBootTest
 */

class UserTest {

    /**
     * 1. Тестирование создания объекта User с передачей в него двух параметров
     */
    @Test
    @DisplayName("1. Тестирование создания объекта User с передачей в него двух параметров")
    public void shouldCreateUserWhenDataSet() {
        User user = new User(CORRECT_LOGIN, CORRECT_EMAIL);
        Assertions.assertEquals(CORRECT_LOGIN, user.getLogin());
        Assertions.assertEquals(CORRECT_EMAIL, user.getEmail());
    }

    /**
     * 2. Тестирование создания объекта User без передачи в него параметров
     */
    @Test
    @DisplayName("2. Тестирование создания объекта User без передачи в него параметров")
    public void shouldCreateUserWhenDataNotTransferred() {
        User user = new User();
        Assertions.assertEquals(DEFAULT_LOGIN, user.getLogin());    // Инициализируемое значение
        Assertions.assertEquals(DEFAULT_EMAIL, user.getEmail());    // Инициализируемое значение
    }

    /**
     * 3. Тестирование установлен ли корректный Email адрес в поле email в классе User.
     * Некорректным будет считаться тот email, в котором нет знака @ или же знака точки
     */
    @Test
    @DisplayName("3. Тестирование установлен ли корректный Email адрес через исключение")
    public void shouldThrowRuntimeExceptionWhenEmailIncorrect() {
        Assertions.assertThrows(RuntimeException.class, ()-> new User(CORRECT_LOGIN, ILLEGAL_CHARACTERS_EMAIL));
        Assertions.assertDoesNotThrow(()-> new User(CORRECT_LOGIN, WITH_IP_ADDRESS_EMAIL));
    }

    /**
     * 4. Тестирование равны ли login и email через исключение
     */
    @Test
    @DisplayName(" 4. Тестирование равны ли login и email через исключение")
    public void shouldUserDifferentEmailAndLogin() {
        Assertions.assertDoesNotThrow(()-> new User(DEFAULT_LOGIN, WITH_IP_ADDRESS_EMAIL));
        Assertions.assertThrows(RuntimeException.class, () -> new User(DEFAULT_EMAIL, DEFAULT_EMAIL));
    }
}