package fa.training.main;

import fa.training.entities.Customer;
import fa.training.services.CustomerService;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomerService customerService = new CustomerService();

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Nhập danh sách khách hàng");
            System.out.println("2. Lưu danh sách vào file");
            System.out.println("3. Hiển thị tất cả khách hàng");
            System.out.println("4. Tìm kiếm theo SĐT");
            System.out.println("5. Xóa khách hàng theo SĐT");
            System.out.println("0. Thoát");

            int choice = -1;
            while (true) {
                System.out.print("Chọn: ");
                String input = sc.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    if (choice >= 0 && choice <= 5) break;
                    else System.out.println("Vui lòng nhập số từ 0 đến 5.");
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập số hợp lệ!");
                }
            }

            switch (choice) {
                case 1: {
                    List<Customer> customers = customerService.createCustomer();
                    customerService.save(customers);
                    break;
                }
                case 2: {
                    List<Customer> list = customerService.findAll();
                    System.out.println(customerService.save(list));
                    break;
                }
                case 3: {
                    customerService.display(customerService.findAll());
                    break;
                }
                case 4: {
                    System.out.print("Nhập SĐT cần tìm: ");
                    String phone = sc.nextLine();
                    customerService.display(customerService.search(phone));
                    break;
                }
                case 5: {
                    System.out.print("Nhập SĐT cần xóa: ");
                    String delPhone = sc.nextLine();
                    if (customerService.remove(delPhone)) {
                        System.out.println("Đã xóa thành công.");
                    } else {
                        System.out.println("Không tìm thấy khách hàng.");
                    }
                    break;
                }
                case 0:
                    System.exit(0);
            }
        }
    }
}
