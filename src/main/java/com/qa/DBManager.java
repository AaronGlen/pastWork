package com.qa;
import java.sql.*;

public class DBManager {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/records";
    static final String USER = "root";
    static final String PASS = "";
    static Connection conn = null;
    static Statement stmt = null;


    public static void main(String[] args) throws SQLException, ClassNotFoundException {


        accessDB();
        read();
        create();
        update();

        delete();
        read();


    }


    public static void accessDB () {

            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            try {
                conn = DriverManager.getConnection(DB_URL, USER, PASS);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        try {
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void create() {
        System.out.println("Inserting records into the table...");

        String sql = "INSERT INTO test4(name,age) " + "values('tom',12)";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("success fully inserted records");
    }

    public static void read() {

        System.out.println("creating statement");

        String sql2 = "SELECT id, name, age FROM test4";
        try {
            stmt.execute(sql2);
        } catch (SQLException e) {

            e.printStackTrace();
        }
        System.out.println("sucsessfully created statment");
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("ID: " + id + ", name: " + name + ", date: " + age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            rs.close();
        }catch(SQLException e){
            e.printStackTrace();

        }

    }


    public static void update() {
        System.out.println("updating statment");

        String sql3 = "UPDATE test4 " + "SET NAME = 'JIM' WHERE id in (6,10)";
        try {
            stmt.executeUpdate(sql3);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("succesfully updated ");

    }

    public static void delete() {
        System.out.println("deleting statement");

        String sql4 = "DELETE FROM test4 " + "WHERE id = 7";
        try {
            stmt.executeUpdate(sql4);
        } catch (SQLException e) {

            e.printStackTrace();

        }
        System.out.println("successfully deleted");
    }
}



