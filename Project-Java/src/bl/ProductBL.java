package bl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dal.DBUtil;
import dal.ProductDAL;
import persistance.Product;

public class ProductBL {
    public static ProductDAL productDAL = new ProductDAL();

    public List<Product> getAll() {
        return productDAL.getAll();
    }

    public boolean addProduct(Product product) {
        return productDAL.insertProduct(product) > 0;
    }

    // public boolean updatePro(Product product) throws SQLException {
    // return productDAL.update(product) > 0;
    // }

    public static void showProduct() {
        ProductBL pbls = new ProductBL();
        List<Product> lst = pbls.getAll();
        System.out.println("\nItem List: ");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-40s |\n", "ID", "Tên Sản Phẩm", "Đơn Giá",
                "Số Lượng", "Status", "Mô Tả");
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------+");
        if (lst.isEmpty())
            System.out.println("Danh sach Trong!");
        for (Product p : lst) {
            System.out.printf("| %-10s | %-30s | %-15s | %-10s | %-10s | %-40s | \n", p.getPro_id(), p.getPro_name(),
                    p.getUnitPrice(), p.getAmount(), p.getPro_status(), p.getDescription());
        }
        System.out.println(
                "+------------------------------------------------------------------------------------------------------------------------------------+");

    }

    static List<Product> PR = new ArrayList<>();

    // public static void showAllProduct() {
    // ProductBL pbl = new ProductBL();
    // System.out.println("\nItems List:");
    // List<Product> lst = pbl.getAll();
    // for (Product product : lst) {
    // System.out.println(product);
    // }
    // }

    public static void insertProduct() {
        while (true) {

            ProductBL proBL = new ProductBL();

            if (proBL.addProduct(inputProduct())) {
                System.out.println("Insert product complete!");
            } else {
                System.err.println("Insert product failed!");
            }

            System.out.println("Continue Insert?(y/n)");
            String choice1 = yesno();
            if (choice1.equalsIgnoreCase("N")) {
                break;
            }

        }
    }

    public static String yesno() {
        String yn = sc.nextLine();
        if (yn.equalsIgnoreCase("N") || yn.equalsIgnoreCase("Y")) {
            return yn;
        }
        return yn;
    }

    static Scanner sc = new Scanner(System.in);

    public static Product inputProduct() {
        Product product = new Product();
        // Scanner sc = new Scanner(System.in);

        System.out.print("Pro_name: ");
        product.setPro_name(sc.nextLine());
        System.out.print("Unit Price: ");
        Double gia = Double.parseDouble(sc.nextLine());
        product.setUnitPrice(gia);
        System.out.print("Amount: ");
        int sl = Integer.parseInt(sc.nextLine());
        product.setAmount(sl);

        System.out.print("Description: ");
        product.setDescription(sc.nextLine());
        System.out.print("Pro_status: ");
        product.setPro_status(sc.nextLine());
        
        // sc.close();
        return product;
    }

    public static void inputInfoUpdate() {

        while (true) {

            Product product = new Product();
            ProductDAL PD = new ProductDAL();
            Scanner sc = new Scanner(System.in);
            System.out.print("Nhap Product_id : ");
            int id = Integer.parseInt(sc.nextLine());
            product.setPro_id(id);
            System.out.print("Update Pro_name: ");

            product.setPro_name(sc.nextLine());
            System.out.print("Update Unit_price: ");
            double price = Double.parseDouble(sc.nextLine());
            product.setUnitPrice(price);
            System.out.print("Update Amount: ");
            int amount = Integer.parseInt(sc.nextLine());
            product.setAmount(amount);
            System.out.print("Update Description: ");
            product.setDescription(sc.nextLine());
            System.out.print("Update Status: ");
            product.setPro_status(sc.nextLine());

            System.out.println("ban co muon update san pham(y/n)?");
            String choice = yesno();
            if (choice.equalsIgnoreCase("y")) {
                PR.add(product);
                try {
                    PD.update(product);
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                System.out.println("Xay Ra Loi. Khong the Update!");
            }
            System.out.println("Ban co muon tiep tuc update san pham(y/n)?");
            String x = yesno();
            if (x.equalsIgnoreCase("n")) {
                break;
            }
        }
    };

}