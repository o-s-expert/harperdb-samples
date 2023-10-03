package org.jnosql.demo.se;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

public class PersonDAO {


    private static final String INSERT = "INSERT INTO Person (name, age) VALUES (?, ?)";
    private static final String SELECT = "Select * From Person";

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
                Map<String, String> result = new HashMap<>();
                result.put("name", resultSet.getString("name"));
                System.out.println(result);
            }
        }
        return people;
    }

    static Connection createConnection() throws SQLException {
        var properties = new Properties();
        properties.setProperty("Server","http://localhost:9925/");
        properties.setProperty("User","root");
        properties.setProperty("Password","password");
        return DriverManager.getConnection("jdbc:harperdb:", properties);
    }
}
