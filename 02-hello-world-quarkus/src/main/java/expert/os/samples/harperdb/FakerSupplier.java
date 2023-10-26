package expert.os.samples.harperdb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Produces;
import net.datafaker.Faker;

import java.util.function.Supplier;

@ApplicationScoped
public class FakerSupplier implements Supplier<Faker> {
    @Override
    @Produces
    @ApplicationScoped
    public Faker get() {
        return new Faker();
    }
}
