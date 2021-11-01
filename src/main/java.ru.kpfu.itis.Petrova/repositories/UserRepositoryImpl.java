package repositories;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository{

    private final Connection connection = PostgresConnectionHelper.getConnection();
    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);

    @Override
    public User find(Integer id) {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM human";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                if (resultSet.getInt("id") == id){
                    return new User(
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("dateOfBirth"),
                            resultSet.getInt("countryOfResidence"),
                            resultSet.getInt("citizenship"),
                            resultSet.getString("login"),
                            resultSet.getInt("password")
                    );
                }
            }

        } catch (SQLException throwables) {
            LOGGER.warn("The user was not found", throwables);
        }

        return null;
    }

    @Override
    public List<User> findAll() {
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM human";
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> userList = new ArrayList<>();

            while(resultSet.next()){
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("dateOfBirth"),
                        resultSet.getInt("countryOfResidence"),
                        resultSet.getInt("citizenship"),
                        resultSet.getString("login"),
                        resultSet.getInt("password")
                );
                userList.add(user);
            }
            return userList;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query", throwables);
            return new ArrayList<>();
        }
    }

    @Override
    public void save(User user) {

        String sql = "INSERT INTO human (name, dateOfBirth, country_Of_Residence_id, citizenship_id, login, password) VALUES (?, ?, ?, ?, ?, ?)";

        try{
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getDateOfBirth());
            preparedStatement.setInt(3, user.getCountryOfResidence());
            preparedStatement.setInt(4, user.getCitizenship());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setInt(6, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            LOGGER.warn("Failed to save new user", throwable);
        }

    }

    @Override
    public void update(User user) {
        //executeUpdate()
    }

    @Override
    public boolean isLogin(String login, int password) {
        if(findByLogin(login) == password){
            return true;
        }
        return false;
    }

    public int findByLogin(String login){
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM human";
            ResultSet resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                if(resultSet.getString("login").equals(login)){
                    return resultSet.getInt("password");
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 1;
    }
}
