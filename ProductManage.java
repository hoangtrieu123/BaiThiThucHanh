import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ProductManage {
    ArrayList<Product> arrayListProduct = new ArrayList<>();

    public Product creatProduct(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm: ");
        String productCode = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        String productName = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        int productPrice = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập số lượng sản phẩm: ");
        int productAmount = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mô tả sản phẩm: ");
        String productDescribe = scanner.nextLine();
        return new Product(productCode, productName, productPrice, productAmount, productDescribe);
    }

    public void addProduct(Scanner scanner) {
        Product product = creatProduct(scanner);
        arrayListProduct.add(product);
    }

    public void displayProduct() {
        for (Product a : arrayListProduct) {
            System.out.println(a);
        }
    }

    public void editProduct(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm cần sửa");
        String code = scanner.nextLine();
        for (Product a : arrayListProduct) {
            if (a.getProductCode().equals(code)) {
                System.out.println("Nhập mã sản phẩm muốn sửa: ");
                String productCode = scanner.nextLine();
                System.out.println("Nhập tên sản phẩm muốn sửa: ");
                String productName = scanner.nextLine();
                System.out.println("Nhập giá sản phẩm muốn sửa: ");
                int productPrice = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhập số lượng sản phẩm muốn sửa: ");
                int productAmount = Integer.parseInt(scanner.nextLine());
                System.out.println("Nhâp mô tả sản phẩm cần sửa: ");
                String productDescribe = scanner.nextLine();
                a.setProductCode(productCode);
                a.setProductName(productName);
                a.setProductPrice(productPrice);
                a.setProductAmount(productAmount);
                a.setProductDescribe(productDescribe);
            } else {
                System.out.println("Không tìm được sản phẩm ");
            }
        }
    }

    public void productRemove(Scanner scanner) {
        System.out.println("Nhập vào mã sản phẩm muốn xóa: ");
        String productCode = scanner.nextLine();
        for (Product a : arrayListProduct) {
            if (a.getProductCode().equals(productCode)) {
                System.out.println("Bạn có chắc muốn xóa sản phẩm ?");
                System.out.println("Y: Đồng ý xóa.");
                System.out.println("Nhập ký tự bất kỳ để thoát");
                String confirm = scanner.nextLine();
                if (confirm.equals("Y")) {
                    arrayListProduct.remove(a);
                    break;
                }

            } else {
                System.out.println("Không tìm được sản phẩm");
            }
        }
    }

    public ArrayList<Product> sortByIncreasePrice() {
        Collections.sort(arrayListProduct);
        return arrayListProduct;
    }

    public ArrayList<Product> sortByDecreasePrice() {
        ArrayList<Product> newProducts = sortByIncreasePrice();
        Collections.reverse(newProducts);
        return newProducts;
    }

    public void searchMaxPrice() {
        ArrayList<Product> productArrayList = sortByIncreasePrice();
        System.out.println(productArrayList.get((productArrayList.size() - 1)));
    }

    public void writeFileProduct(String File) {
        try {
            File file = new File("FileProduct.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            for (Product product : arrayListProduct) {
                bufferedWriter.write(product.getProductCode() + "," + product.getProductName() + "," + product.getProductPrice() + "," + product.getProductAmount() + "," + product.getProductDescribe() + "\n");
            }
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("");
        }
    }

    public ArrayList<Product> readFileProductList() {
        try {
            File file = new File("FileProduct.csv");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String value;
            while ((value = bufferedReader.readLine()) != null) {
                String[] strings = value.split(",");
                Product product = new Product(strings[0], strings[1], Integer.parseInt(strings[2]), Integer.parseInt(strings[3]), strings[4]);
                arrayListProduct.add(product);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("");
        }
        return arrayListProduct;
    }
}