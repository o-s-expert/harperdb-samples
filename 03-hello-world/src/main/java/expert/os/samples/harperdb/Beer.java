package expert.os.samples.harperdb;

import net.datafaker.Faker;

public record Beer(String id, String name, String style, String brand) {

    static Beer of(Faker faker) {
        String id = faker.idNumber().valid();
        String name = faker.beer().name();
        String style = faker.beer().style();
        String brand = faker.beer().brand();
        return new Beer(id, name, style, brand);
    }
}
