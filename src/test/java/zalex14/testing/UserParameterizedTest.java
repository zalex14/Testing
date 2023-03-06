package zalex14.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import zalex14.testing.model.User;

import java.util.stream.Stream;

import static zalex14.testing.constants.UserTestConstants.*;

/**
 * Параметризованный JUnit тест
 */
public class UserParameterizedTest {
    /**
     * 1. Параметризованное тестирование создания объекта User с передачей в него двух параметров
     * Проверяем как на валидные, так и не валидные параметры
     */
    @ParameterizedTest
    @MethodSource("dataForTests")
    @DisplayName("1. Параметризованное тестирование создания объекта User с передачей в него двух параметров")
    public void shouldCreateUserWhenDataSet(String login, String email) {
        User user = new User(login, email);
        Assertions.assertEquals(login, user.getLogin());
        Assertions.assertEquals(email, user.getEmail());
    }

    public static Stream<Arguments> dataForTests() {
        return Stream.of(
                Arguments.of(DEFAULT_LOGIN, DEFAULT_EMAIL),
                Arguments.of(CORRECT_LOGIN, CORRECT_EMAIL),
                Arguments.of(LOWER_CASE_LOGIN, LOWER_CASE_EMAIL),
                Arguments.of(UPPER_CASE_LOGIN, UPPER_CASE_EMAIL),
                Arguments.of(NEW_USER_LOGIN, WITH_IP_ADDRESS_EMAIL),
                Arguments.of(null, null),
                Arguments.of(NULL_LOGIN, EMPTY_EMAIL),
                Arguments.of(SAME_AS_EMAIL_LOGIN, NULL_EMAIL),
                Arguments.of(ONLY_SPACES_LOGIN, ONLY_SPACES_EMAIL),
                Arguments.of(FIRST_BRACKET_LOGIN, SAME_AS_LOGIN_EMAIL),
                Arguments.of(ILLEGAL_CHARACTERS_LOGIN, WITHOUT_AT_EMAIL),
                Arguments.of(EMPTY_LOGIN, WITHOUT_POINT_EMAIL),
                Arguments.of(WITH_AT_LOGIN, ILLEGAL_CHARACTERS_EMAIL),
                Arguments.of(WITH_SPACE_LOGIN, ONLY_POINT_LOGIN_EMAIL),
                Arguments.of(WITH_CYRILLIC_LETTERS_LOGIN, WITHOUT_LOGIN_EMAIL),
                Arguments.of(WITH_SCRIPT_LOGIN, WITHOUT_DOMAIN_EMAIL),
                Arguments.of(WITH_CURLY_BRACE_LOGIN, WITHOUT_UPPER_DOMAIN_EMAIL)
        );
    }
}