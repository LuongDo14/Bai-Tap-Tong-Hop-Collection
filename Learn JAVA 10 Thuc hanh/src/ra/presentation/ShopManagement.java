package ra.presentation;

import ra.businessImp.Categories;
import ra.businessImp.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    private static float importPrice;

    public static void main(String[] args) {
        List<Categories> categoriesList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        int index = 0;
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Hiển thị menu chính
            System.out.println("********************SHOP MENU********************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Chọn chức năng 1: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    CategoriesManagement.showMenu(scanner, categoriesList,productList);
                    break;
                case 2:
                    ProductManagement.showMenu(scanner, productList, categoriesList,index,importPrice);
                    break;
                case 3:
                    System.out.println("Chương trình kết thúc.");
                    System.exit(0);
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}

