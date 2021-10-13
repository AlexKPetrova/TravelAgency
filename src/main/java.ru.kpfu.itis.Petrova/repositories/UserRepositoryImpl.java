package repositories;

import models.User;

import java.util.List;

public class UserRepositoryImpl implements UserRepository{

    @Override
    public User find(Integer id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public boolean isLogin(String login, String password) {
        return false;
    }
}
