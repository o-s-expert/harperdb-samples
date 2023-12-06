package expert.os.harpderdb.springintegration;

import net.datafaker.Faker;

public record Pokemon(String id, String name, String location) {

    public static Pokemon of(Faker faker) {
        String id = faker.idNumber().valid();
        var pokemon = faker.pokemon();
        String name = pokemon.name();
        String location = pokemon.location();
        return new Pokemon(id, name, location);
    }
}
