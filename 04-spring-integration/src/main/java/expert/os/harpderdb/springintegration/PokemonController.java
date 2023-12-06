package expert.os.harpderdb.springintegration;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    @GetMapping("/pokemon")
    List<String> findById(String id) {

    }
}
