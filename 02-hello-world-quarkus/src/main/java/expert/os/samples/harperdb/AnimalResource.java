package expert.os.samples.harperdb;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/animals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AnimalResource {
 private final AnimalService service;

    public AnimalResource(AnimalService service) {
        this.service = service;
    }


    @GET
    public List<Animal> findAll(){
        return this.service.findAll();
    }


    @POST
    public Animal insert(Animal animal){
        this.service.insert(animal);
        return animal;
    }


    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") String id){
        this.service.delete(id);
    }

    @POST
    @Path("/generate")
    public void generateRandom(){
        this.service.generateRandom();
    }
}
