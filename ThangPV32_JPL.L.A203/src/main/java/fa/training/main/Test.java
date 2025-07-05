package fa.training.main;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.services.CustomerService;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Main class for running the customer management program.
 */
public class Test {
    /**
     * Entry point for the program.
     *
     * @param args command line arguments (not used)
     */
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
            System.out.println("6. Nạp dữ liệu mẫu (fix cứng)");
            System.out.println("0. Thoát");

            int choice = -1;
            while (true) {
                System.out.print("Chọn: ");
                String input = sc.nextLine();
                try {
                    choice = Integer.parseInt(input);
                    if (choice >= 0 && choice <= 6) break;
                    else System.out.println("Vui lòng nhập số từ 0 đến 6.");
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
                    if (list.isEmpty()) {
                        System.out.println("Danh sách khách hàng trống. Không có gì để lưu!");
                    } else {
                        System.out.println(customerService.save(list));
                    }
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
                case 6: {
                    List<Customer> sample = getSampleCustomers();
                    customerService.save(sample);
                    System.out.println("Đã nạp dữ liệu mẫu thành công!");
                    break;
                }
                case 0:
                    System.exit(0);
            }
        }
    }

    /**
     * Returns a sample list of customers with pre-defined data.
     *
     * @return a list of sample Customer objects
     */
    public static List<Customer> getSampleCustomers() {
        List<Customer> list = new ArrayList<>();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            Customer c1 = new Customer(
                    "Nguyen Van A", "0912345678", "Ha Noi",
                    Arrays.asList(
                            new Order("1000000001", sdf.parse("01/07/2024")),
                            new Order("1000000002", sdf.parse("05/07/2024"))
                    )
            );
            Customer c2 = new Customer(
                    "Tran Thi B", "0987654321", "Hai Phong",
                    Arrays.asList(
                            new Order("1000000003", sdf.parse("10/07/2024"))
                    )
            );
            Customer c3 = new Customer(
                    "Le Van C", "0909090909", "Da Nang",
                    Arrays.asList(
                            new Order("1000000004", sdf.parse("20/07/2024")),
                            new Order("1000000005", sdf.parse("25/07/2024"))
                    )
            );
            list.add(c1);
            list.add(c2);
            list.add(c3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
