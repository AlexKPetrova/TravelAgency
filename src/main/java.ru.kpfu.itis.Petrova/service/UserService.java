package service;

import models.User;

import java.util.List;

public interface UserService {

    User find(Integer id);

    List<User> findAll();

    void save(User user);

    void update(User user);

    boolean isLogin(String login, String password);

    public String findPasswordByLogin(String login);

    Integer findIdByLogin(String login);
}
