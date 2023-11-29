package expert.os.samples.harperdb;

import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class AnimalDAO {

    private final Connection connection;

    public AnimalDAO(Connection connection) {
        this.connection = connection;
    }

    private static final String INSERT = "INSERT INTO dev.animal (scientificName, name, genus, species) VALUES (?, ?, ?, ?)";
    private static final String SELECT = "select * From dev.animal";

    private static final String FIND_ID = "select * From dev.animal where id = ?";

    private static final String DELETE = "delete From dev.animal where id = ?";

    public void insert(Animal person) {
        try {
            var statement = connection.prepareStatement(INSERT);
            statement.setString(1, person.scientificName());
            statement.setString(2, person.name());
            statement.setString(3, person.genus());
            statement.setString(4, person.species());
            statement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public Optional<Animal> findById(String id) {
        try {
            var statement = connection.prepareStatement(FIND_ID);
            statement.setString(1, id);
            var resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Animal animal = animal(resultSet);
                return Optional.of(animal);
            }
            return Optional.empty();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public void delete(String id) {
        try {
            var statement = connection.prepareStatement(DELETE);
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    public List<Animal> findAll() {
        try {
            List<Animal> animals = new ArrayList<>();
            var statement = connection.prepareStatement(SELECT);
            var resultSet = statement.executeQuery();
            while (resultSet.next()) {
                animals.add(animal(resultSet));
            }
            return animals;
        } catch (SQLException exception) {
            throw new RuntimeException(exception);
        }
    }

    private Animal animal(ResultSet resultSet) throws SQLException {
        var scientificName = resultSet.getString("scientificName");
        var name = resultSet.getString("name");
        var genus = resultSet.getString("genus");
        var species = resultSet.getString("species");
        return new Animal(scientificName, name, genus, species);
    }
}
