package expert.os.harpderdb.springintegration;


import io.harperdb.core.Server;
import io.harperdb.core.ServerBuilder;
import io.harperdb.core.Template;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HarperDB {

    @Bean
    public Template template() {
        Server server = ServerBuilder.of("http://localhost:9925")
                .withCredentials("root", "password");
        server.createDatabase("pokemons");
        server.createTable("pokemon").id("id").database("pokemons");
        return server.template("pokemons");
    }
}
