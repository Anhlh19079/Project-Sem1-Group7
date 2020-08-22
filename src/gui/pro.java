package gui;

import java.io.IOException;
import java.security.cert.CRL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bl.ProductBL;
import bl.UsersBL;
import dal.ProductDAL;
import persistance.Product;

public class pro {

    static Scanner sc = new Scanner(System.in);

    public static void MainMenu() throws SQLException {
        while (true) {
            cls();
            System.out.println("+--------------------------------------+");
            System.out.println("|            PF10 - Group 7            |");
            System.out.println("+--------------------------------------+");
            System.out.println("|       1. Manage MenberShip           |");
            System.out.println("|    2. View And Search Clothings      |");
            System.out.println("|             0. Exit                  |");
            System.out.println("+--------------------------------------+");
            System.out.print("Enter Your Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    cls();
                    MenberShipMenu();
                    break;
                case "2":
                    ProductBL.showProduct();
                    System.out.println("Enter any key to continue : ");
                    String any = sc.nextLine();
                    break;
                case "0":
                    System.exit(0);
                    break;

                default:
                System.out.println("Nhap sai ! Nhap lai: ");
                String re = sc.nextLine();
                    
            }
            // break;
        }

    }

    public static void MenberShipMenu() throws SQLException {

        UsersBL ubl = new UsersBL();
        if (ubl.checkUser().equals("Admin")) {
            AdminMenu();
        } else if (ubl.checkUser().equals("Customer")) {
            CustomerMenu();
        } else {
            System.out.println("Error!");
        }

    }

    public static void CustomerMenu() {
        while (true) {

            cls();
            System.out.println("Login Successful!");
            System.out.println("UI Cus!");
            System.out.println("+--------------------------------------+");
            System.out.println("|            PF10 - Group 7            |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1. Search Clotings.                  |");
            System.out.println("| 2. Buy Items.                        |");
            System.out.println("| 3. View History Order.               |");
            System.out.println("| 0. Exit                              |");
            System.out.println("+--------------------------------------+");
            System.out.print("Input Your Choice: ");

            String choice = sc.nextLine();
            switch (choice) {
                case "1":
                cls();
                ProductBL.showProduct();
                System.out.println("Enter any key to continue: ");
                String any = sc.nextLine();
                    break;

                case "2":

                    break;
                case "3":
                    break;

                case "0":
                    System.out.println("Exit!");

                    break;
                default:
                    System.out.print("Nhap sai ! nhap lai: ");
                    String re = sc.nextLine();

            }
        }

    }

    public static void AdminMenu() {
       boolean w=true;
        while (w) {
            cls();
            System.out.println("Login Successful!");
            System.out.println("UI Adm!");
            System.out.println("+--------------------------------------+");
            System.out.println("|            PF10 - Group 7            |");
            System.out.println("+--------------------------------------+");
            System.out.println("| 1. Manage Products.                  |");
            System.out.println("| 2. Manage Order.                     |");
            System.out.println("| 3. View Users.                       |");
            System.out.println("| 0. Exit.                             |");
            System.out.println("+--------------------------------------+");
            System.out.print("Input Your Choice: ");
            Scanner sc = new Scanner(System.in);
            String choice = sc.nextLine();
            // while (true) {

            switch (choice) {
                case "1":
                    cls();
                    menu_manageProduct();
                    break;

                case "2":

                    break;
                case "3":
                    cls();
                    UsersBL.showUsers();
                    System.out.println("Enter any key to continue: ");
                    String any = sc.nextLine();
                    break;
                case "0":
                    // System.out.println("Ket thuc chuong trinh!!!");
                    System.out.println("Exit!");
                    w=false;
                   

                default:
                    System.out.println("Nhap sai ! nhap lai: ");
                    String re = sc.nextLine();
                    // break;
            }
            // break;
            // }
            break;
        }
    }

    public static void menu_manageProduct() {
        boolean w=true;
        while (w) {
            cls();
            try {
                System.out.println("+-------------------------------------+");
                System.out.println("| 1. Insert Product                   |");
                System.out.println("| 2. Update product                   |");
                System.out.println("| 3. ShowAllProduct                   |");
                System.out.println("| 0. Exit                             |");
                System.out.println("+-------------------------------------+");

                String choice;
                System.out.print("Nhap lua chon: ");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextLine();
                switch (choice) {
                    case "1":
                        cls();
                        ProductBL.insertPro();
                        break;
                    case "2":
                        cls();
                        ProductBL.showProduct();
                        System.out.println("Updates!!!");
                        ProductBL.inputInfoUpdate();
                        break;
                    case "0":
                    System.out.println("Exit!!!");
                    w=false;
                        // System.exit(0);
                        break;
                    case "3":
                        // cls();

                        ProductBL.showProduct();
                        System.out.println("Enter any key to continue :");
                        String any = sc.nextLine();
                        break;
                    default:
                        System.out.println("ban da nhap sai lua chon. vui long nhap lai!");
                        String re = sc.nextLine();
                        // break;
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
            // break;
        }
    }

    public static void cls() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ignored) {
        }
    }
}