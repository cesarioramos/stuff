package mongodiscovery;

import static com.mongodb.client.model.Filters.eq;
import static org.assertj.core.api.Assertions.assertThat;

import org.bson.Document;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import tests.UnitTest;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.github.fakemongo.Fongo;


@Category(UnitTest.class)
public class MongoDBUnitTests {

	@Test
	public void insertIntoMongo() {
		//in memory mongo
		Fongo fongo = new Fongo("mongo server 1");
		MongoDatabase database = fongo.getDatabase("mydb");
				
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
}
