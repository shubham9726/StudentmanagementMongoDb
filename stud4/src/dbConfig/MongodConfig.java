package dbConfig;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongodConfig {

    public static MongoClient mongoClient() {

        /**
         * @purpose : Create connection to Mongodb database.
         */
        MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://localhost:27017"));
        System.out.println("Successful database connection established. \n");
        return mongoClient;
    }
}
