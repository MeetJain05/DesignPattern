class Database{
    private static Database instance;
    public String dbName = "MyDatabase";
    private Database() {
        // Private constructor to prevent instantiation
        System.out.println("\"Database connection established!\"");
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }
}

public class singleton {
    public static void main(String[] args) {
        Database db1 = Database.getInstance();
        Database db2 = Database.getInstance();

        System.out.println(db1 == db2);  // True (Both are the same instance)
        System.out.println(db1.dbName);  // Accessing the database name
        System.out.println(db2.dbName);  // Accessing the database name
    }
}
