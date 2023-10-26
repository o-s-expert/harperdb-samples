package expert.os.samples.harperdb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.function.Supplier;
import java.util.logging.Logger;

@ApplicationScoped

public class ConnectionSupplier {

    private static final Logger LOGGER = Logger.getLogger(ConnectionSupplier.class.getName());

    @Produces
    @ApplicationScoped
    public Connection get() throws SQLException {
        LOGGER.info("Creating connection");
        var properties = new Properties();
        properties.setProperty("Server","http://localhost:9925/");
        properties.setProperty("User","root");
        properties.setProperty("Password","password");
        return DriverManager.getConnection("jdbc:harperdb:", properties);
    }

    public void dispose(@Disposes Connection connection) throws SQLException {
        LOGGER.info("Closing connection");
        connection.close();
    }
}
