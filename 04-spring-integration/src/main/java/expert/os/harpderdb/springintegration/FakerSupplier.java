package expert.os.harpderdb.springintegration;


import net.datafaker.Faker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FakerSupplier {

    @Bean
    public Faker faker() {
        return new Faker();
    }
}
