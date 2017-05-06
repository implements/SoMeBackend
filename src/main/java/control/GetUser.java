package control;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dto.User;
import org.bson.Document;

public class GetUser {

    public User execute(String userID) {

        MongoClient mongoClient = new MongoClient("localhost", 27017);

        MongoDatabase database = mongoClient.getDatabase("some");
        MongoCollection<Document> collection = database.getCollection("users");

        BasicDBObject user = new BasicDBObject("userid", userID);

        Document userFound = collection.find(user).first();

        User userObject = new User();
        userObject.setName(userFound.getString("name"));
        userObject.setUserID(userFound.getString("userid"));
        return userObject;

    }

    private User getTestUser() {
        User user = new User();
        user.setUserID("1");
        user.setName("Taylor Swift");
        return user;
    }
}
