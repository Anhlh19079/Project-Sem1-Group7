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
            System.out.println("|       1. Manage MenberShip           |\n");
            System.out.println("|    2. View And Search Clothings      |\n");
            System.out.println("|             0. Exit                  |");
            System.out.println("+--------------------------------------+");
            System.out.print("Enter Your Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    cls();
                    UsersBL.logg();
                    break;
                case "2":
                    ProductBL.showProduct();

                    break;
                case "0":
                    System.out.println("Exit!");
                    break;

                default:
                    break;
            }
            break;
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
        cls();

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

                break;

            case "2":

                break;
            case "3":
                break;

            case "0":
                System.out.println("Exit!");

                break;
            default:
                System.out.println("Nhap sai ! nhap lai.");
                break;
        }

    }

    public static void AdminMenu() {
        while (true) {
            cls();
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
                    break;
                case "0":
                    System.out.println("Ket thuc chuong trinh!!!");
                    System.out.println("Exit!");
                    break;

                default:
                    System.out.println("Nhap sai ! nhap lai.");
                    break;
            }
            // break;
            // }
            break;
        }
    }

    public static void menu_manageProduct() {
        while (true) {
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
                        ProductBL.insertProduct();
                        break;
                    case "2":
                        cls();

                        ProductBL.inputInfoUpdate();
                        break;
                    case "0":
                        System.out.println("Ket thuc chuong trinh!!!");
                        break;
                    case "3":
                        // cls();

                        ProductBL.showProduct();
                        break;
                    default:
                        System.out.println("ban da nhap sai lua chon. vui long nhap lai!");
                        break;
                }

            } catch (Exception e) {
                System.out.println(e.toString());
            }
            break;
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