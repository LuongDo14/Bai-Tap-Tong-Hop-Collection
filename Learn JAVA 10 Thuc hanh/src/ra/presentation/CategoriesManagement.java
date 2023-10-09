package ra.presentation;

import com.sun.tools.javac.Main;
import ra.businessImp.Categories;
import ra.businessImp.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CategoriesManagement {
    public static void showMenu(Scanner scanner, List<Categories> categoriesList,List<Product> productList) {
        do {
            // Hiển thị menu quản lý danh mục sản phẩm
            System.out.println("********************CATEGORIES MENU********************");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Cập nhật thông tin danh mục (Cập nhật theo mã)");
            System.out.println("4. Xóa danh mục (Chỉ cho phép xóa danh mục chưa có sản phẩm)");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng : ");
            int choice = scanner.nextInt();
            boolean isExist = true;
            switch (choice) {
                case 1:
                    listCategories(categoriesList);
                    break;
                case 2:
                    inputCategories(categoriesList);
                    break;
                case 3:
                    updateCategories(categoriesList);
                    break;
                case 4:
                    deleteCategories(categoriesList,productList);
                    break;
                case 5:
                    isExist = false;
                    return;
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (true);
    }

    public static void listCategories(List<Categories> categoriesList) {
        System.out.println("Danh sách danh mục sản phẩm:");
        for (Categories category : categoriesList) {
            category.displayData();
        }
    }

    public static void inputCategories(List<Categories> categoriesList) {
        Scanner scanner = new Scanner(System.in);
        Categories newCategory = new Categories();
        newCategory.inputData(scanner, categoriesList);
        categoriesList.add(newCategory);
        System.out.println("Đã thêm mới danh mục sản phẩm.");
    }

    public static void updateCategories(List<Categories> categoriesList) {
        System.out.println("3. Cập nhật thông tin danh mục (Cập nhật theo mã)");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm cập nhật");
        int catId = Integer.parseInt(scanner.nextLine());
        for (Categories categories : categoriesList) {
            if (categories.getId() == catId) {
                categories.updateData(scanner, categoriesList);
                System.out.println("Cập nhật thành công");
                break;
            }
        } System.out.println("Không tìm thấy danh mục với mã , vui lòng nhập lại" + catId);
    }

    public static void deleteCategories(List<Categories> categoriesList,List<Product> productList) {
        System.out.println("4. Xóa danh mục (Chỉ cho phép xóa danh mục chưa có sản phẩm)");
        Scanner scanner = new Scanner(System.in);
        boolean isHave = true;
        System.out.println("Nhập mã sản phẩm cập nhật");
        int catId = Integer.parseInt(scanner.nextLine());
        for (Categories categories : categoriesList) {
            if (categories.getId() == catId) {
                if(!hasProductInCategories(categories, productList)) {
                    categoriesList.remove(categories);
                    System.out.println("Xóa thành công");
                    isHave = false;
                    break;
                }else {
                    System.out.println("Không thể xóa danh mục này vì có sản phẩm thuộc danh mục này.");
                    break;
                }
            }
        }
        if(isHave){
            System.out.println("Không tìm thấy danh mục với mã , vui lòng nhập lại" + catId);
        }

    }
    public static boolean hasProductInCategories(Categories categories, List<Product> productList){
        for (Product product: productList){
            if(product.getCalalogId() == categories.getId()){
                return true;
            }
        }
        return false;
    }
}
