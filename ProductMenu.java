import java.util.Scanner;

public class ProductMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductManage productManage = new ProductManage();
        int choice;
        do {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Tìm sản phẩm có giá đắt nhất");
            System.out.println("7. Đọc từ file");
            System.out.println("8. Ghi từ file");
            System.out.println("9. Thoát");
            System.out.println("Chọn chức năng: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    productManage.displayProduct();
                    break;
                case 2:
                    productManage.addProduct(scanner);
                    break;
                case 3:
                    productManage.editProduct(scanner);
                    break;
                case 4:
                    productManage.productRemove(scanner);
                    break;
                case 5:
                    int choice1;
                    System.out.println("1. Sắp xếp tăng dần");
                    System.out.println("2. Sắp xếp giảm dần");
                    choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1:
                            productManage.sortByIncreasePrice();
                            break;
                        case 2:
                            productManage.sortByDecreasePrice();
                            break;
                    }
                    break;
                case 6:
                    productManage.searchMaxPrice();
                    break;
                case 7:
                    productManage.readFileProductList();
                    break;
                case 8:
                    productManage.writeFileProduct("FileProduct.csv");
            }
        } while (choice != 0);
    }
}
