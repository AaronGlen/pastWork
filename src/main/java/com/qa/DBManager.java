package com.qa;
import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;


public class DBManager extends Constants{
    static Statement stmt = null;
    static Connection conn = null;

    public static void acessDB (String DB_URL,String USER, String PASS) {

        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }



    public static void create() {
        Scanner create = new Scanner(System.in);
        System.out.print("enter table name: ");
        String tableName = create.nextLine();
        System.out.println("enter fields to be created: ");
        String fields = create.nextLine();
        System.out.println("enter the values of the fields: ");
        String values = create.nextLine();

        System.out.println("Inserting records into the table...");

        String sql = "INSERT INTO "+tableName+" ("+fields+") VALUES("+values+  " )";
        try {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("success fully inserted records");
    }

    public static void read() {
        Scanner read = new Scanner(System.in);

        System.out.println("enter table name: ");
        String tableName = read.nextLine();
        System.out.println("enter fields to be read: ");
        String fields = read.nextLine();

        System.out.println("creating statement");

        String sql2 = "SELECT " +fields + " FROM " +tableName;
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
                System.out.println("ID: " + id + ", name: " + name + ", age: " + age);
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

        Scanner update = new Scanner(System.in);

        System.out.println("enter table name: ");
        String tableName = update.nextLine();
        System.out.println("enter value to be changed: ");
        String value = update.nextLine();
        System.out.println("enter loctaion: ");
        String location = update.nextLine();

        String sql3 = "UPDATE "+ tableName + " SET "+value+ " WHERE "+location;

        try {
            stmt.executeUpdate(sql3);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("succesfully updated ");

    }

    public static void delete() {
        System.out.println("deleting statement");

        Scanner delete = new Scanner(System.in);

        System.out.println("enter table name: ");
        String tableName = delete.nextLine();
        System.out.println("enter location of value to be deleted: ");
        String location = delete.nextLine();

        String sql4 = "DELETE FROM "+tableName + " WHERE "+ location;
        try {
            stmt.executeUpdate(sql4);
        } catch (SQLException e) {

            e.printStackTrace();

        }
        System.out.println("successfully deleted");
    }

}




