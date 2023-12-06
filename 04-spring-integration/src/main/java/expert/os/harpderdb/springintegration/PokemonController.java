package expert.os.harpderdb.springintegration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    @GetMapping("/employees")
    List<String> all() {
        return List.of("Pikachu", "Charmander", "Bulbasaur");
    }
}
