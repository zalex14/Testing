package zalex14.testing.model;

import lombok.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс User
 */
@Data
@Getter
@Setter
@EqualsAndHashCode
public class User {
    private String login;
    private String email;
    /**
     * Паттерны
     */
    private static final String LOGIN_REGEX = "^[a-zA-Z0-9]([._](?![._])|[a-zA-Z0-9]){1,18}[a-zA-Z0-9]$";
    private static final Pattern LOGIN_PATTERN = Pattern.compile(LOGIN_REGEX);
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.]+@[a-zA-Z0-9.]+$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final String DEFAULT_LOGIN = "ivanov";
    private static final String DEFAULT_EMAIL = "ivan.ivanov@yandex.ru";

    public User() {
        this.login = DEFAULT_LOGIN;
        this.email = DEFAULT_EMAIL;
    }

    public User(String login, String email) {
        if (isValidLogin(login) && isValidEmail(email) && !login.equals(email)) {
            this.login = login;
            this.email = email;
        } else {
            throw new RuntimeException(" Некорректный логин или email " + " логин: " + login + " email: " + email);
        }
    }

    /**
     * Валидатор логина
     *
     * @param login проверяемы логин
     * @return true/false
     */
    public boolean isValidLogin(String login) {
        if (login == null || login.isBlank()) {
            return false;
        }
        Matcher matcher = LOGIN_PATTERN.matcher(login);
        return matcher.matches();
    }

    /**
     * Валидатор адреса эл. почты
     *
     * @param email проверяемый адрнс эл. почты
     * @return true/false
     */
    public boolean isValidEmail(String email) {
        if (email == null || email.isBlank() || !email.contains("@") || !email.contains(".")) {
            return false;
        }
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}