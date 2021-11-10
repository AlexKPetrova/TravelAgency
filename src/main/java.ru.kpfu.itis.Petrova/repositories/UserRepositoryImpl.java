package repositories;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserRepositoryImpl implements UserRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();


    @Override
    public User find(Integer id) {
        try {
            String sql = "SELECT * FROM human WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("dateOfBirth"),
                        resultSet.getInt("country_Of_Residence_id"),
                        resultSet.getInt("citizenship_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }

        } catch (SQLException throwables) {
            LOGGER.warn("The user was not found", throwables);
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM human";
            ResultSet resultSet = statement.executeQuery(sql);

            List<User> userList = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("dateOfBirth"),
                        resultSet.getInt("country_Of_Residence_id"),
                        resultSet.getInt("citizenship_id"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
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

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getDateOfBirth());
            preparedStatement.setInt(3, user.getCountryOfResidenceId());
            preparedStatement.setInt(4, user.getCitizenshipId());
            preparedStatement.setString(5, user.getLogin());
            preparedStatement.setString(6, user.getPassword());
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            LOGGER.warn("Failed to save new user", throwable);
        }

    }

    @Override
    public void update(User user) {
        if (find(user.getId()) != null) {
            String sql = "UPDATE human SET  name = ?, dateOfBirth = ?, country_Of_Residence_id = ?, citizenship_id = ? WHERE id = " + user.getId();
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, user.getName());
                preparedStatement.setString(2, user.getDateOfBirth());
                preparedStatement.setInt(3, user.getCountryOfResidenceId());
                preparedStatement.setInt(4, user.getCitizenshipId());
                preparedStatement.executeUpdate();
            } catch (SQLException throwable) {
                LOGGER.warn("Failed to save new user", throwable);
            }
        } else {
            save(user);
        }
    }

    @Override
    public boolean isLogin(String login, String password) {
        return findPasswordByLogin(login).equals(password);
    }

    public String findPasswordByLogin(String login) {
        try {

            String sql = "SELECT password FROM human WHERE login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getString("password");
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }

    public Integer findIdByLogin(String login){
        try {

            String sql = "SELECT id FROM human WHERE login = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");

                return resultSet.getInt("id");
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
