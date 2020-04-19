package blok.storage.impl;


import blok.model.User;
import blok.storage.UserStorage;

public class UserStorageImpl implements UserStorage {
    private User[] users = new User[15];
    private int size;
    // private String  isInitial;

    @Override
    public void addUser(User user) {
        if (size == users.length) {
            extend();
        }
        users[size++] = user;
    }

    private void extend() {
        User[] tmp = new User[users.length + 15];
        System.arraycopy(users, 0, tmp, 0, users.length);
        users = tmp;
    }


    public boolean searchPostsByKeyword(String maile, String pasword) {
        for (int i = 0; i < size; i++) {
            if (size == 0) {
                System.err.println("User not founds");
            } else if (users[i].getEmail().equals(maile) && users[i].getPassword().equals(pasword)) {
                System.out.println("ok");
                return false;
            } else {
                System.err.println("User not founds");
            }
        }
        return true;

    }
}