package zalex14.testing.model;

import lombok.*;
import zalex14.testing.service.UserService;
import zalex14.testing.service.impl.UserServiceImpl;

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
    private static final String DEFAULT_LOGIN = "ivanov";
    private static final String DEFAULT_EMAIL = "ivan.ivanov@yandex.ru";
    private UserService userService = new UserServiceImpl();

    public User() {
        this.login = DEFAULT_LOGIN;
        this.email = DEFAULT_EMAIL;
    }

    public User(String login, String email) {
        if (userService.isValidUser(login, email)) {
            this.login = login;
            this.email = email;
        } else {
            throw new RuntimeException(" Некорректный логин или email " + " логин: " + login + " email: " + email);
        }
    }
}