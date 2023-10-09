package ra.businessImp;

import ra.IShop;

import java.util.List;
import java.util.Scanner;

public class Product implements IShop {
    private String Id;
    private String Name;
    private int CalalogId;
    private float ImportPrice;
    private float ExportPrice;
    private boolean Status;

    public Product() {
    }

    public Product(String id, String name, int calalogId, float importPrice, float exportPrice, boolean status) {
        Id = id;
        Name = name;
        CalalogId = calalogId;
        ImportPrice = importPrice;
        ExportPrice = exportPrice;
        Status = status;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getCalalogId() {
        return CalalogId;
    }

    public void setCalalogId(int calalogId) {
        CalalogId = calalogId;
    }

    public float getImportPrice() {
        return ImportPrice;
    }

    public void setImportPrice(float importPrice) {
        ImportPrice = importPrice;
    }

    public float getExportPrice() {
        return ExportPrice;
    }

    public void setExportPrice(float exportPrice) {
        ExportPrice = exportPrice;
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

    }

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> productList, int indexProduct) {

    }

    @Override
    public void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> productList) {
        boolean isExit = true;
        System.out.println("Nhập ID sản phẩm");
        do {
            this.Id = scanner.nextLine();
            if (this.Id.length() == 4) {
                if (this.Id.startsWith("P")) {
                    boolean isExxitt = false;
                    for (Product product : productList) {
                        if (product.Id.equals(this.Id)) {
                            isExxitt = true;
                            break;
                        }
                    }
                    if (isExxitt) {
                        System.err.println("Mã sản phẩm đã tồn tại , vui lòng nhập lại");
                    } else {
                        isExit = false;
                    }
                } else {
                    System.err.println("Phải bắt đầu bằng chữ P , vui lòng nhập lại");
                }
            }else {
                System.err.println("Không thỏa mãn điều kiện 4 ký tự , vui lòng nhập lại");
            }
        }while (isExit);
        System.out.println("Nhập tên sản phẩm");
        do {
            this.Name = scanner.nextLine();
            boolean isExist = false;
            for (Product product : productList) {
                if (product.Name.equals(this.Name)){
                    isExist = true;
                    break;
                }
            }
            if(isExist){
                System.out.println("Tên sản phẩm đã tồn tại , vui lòng nhập lại");
            } else {
                isExit = false;
            }
        }while (isExit);
        System.out.println("Nhập Mã danh mục sản phẩm");
        do {
            this.CalalogId = Integer.parseInt(scanner.nextLine());
            boolean isCatalogId = false;
            for (Categories categories : categoriesList){
                if (categories.getId() == this.CalalogId) {
                    isCatalogId = true;
                    isExit = false;
                    break;
                }
            }
            if (!isCatalogId) {
                System.out.println("Mã danh mục không hợp lệ , vui lòng nhập lại");
            } else {
                isExit = false;
            }
        }while (isExit);

        System.out.println("Nhập giá nhập sản phẩm có giá trị lớn hơn 0");
        do {
            this.ImportPrice = Float.parseFloat(scanner.nextLine());
            if(this.ImportPrice <= 0){
                System.out.println("Giá nhập phải lớn hơn 0, vui lòngg nhập lại");
            }else {
               isExit = false;
            }
        }while (isExit);
        System.out.println("Nhập trạng thái sản phẩm");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.Status = Boolean.parseBoolean(status);
                break;
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        }while (isExit);
    }

    @Override
    public void displayData() {
        System.out.printf("Id : %s - Tên sản phẩm : %s - Mã danh mục : %d - Giá nhập sản phẩm : %f - Giá bán sản phẩm : %f - Trạng thái : %s\n",
                this.Id,this.Name,this.CalalogId,this.ImportPrice,this.ExportPrice,
                this.isStatus() ? "Hoạt động" : "Không hoạt động");
    }
    public void calExportPrice() {

        this.ExportPrice = this.ImportPrice * RATE;
    }
    public void updateData(Scanner scanner, List<Categories> categoriesList, List<Product> productList){
        boolean isExit = true;
        System.out.println("Nhập tên sản phẩm");
        this.Name = scanner.nextLine();
        System.out.println("Nhập Mã danh mục sản phẩm");
        do {
            this.CalalogId = Integer.parseInt(scanner.nextLine());
            boolean isCatalogId = false;
            for (Categories categories : categoriesList){
                if (categories.getId() == this.CalalogId) {
                    isCatalogId = true;
                    isExit = false;
                    break;
                }
            }
            if (!isCatalogId) {
                System.out.println("Mã danh mục không hợp lệ , vui lòng nhập lại");
            } else {
                isExit = false;
            }
        }while (isExit);

        System.out.println("Nhập giá nhập sản phẩm có giá trị lớn hơn 0");
        do {
            this.ImportPrice = Float.parseFloat(scanner.nextLine());
            if(this.ImportPrice <= 0){
                System.out.println("Giá nhập phải lớn hơn 0, vui lòngg nhập lại");
            }else {
                isExit = false;
            }
        }while (isExit);
        System.out.println("Nhập trạng thái sản phẩm");
        do {
            String status = scanner.nextLine();
            if (status.equals("true") || status.equals("false")) {
                this.Status = Boolean.parseBoolean(status);
                break;
            } else {
                System.err.println("Trạng thái danh mục chỉ nhận giá trị true hoặc false, vui lòng nhập lại");
            }
        }while (isExit);
    }
}
