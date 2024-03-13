package zad1;

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306?user=root&password=12345";
        Database db = new Database(url);
        System.out.println(db);
    }
}
