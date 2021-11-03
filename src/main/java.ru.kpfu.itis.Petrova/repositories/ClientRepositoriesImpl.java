package repositories;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import models.Client;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ClientRepositoriesImpl implements ClientRepositories{

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRepositoryImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Client find(Integer id) {
        try {
            String sql = "SELECT * FROM client WHERE id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Client(
                        resultSet.getInt("human_id"),
                        resultSet.getInt("country_id"),
                        resultSet.getInt("hotel_id")
                );
            }

        } catch (SQLException throwables) {
            LOGGER.warn("The client was not found", throwables);
        }
        return null;
    }

    @Override
    public List<Client> findAll() {
        return null;
    }

    @Override
    public void save(Client client) {
        String sql = "INSERT INTO client (human_id, country_id, hotel_id) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, client.getHumanId());
            preparedStatement.setInt(2, client.getCountryId());
            preparedStatement.setInt(3, client.getHotelId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            LOGGER.warn("Failed to save new user", throwable);
        }
    }

    @Override
    public void update(Client client) {

    }

    public Client findByHumanId(Integer id) {
        try {
            String sql = "SELECT * FROM client WHERE human_id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Client(
                        resultSet.getInt("human_id"),
                        resultSet.getInt("country_id"),
                        resultSet.getInt("hotel_id")
                );
            }

        } catch (SQLException throwables) {
            LOGGER.warn("The client was not found", throwables);
        }
        return null;
    }
}
