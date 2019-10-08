package at.htl.cinema.boundery;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.inject.Inject;
import javax.json.JsonArray;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RegisterRestClient
public interface CinemaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/cinema")
    JsonArray getCinemas();

}