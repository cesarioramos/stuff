package mongodiscovery;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import tests.IntegrationTest;
import tests.UnitTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;

import static com.mongodb.client.model.Filters.*;


@Category(IntegrationTest.class)
public class MongoDBIntegrationTests {

	MongoClient mongoClient =  null;
	
	@Before
	public void mongoClient() {
		String db = System.getenv("nosqldb");
		if(mongoClient == null)
			mongoClient = new MongoClient( db , 27017 );
	}
	
	@Test
	public void insertIntoMongo() {
		MongoDatabase database = mongoClient.getDatabase("mydb");
				
		MongoCollection<Document> collection = database.getCollection("test");
		
		Document doc = new Document("name", "Cesario")
        .append("profession", "joker");
		
		collection.insertOne(doc);
		Document myDoc = collection.find(eq("profession", "joker")).first();

		assertThat(myDoc.get("name")).isEqualTo("Cesario");
		assertThat(myDoc.get("profession")).isEqualTo("joker");

		//Compensating transaction to clean up the Db
		DeleteResult deleteResult = collection.deleteMany(eq("name", "Cesario"));
       }

	
	@Test
	public void findAllDocuments() {
		MongoDatabase database = mongoClient.getDatabase("mydb");
				
		MongoCollection<Document> collection = database.getCollection("anotherCollection");
		
		List<Document> documents = new ArrayList<Document>();
		for (int i = 0; i < 100; i++) {
		    documents.add(new Document("i", i));
		}
		
		collection.insertMany(documents);
		
		MongoCursor<Document> cursor = collection.find().iterator();
		try {
		    while (cursor.hasNext()) {
		        System.out.println(cursor.next().toJson());
		    }
		} finally {
		    cursor.close();
		}
		
		assertThat(documents.size()).isEqualTo(100);

		//Compensating transaction to clean up the Db
		collection.drop();
       }
}
