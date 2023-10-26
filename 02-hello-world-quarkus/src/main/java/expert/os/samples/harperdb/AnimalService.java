package expert.os.samples.harperdb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.datafaker.Faker;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ApplicationScoped
public class AnimalService {

    private final Faker faker;

    private final Map<String, Animal> animals;

    @Inject
    public AnimalService(Faker faker) {
        this.faker = faker;
        this.animals = new HashMap<>();
    }


    public void insert(Animal animal){
        animals.put(animal.scientificName(), animal);
    }

    public void update(Animal animal){
        animals.put(animal.scientificName(), animal);
    }

    public void delete(String scientificName){
        animals.remove(scientificName);
    }

    public List<Animal> findAll(){
        return List.copyOf(animals.values());
    }

    public void generateRandom(){
        for (int index = 0; index < 1_000; index++) {
            var animal = Animal.of(faker);
            animals.put(animal.scientificName(), animal);
        }
    }



}
