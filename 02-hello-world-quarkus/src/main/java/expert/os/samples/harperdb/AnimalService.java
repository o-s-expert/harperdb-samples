package expert.os.samples.harperdb;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import net.datafaker.Faker;

import java.util.List;

@ApplicationScoped
public class AnimalService {

    private final Faker faker;

    private final AnimalDAO dao;

    @Inject
    public AnimalService(Faker faker, AnimalDAO dao) {
        this.faker = faker;
        this.dao = dao;
    }


    public void insert(Animal animal){
      this.dao.insert(animal);
    }


    public void delete(String scientificName){
        this.dao.delete(scientificName);
    }

    public List<Animal> findAll(){
        return dao.findAll();
    }

    public void generateRandom(){
        for (int index = 0; index < 10; index++) {
            var animal = Animal.of(faker);
            dao.insert(animal);
        }
    }



}
