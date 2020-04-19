package blok.storage;

import blok.exception.InputMismatchException;
import blok.model.User;

public interface UserStorage {

    void addUser(User user);

    boolean searchPostsByKeyword(String maile, String pasword) throws InputMismatchException;
}
