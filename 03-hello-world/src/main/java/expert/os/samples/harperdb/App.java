
package expert.os.samples.harperdb;


import io.harperdb.core.Server;
import io.harperdb.core.ServerBuilder;
import io.harperdb.core.Template;
import net.datafaker.Faker;


public class App {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Server server = ServerBuilder.of("http://localhost:9925")
                .withCredentials("root", "password");
        server.createDatabase("beers");
        server.createTable("beer").id("id").database("beers");
        Template template = server.template("beers");
        Beer beer = Beer.of(faker);

        template.insert(beer);
        template.findById(Beer.class, beer.id()).ifPresent(System.out::println);
        template.delete(Beer.class, beer.id());
        template.findById(Beer.class, beer.id()).ifPresentOrElse(System.out::println, () -> System.out.println("Beer not found"));

    }

    private App() {
    }



}
