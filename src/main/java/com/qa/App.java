package com.qa;



import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;


public class App{

    public static boolean answer = true;


    public static void main( String[] args )
    {


        DBManager db = new DBManager();
        db.acessDB(Constants.DB_URL, Constants.USER, Constants.PASS);
        Scanner method = new Scanner(System.in);

        while(answer) {

            System.out.println("would yu like to:");
            System.out.println("1 - create");
            System.out.println("2 - read");
            System.out.println("3 - update");
            System.out.println("4 - delete");
            System.out.println("5 - quite program");


            System.out.println("please enter a number: ");
            int choice = method.nextInt();

            switch(choice) {
                case 1:
                    db.create();
                    break;
                case 2:
                    db.read();
                    break;
                case 3:
                    db.update();
                    break;
                case 4:
                    db.delete();
                    break;
                case 5:
                    System.out.println("have a nice day");
                    answer = false;
                    break;
                default:
                    System.out.println("none valid input");

                }

            }

        }






    }





