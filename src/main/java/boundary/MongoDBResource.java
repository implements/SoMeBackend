package boundary;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@Path("/mongodb")
public class MongoDBResource {

    @GET
    @Path("/test")
    public Response testMongoDB() {
        try {
            MongoClient mongoClient = new MongoClient("localhost", 27017);

            MongoDatabase database = mongoClient.getDatabase("some");
            MongoCollection<Document> collection = database.getCollection("users");

            System.out.println("== REATING NOW DOCUMENT ==");
            Document testDoc = new Document("name", "Taylor Swift")
                    .append("userid", "1");
            System.out.println("== INSERTING DOCUMENT INTO DB ==");
            collection.insertOne(testDoc);

            Document fetchDoc = collection.find().first();
            return Response.ok(fetchDoc).build();

        } catch (Exception e){
            e.printStackTrace();
        }
        return Response.status(500).build();
    }
}
