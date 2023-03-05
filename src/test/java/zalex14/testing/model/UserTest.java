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
        String result = new User(CORRECT_LOGIN, CORRECT_EMAIL).toString();
        Assertions.assertTrue(result.contains(CORRECT_LOGIN));
        Assertions.assertTrue(result.contains(CORRECT_EMAIL));
    }

    /**
     * 2. Тестирование создания объекта User без передачи в него параметров
     */
    @Test
    @DisplayName("2. Тестирование создания объекта User без передачи в него параметров")
    public void shouldCreateUserWhenDataNotTransferred() {
        String result = new User().toString();
        Assertions.assertNotNull(result);
        Assertions.assertTrue(result.contains(DEFAULT_LOGIN));   // Инициализируемое значение
        Assertions.assertTrue(result.contains(DEFAULT_EMAIL));   // Инициализируемое значение
    }

    /**
     * 3. Тестирование установлен ли корректный Email адрес в поле email в классе User.
     * Некорректным будет считаться тот email, в котором нет знака @ или же знака точки
     */
    @Test
    @DisplayName("3. Тестирование установлен ли корректный Email адрес в поле email в классе User")
    public void shouldDifferentEmailAndLogin() {
        String result = new User(LOWER_CASE_LOGIN, LOWER_CASE_EMAIL).getEmail();
        Assertions.assertTrue(result.contains("@") && result.contains("."));

    }

    /**
     * 4. Тестирование равны ли login и email
     */
    @Test
    @DisplayName(" 4. Тестирование равны ли login и email")
    public void shouldUserExistWhenDataNotTransferred() {
        User user = new User(UPPER_CASE_LOGIN, UPPER_CASE_EMAIL);
        Assertions.assertNotEquals(user.getLogin(), user.getEmail());
    }
}