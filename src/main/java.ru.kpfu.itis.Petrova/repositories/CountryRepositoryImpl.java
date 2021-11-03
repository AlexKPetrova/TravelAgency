package repositories;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import models.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryRepositoryImpl implements CountryRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryRepositoryImpl.class);

    private final Connection connection = PostgresConnectionHelper.getConnection();

    @Override
    public Country find(Integer id) {
        try {
            String sql = "SELECT * FROM human WHERE id = " + id;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                return new Country(
                        resultSet.getInt("id"),
                        resultSet.getString("country_name")
                );
            }

        } catch (SQLException throwables) {
            LOGGER.warn("The country was not found", throwables);
        }
        return null;
    }

    @Override
    public List<Country> findAll() {
        try{
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM country";
            ResultSet resultSet = statement.executeQuery(sql);

            List<Country> countryList = new ArrayList<>();

            while(resultSet.next()){
                Country country = new Country(
                        resultSet.getInt("id"),
                        resultSet.getString("country_name")
                );
                countryList.add(country);
            }
            return countryList;
        } catch (SQLException throwables) {
            LOGGER.warn("Failed execute getAll query", throwables);
            return new ArrayList<>();
        }
    }

    @Override
    public void save(Country country) {

        String sql = "INSERT INTO country (country_name) VALUES (?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, country.getCountryName());
            preparedStatement.executeUpdate();
        } catch (SQLException throwable) {
            LOGGER.warn("Failed to save new user", throwable);
        }

    }

    @Override
    public void update(Country country) {
        // дописать при необходимости
    }

    public Integer findIdByName(String name){
        try {
            String sql = "SELECT country_name FROM country WHERE country_name = " + name;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                return resultSet.getInt("id");
            }

        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
