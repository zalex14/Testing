package zalex14.testing.service.impl;

import org.springframework.stereotype.Service;
import zalex14.testing.service.UserService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Обрабатываем данные (реализация)
 */
@Service
public class UserServiceImpl implements UserService {
    /**
     * Паттерны
     */
    private static final String LOGIN_REGEX = "^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){1,18}[a-zA-Z0-9]$";
    private static final Pattern LOGIN_PATTERN = Pattern.compile(LOGIN_REGEX);
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.]+@[a-zA-Z0-9.]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    /**
     *  Валидатор user
     * @param login логин
     * @param email эл. почта
     * @return true/false
     */
    @Override
    public boolean isValidUser(String login, String email) {
        return isValidLogin(login) && isValidEmail(email) && !login.equals(email);
    }

    /**
     * Валидатор логина
     * @param login проверяемы логин
     * @return true/false
     */
    @Override
    public boolean isValidLogin(String login) {
        if (login == null || login.isBlank()) {
            return false;
        }
        Matcher matcher = LOGIN_PATTERN.matcher(login);
        return matcher.matches();
    }

    /**
     * Валидатор адреса эл. почты
     * @param email проверяемый адрнс эл. почты
     * @return true/false
     */
    @Override
    public boolean isValidEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@") || !email.contains(".")) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}