package control;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dto.User;
import org.bson.Document;

public class SaveUser {

    public void execute(User user) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoDatabase database = mongoClient.getDatabase("some");
        MongoCollection<Document> collection = database.getCollection("users");

        Document document = new Document("name", user.getName()).append("userid", user.getUserID());
        collection.insertOne(document);
    }
}
