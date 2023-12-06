package expert.os.harpderdb.springintegration;

import expert.os.harperdb.Template;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    private final Template template;

    public PokemonService(Template template) {
        this.template = template;
    }


    public Optional<Pokemon> findById(String id) {
        return template.findById(Pokemon.class, id);
    }

    public void save(Pokemon pokemon) {
        template.upsert(pokemon);
    }
    public void delete(String id) {
        template.delete(Pokemon.class, id);
    }
}
