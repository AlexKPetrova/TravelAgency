package service;

import models.User;
import repositories.UserRepository;
import repositories.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {

    private static UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public User find(Integer id) {
        return userRepository.find(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    public boolean isLogin(String login, String password) {
        return userRepository.isLogin(login,password);
    }

    @Override
    public String findPasswordByLogin(String login) {
        return userRepository.findPasswordByLogin(login);
    }

    @Override
    public Integer findIdByLogin(String login) {
       return userRepository.findIdByLogin(login);
    }
}
