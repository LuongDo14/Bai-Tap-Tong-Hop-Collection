package ra;

import ra.businessImp.Categories;
import ra.businessImp.Product;

import java.util.List;
import java.util.Scanner;

public interface IShop {
    float RATE = 1.3F;


    void inputData(Scanner scanner, List<Categories> categoriesList, int indexCategories);

    void inputData(Scanner scanner, List<Categories> categoriesList);

    void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> products, int indexProduct);


    void inputData(Scanner scanner, List<Categories> categoriesList, List<Product> products);

    void displayData();
}