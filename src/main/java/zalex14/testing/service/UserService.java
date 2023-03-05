package zalex14.testing.service;

import java.nio.channels.UnresolvedAddressException;

/**
 * Обрабатываем данные
 */
public interface UserService {
    boolean isValidUser(String login, String email);

    boolean isValidLogin(String login) throws IllegalArgumentException;

    boolean isValidEmail(String email) throws UnresolvedAddressException;
}