package org.jnosql.demo.se;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PersonDAO {


    private static final String INSERT = "INSERT INTO dev.person (name, age) VALUES (?, ?)";
    private static final String SELECT = "select * From dev.person";
    private static final String CREATE_TABLE = "CREATE TABLE Person (name VARCHAR(20), age INT)";

    public void insert(Person person) throws SQLException {
        try(Connection connection = createConnection()){
            var statement = connection.prepareStatement(INSERT);
            statement.setString(1, person.name());
            statement.setInt(2, person.age());
            statement.execute();
        }
    }
    public List<Person> findAll() throws SQLException {
        List<Person> people = new ArrayList<>();
        try(Connection connection = createConnection()) {
            var statement = connection.prepareStatement(SELECT);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                var id = resultSet.getString("id");
                var name = resultSet.getString("name");
                var age = resultSet.getInt("age");
                people.add(new Person(id, name, age));
            }
        }
        return people;
    }

    public void create() {
        try(Connection connection = createConnection();
            Statement statement = connection.createStatement()) {
            statement.execute(CREATE_TABLE);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    static Connection createConnection() throws SQLException {
        var properties = new Properties();
        properties.setProperty("Server","http://localhost:9925/");
        properties.setProperty("User","root");
        properties.setProperty("Password","password");
        return DriverManager.getConnection("jdbc:harperdb:", properties);
    }
}
