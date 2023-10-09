package ra.presentation;

import ra.businessImp.Categories;
import ra.businessImp.Product;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    public static void showMenu(Scanner scanner, List<Product> productList, List<Categories> categoriesList, int index,float importPrice) {
        while (true) {
            // Hiển thị menu quản lý sản phẩm
            System.out.println("********************PRODUCT MENU********************");
            System.out.println("1. Danh sách sản phẩm");
            System.out.println("2. Thêm mới sản phẩm (Khi thêm mới cho phép chọn danh mục)");
            System.out.println("3. Cập nhật thông tin sản phẩm (Cập nhật theo mã)");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm theo giá bán tăng dần");
            System.out.println("6. Sắp xếp sản phẩm theo giá nhập giảm dần");
            System.out.println("7. Tìm kiếm sản phẩm theo tên sản phẩm");
            System.out.println("8. Thoát");
            System.out.print("Chọn chức năng : ");
            int choice = scanner.nextInt();
            boolean isExist = true;
            switch (choice) {
                case 1:
                    listProduct(productList,importPrice);
                    break;
                case 2:
                    inputProduct(categoriesList,productList);
                    break;
                case 3:
                    updateProduct(categoriesList,productList);
                    break;
                case 4:
                    deleteProduct(productList);
                    break;
                case 5:
                    sortbyExportPrice_Comparator(productList);
                    break;
                case 6:
                    sortByImportPricer_Comparator(productList);
                    break;
                case 7:
                   searchProduct(productList);
                    break;
                case 8:
                    isExist = false;
                    return;
                default:
                    System.out.println("Chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
    public static void listProduct(List<Product> productList,float importPrice){
        System.out.println("1. Danh sách sản phẩm");
        for (Product product: productList){
            product.displayData();
        }
    }
    public static void inputProduct(List<Categories> categoriesList,List<Product> productList){
        System.out.println("2. Thêm mới sản phẩm (Khi thêm mới cho phép chọn danh mục)");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng cần tạo");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            Product newProduct = new Product();
            newProduct.inputData(scanner, categoriesList, productList);
            newProduct.calExportPrice();
            productList.add(newProduct);

            System.out.println("Đã thêm mới sản phẩm.");
        }
    }
    public static void updateProduct(List<Categories> categoriesList,List<Product> productList){
        boolean isExit = true;
        System.out.println("3. Cập nhật thông tin sản phẩm (Cập nhật theo mã)");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm cập nhật");
        String updateProductById = scanner.nextLine();
        for (Product product:productList){
            if(product.getId().equals(updateProductById)){
                product.updateData(scanner, categoriesList,productList);
                product.calExportPrice();
                System.out.println("Đã cập nhật thông tin sản phẩm.");
                isExit = false;
                break;
            }
        }
        if(isExit){
            System.out.println("Không tìm thấy sản phẩm với mã " + updateProductById);
        }
    }
    public static void deleteProduct(List<Product> productList) {
        boolean isExit = true;
        System.out.println("4. Xóa sản phẩm");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm");
        String updateProductById = scanner.nextLine();
        for (Product product : productList) {
            if (product.getId().equals(updateProductById)) {
                productList.remove(product);
                System.out.println("Đã xóa sản phẩm.");
                isExit = false;
            }
        }
        if (isExit) {
            System.out.println("Không tìm thấy sản phẩm với mã " + updateProductById);
        }
    }
    public static void sortbyExportPrice_Comparator(List<Product> productList) {
        System.out.println("5. Sắp xếp sản phẩm theo giá bán tăng dần");
        Comparator<Product> proName = new Comparator<>() {

            @Override
            public int compare(Product o1, Product o2) {
                return o1.getExportPrice() <= o2.getExportPrice() ? -1 : o1.getExportPrice() == o2.getExportPrice() ? 0 : 1;
            }
        };
        productList.sort(proName);
    }

    public static void sortByImportPricer_Comparator(List<Product> productList) {
        System.out.println("6. Sắp xếp sản phẩm theo giá nhập giảm dần");

        Comparator<Product> proImport = new Comparator<>() {
            @Override
            public int compare(Product o1, Product o2) {
                return o1.getImportPrice() >= o2.getImportPrice() ? -1 : o1.getImportPrice() == o2.getImportPrice() ? 0 : 1;
            }
        };
        productList.sort(proImport);
    }
    public static void searchProduct(List<Product> productList){
        System.out.println("7. Tìm kiếm sản phẩm theo tên sản phẩm");
        System.out.println("Nhập tên sản phẩm");
        Scanner scanner = new Scanner(System.in);
        String namePro= scanner.nextLine();
        for (Product product: productList){
            if(product.getName().equals(namePro)){
                product.displayData();
            }
        }
    }

}

