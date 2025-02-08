package uz.pdp.library.util;

import java.sql.*;
import java.sql.Connection;

public class DatabaseUtil {
    public static void createTable() {
        String sql = "create table if not exists contact(" +
                "id serial primary key," +
                "name varchar (25) not null," +
                "surname varchar (25) not null," +
                "phone varchar(12) not null unique" +
                ")";
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            int i = statement.executeUpdate(sql);
            System.out.println(i);
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection (){
        try {
          return DriverManager.getConnection("jdbc:postgresql://localhost:5432/db_lesson_jon", "db_user_jon", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
