public class Student {

    private String name;
    private int rollno;
    private String address ;
    private String  mobile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    /**
     * MongoClient config = MongodConfig.mongoClient();
     *     Student student = new Student();
     *     MongoDatabase database = config.getDatabase("student");
     *     MongoCollection collection = database.getCollection("student");
     *     System.out.println("Collection sampleCollection selected successfully");
     *     FindIterable iterDoc = collection.find();
     *     int i = 1;
     *     // Getting the iterator
     *     Iterator it = iterDoc.iterator();
     *     while (it.hasNext()) {
     *         System.out.println(it.next());
     *         i++;
     *     }
     */
}
