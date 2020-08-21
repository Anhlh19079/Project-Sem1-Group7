import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import bl.ProductBL;
import bl.UsersBL;
import dal.DBUtil;
import dal.ProductDAL;
import dal.UsersDAL;
import persistance.Product;
import gui.pro;

public class App {
    public static void main(String[] args) throws Exception {
        try (Connection connection = DBUtil.getConnection();) {
            System.out.println("Connected to MySql Server.\n");
            
            // while (true) {
                
            // UsersBL.logg();
            pro.MainMenu();
            // pro.AdminMenu();

        // }
        } catch (SQLException ex) {
            System.out.println("Connection Error!");
        }
 }

}
