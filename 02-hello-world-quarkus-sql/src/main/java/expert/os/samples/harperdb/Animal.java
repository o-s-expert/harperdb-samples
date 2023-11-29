package expert.os.samples.harperdb;

import net.datafaker.Faker;

public record Animal(String scientificName, String name, String genus, String species) {


    public static Animal of(Faker faker){
        var animal = faker.animal();
        return new Animal(animal.scientificName(),
                animal.name(),
                animal.genus(), animal.species());
    }
}
