package dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import dbConfig.MongodConfig;
import entity.Student;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * @purpose : To perform database related operations.
 */

public class MongodbOperations {

    public MongodbOperations counters;
    MongoClient config = MongodConfig.mongoClient();
    MongoDatabase database = config.getDatabase("student");
    MongoCollection collection = database.getCollection("student");

    /**
     * @param student : Student
     * @purpose : insert student data into database.
     */

    public void insert(Student student) {
        Document document = new Document();
        document.put("name", student.getName());
        document.put("rollNo", student.getRollNo());
        document.put("address", student.getAddress());
        document.put("mobile", student.getMobile());
        collection.insertOne(document);
    }

    /**
     * @param rollNo : rollno
     * @purpose : it deletes details of student from database
     */
    public void delete(String rollNo) {
        collection.deleteMany(Filters.eq("rollNo", rollNo));
    }

    /**
     * @param student : student
     * @purpose : it update details of student in database
     */
    public void update(Student student) {
        collection.updateOne(Filters.eq("rollNo", student.getRollNo()), Updates.set("name", student.getName()));
        collection.updateOne(Filters.eq("rollNo", student.getRollNo()), Updates.set("address", student.getAddress()));
        collection.updateOne(Filters.eq("rollNo", student.getRollNo()), Updates.set("mobile", student.getMobile()));
    }

    /**
     * @return : list of student's data.
     * @purpose : it gets all data of students.
     */
    public List<Document> getAllStudents() {
        return (List<Document>) collection.find().into(new ArrayList<Document>());
    }

    /**
     * @param rollNo : rollno
     * @return ; list of student
     * @purpose : it get the details of student based on the rollno.
     */
    public List<Student> getByRollNo(String rollNo) {
        return (List<Student>) collection.find(Filters.eq("rollNo", rollNo)).into(new ArrayList());
    }
}
