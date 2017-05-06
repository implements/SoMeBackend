package boundary;

import dto.User;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/user")
public class UsersResource {

    @Inject
    Users users;

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findUser(@PathParam("id") String userID) {
        return Response.ok(users.findUser(userID)).build();
    }

    // TODO: This returns a NullPointer Exception, but still saves the data. Investigate why lol.
    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveUser(User user) {
        users.saveUser(user);
        return Response.ok().build();
    }

    @GET
    @Path("/version")
    public Response getVersion() {
        return Response.ok("Blank Space").build();
    }
}
