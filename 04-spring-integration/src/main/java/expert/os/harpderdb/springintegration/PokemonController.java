package expert.os.harpderdb.springintegration;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    private final PokemonService service;

    public PokemonController(PokemonService service) {
        this.service = service;
    }

    @GetMapping("/pokemons/{id}")
    Pokemon findById(@PathVariable String id) {
        return service.findById(id).orElseThrow(() -> new PokemonNotFoundException(id));
    }

    @PutMapping("/pokemons")
    Pokemon newEmployee(@RequestBody Pokemon pokemon) {
        service.save(pokemon);
        return pokemon;
    }
    @DeleteMapping("/pokemons/{id}")
    void deleteEmployee(@PathVariable String id) {
        service.delete(id);
    }
}
