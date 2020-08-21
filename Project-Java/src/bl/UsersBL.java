package bl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dal.DBUtil;
import dal.UsersDAL;
import gui.pro;
import persistance.Users;

public class UsersBL {

    public static UsersDAL udal = new UsersDAL();
    public static Users users = new Users();


    public static void logg(){
        try {
            System.out.print("Nhap User Name:");
            String usename = sc.nextLine();
            System.out.println("Nhap Password: ");
            String usepass = sc.nextLine();
            String check = udal.checklogin(usename, usepass);
            if (check.equals("Admin")) {
                pro.AdminMenu();
            } else if (check.equals("Customer")) {
                pro.CustomerMenu();
            }else{
                System.out.println("ko co role");
            }

        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    public List<Users> getAllus() {
        return udal.getAllUser();
    }

    static List<Users> lus = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void showUsers() {
        UsersBL ubl = new UsersBL();
        List<Users> lus = ubl.getAllus();
        System.out.println("\nUsers List: ");
        System.out.println(
                "+-----------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-25s | %-15s | %-10s | \n", "ID", "User Name", "User Password",
                "Role");
        System.out.println(
                "+-----------------------------------------------------------------------+");
        if (lus.isEmpty())
            System.out.println("Danh sach Trong!");
        for (Users us : lus) {
            System.out.printf("| %-10s | %-25s | %-15s | %-10s | \n", us.getUserId(), us.getUserName(),
                    us.getUserPass(), us.getRole());
        }
        System.out.println(
                "+-----------------------------------------------------------------------+");

    }

    public String checkUser() throws SQLException {
        UsersDAL udal = new UsersDAL();
        String Role = "";

        System.out.print("Nhap User Name: ");
        String name = sc.nextLine();

        System.out.print("Nhap PassWord: ");
        String pass = sc.nextLine();
        try {

            if (name.equals("") || pass.equals("")) {
                System.out.println("Please enter enough information!");
            } else {

                // Connection con = DBUtil.getConnection();
                Role = udal.checklogin(name, pass);
                if (Role == null) {
                    System.out.println("Account or password is incorrect, please re-enter");
                } else {
                    return Role;
                }
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        return Role;

    }

    // public static void Login_role(){
        
    //     String Authorization = udal.LoginAC();
    //     System.out.println("role: "+Authorization);
    //     if (Authorization.equals("Admin")) {
    //         pro.AdminMenu();
    //     } else if (Authorization.equals("Customer")) {
    //         pro.CustomerMenu();
    //     }
            
        
    // }
}

	