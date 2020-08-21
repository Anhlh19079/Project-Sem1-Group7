package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import persistance.Users;

public class UsersDAL {

    // static List<Users> lus = new ArrayList<>();

    public static List<Users> getAllUser() {
        String sql = "select * from users";
        List<Users> lus = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                Statement stm = con.createStatement();
                ResultSet rs = stm.executeQuery(sql)) {
            while (rs.next()) {
                lus.add(getUsers(rs));
            }
        } catch (SQLException ex) {
            lus = null;
            System.out.println(ex.toString());
        }
        return lus;
    }

    public static Users getUsers(ResultSet rs) throws SQLException {
        Users user = new Users();
        user.setUserId(rs.getInt("User_ID"));
        user.setUserName(rs.getString("User_Name"));
        user.setUserPass(rs.getString("User_Pass"));
        user.setRole(rs.getString("User_Role"));
        return user;
    }

    public String checkloginmew(String name, String pass) throws SQLException {
        String vt = "anh";
        try {// int check=-1;
            Connection con = DBUtil.getConnection();
            Statement tsm;
            ResultSet rs;

            tsm = con.createStatement();
            rs = tsm.executeQuery(
                    "SELECT user_role FROM users where user_name = '" + name + "' and user_pass = '" + pass + "'");
            while (rs.next()) {
                if (name.equals("") || pass.equals("") || (!(name.equals(rs.getString("user_name"))))
                        || (!(pass.equals(rs.getString("user_pass"))))) {
                    vt = null;
                    System.out.println("Tai khoan hoac mat khau ko chinh xac !");
                } else if (name.equals(rs.getString("user_namee")) && pass.equals(rs.getString("user_pass"))) {
                    vt = rs.getString("user_role");
                } else {
                    System.out.println("???");
                }

            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.toString());
        }
        System.out.println(vt);
        return vt;

    }

    public String checklogin(String username, String userpass) throws SQLException {
        Statement stm = null;
        ResultSet rs = null;
        String sql = "select * from users where User_Name ='" + username + "'";
        String role = null;
        int id = -1;
        try (Connection con = DBUtil.getConnection();) {
            stm = con.createStatement();
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                if (username.equals(rs.getString("User_Name"))) {
                    id = rs.getInt("User_ID");
                } else {
                    System.out.println("Wrong Account!!!");
                    id = -1;
                    break;
                }
            }
            if (id == -1) {
                return null;
            } else {
                rs = stm.executeQuery("SELECT * FROM users where User_ID ='" + id + "' ");
                while (rs.next()) {
                    if (userpass.equals(rs.getString("User_Pass"))) {
                        rs = stm.executeQuery("SELECT * FROM users where User_ID = '" + id + "'");
                        while (rs.next()) {
                            role = rs.getString("User_Role");
                        }
                    }
                }
            }

        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
            System.out.println(e.toString());
        }
        return role;
    }

    static Scanner sc = new Scanner(System.in);

    public static String LoginAC() {
        String username;
        String userpass;
        int id = -1;
        String role = "";
        try {
            Connection con = DBUtil.getConnection();
            Statement stm = con.createStatement();
            System.out.print("Enter Your User Name: ");
            username = sc.nextLine();
            System.out.print("Enter Your Password: ");
            userpass = sc.nextLine();
            ResultSet rs = stm.executeQuery("select User_ID from  User_Name='" + username + "'");
            while (rs.next()) {
                if (username.equals(rs.getString("User_Name"))) {
                    id = rs.getInt("User_ID");
                }
            }
            if (id == -1) {

                System.out.println("loi!");
            } else {
                Statement sta = con.createStatement();
                ResultSet rss = sta.executeQuery("select User_Pass ,User_Role from User_ID ='" + id + "'");
                while (rss.next()) {
                    if (userpass.equals(rss.getString("User_Pass"))) {
                        Statement stat = con.createStatement();
                        ResultSet rsul = stat.executeQuery("SELECT User_Role FROM users where User_ID = '" + id + "'");

                        while (rsul.next()) {
                            role = rsul.getString("User_Role");
                        }
                    }
                }
            }
        } catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("role:->" + role);
        return role;
    }

}