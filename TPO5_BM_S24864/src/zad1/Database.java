package zad1;

import java.sql.*;
import java.sql.DriverManager;

public class Database {
    private static Connection connection;

    public Database(String connectionString) {
        try {
            connection = DriverManager.getConnection(connectionString);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        try {
            Statement tableCom = connection.createStatement();
            String command = "SHOW TABLES LIKE 'tab1';";
            ResultSet result = tableCom.executeQuery(command);

            if (!result.next()) {
                FillDB();
                Create();
            }

        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    private void FillDB() {
        Statement adding = null;

        try {
            adding = connection.createStatement();

            String addingCom = "INSERT INTO BOOKS(title, author, yearOfRelease, category, rating) VALUES ('Omniscient Reader Viewpoint','Dokkabi King',2017,'Fantasy','9.80');" ;
            String addingCom2 = "INSERT INTO BOOKS(title, author, yearOfRelease, category, rating) VALUES ('Solo Levelling','Kim Suho',2019,'Fantasy','9.90');" ;
            String addingCom3 = "INSERT INTO BOOKS(title, author, yearOfRelease, category, rating) VALUES ('Before the Coffee Gets Cold','Toshikazu Kawaguchi',2015,'Romance','9.3');" ;
            String addingCom4 = "INSERT INTO BOOKS(title, author, yearOfRelease, category, rating) VALUES ('Season Blossoms','HONGDUCK',2018,'Romance','8.2');" ;
            String addingCom5 = "INSERT INTO BOOKS(title, author, yearOfRelease, category, rating) VALUES ('Citadel','Kate Mosse',2011,'Sci-Fi','7.0');" ;
            String addingCom6 = "INSERT INTO BOOKS(title, author, yearOfRelease, category, rating) VALUES ('Mythic Item','Shure',2022,'Thriller','9.0');" ;


            adding.execute(addingCom);
            adding.execute(addingCom2);
            adding.execute(addingCom3);
            adding.execute(addingCom4);
            adding.execute(addingCom5);
            adding.execute(addingCom6);




        } catch(SQLException e) {

        }
    }
    private void Create() {
        try {
            Statement create = connection.createStatement();

            String command =
                    "CREATE TABLE books (\n" +
                            "    id INT AUTO_INCREMENT PRIMARY KEY,\n" +
                            "    title VARCHAR(200),\n" +
                            "    author VARCHAR(200),\n" +
                            "    yearOfRelease INT,\n" +
                            "    category VARCHAR(200),\n" +
                            "    rating VARCHAR(200)\n" +
                            ");";

            create.execute(command);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
