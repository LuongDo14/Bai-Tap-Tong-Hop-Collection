package ra.businessImp;

import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Categories implements IShop {
    private static int currentId = 0;
    private int Id;
    private String Name;
    private String Descriptions;
    private boolean Status;

    public Categories() {
    }

    public Categories(int id, String name, String descriptions, boolean status) {
        Id = id;
        Name = name;
        Descriptions = descriptions;
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }

    public boolean isStatus() {
        return Status;
    }

    public void setStatus(boolean status) {
        Status = status;
    }


    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList, int indexCategories) {

    }

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList) {
        boolean isExits = true;
        this.Id = currentId++;
        System.out.println("Nhập tên");
        this.Name = scanner.nextLine();
        System.out.println("Nhập mô tả");
        this.Descriptions = scanner.nextLine();
        System.out.println("Nhập Trạng thái ( true or false )");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.Status = Boolean.parseBoolean(status);
                break;
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        }while (isExits);
    }

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> products, int indexProduct) {

    }

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> products) {

    }


    @Override
    public void displayData() {
        System.out.printf("Id : %d - Tên : %s - Mô tả : %s - Trạng thái : %s\n" ,this.Id,this.Name,this.Descriptions,
                this.isStatus() ? "Hoạt động" : "Không hoạt động" );
    }
    public void updateData(Scanner scanner, List<Categories> categoriesList){
        boolean isExits = true;
        System.out.println("Nhập tên");
        this.Name = scanner.nextLine();
        System.out.println("Nhập mô tả");
        this.Descriptions = scanner.nextLine();
        System.out.println("Nhập Trạng thái ( true or false )");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.Status = Boolean.parseBoolean(status);
                break;
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        }while (isExits);
    }
}
