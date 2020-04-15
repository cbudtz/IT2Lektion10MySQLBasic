package data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBTester {
    public static void main(String[] args) {
        Connection conn = Connector.getConn();
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Type in lower salary:");
            String salary = scanner.next();
            Statement statement = conn.createStatement();
            System.out.println("Connection established");

            ResultSet show_tables = statement.executeQuery("SELECT * FROM instructor WHERE salary > " + salary);
            System.out.println("Got a resultset with number of colums:");
            System.out.println(show_tables.getMetaData().getColumnCount());
            while (show_tables.next()){
                System.out.println("Column 1: " + show_tables.getString(1));
                System.out.println("Column 2: " + show_tables.getString(2));
                System.out.println("Column 3: " + show_tables.getString(3));
                System.out.println("Column 4: " + show_tables.getString(4));


            }


        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
