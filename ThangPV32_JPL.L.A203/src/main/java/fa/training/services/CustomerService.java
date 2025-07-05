package fa.training.services;

import fa.training.entities.Customer;
import fa.training.entities.Order;
import fa.training.utils.Constants;
import fa.training.utils.Validator;

import java.io.*;
import java.util.*;

/**
 * Service class that provides operations for managing customers and their orders,
 * including creating, saving, loading, displaying, searching, and removing customers.
 */
public class CustomerService {
    private final Scanner sc = new Scanner(System.in);
    private final OrderService orderService = new OrderService();

    /**
     * Prompts the user to enter customer information and their list of orders.
     * Allows entry of multiple customers until the user chooses to stop.
     *
     * @return a list of newly created customers.
     */
    public List<Customer> createCustomer() {
        List<Customer> list = new ArrayList<>();
        while (true) {
            System.out.print("Nhập tên KH: ");
            String name = sc.nextLine();

            String phone;
            while (true) {
                System.out.print("Nhập SĐT (10-11 số): ");
                phone = sc.nextLine();
                if (Validator.isValidPhone(phone)) break;
                System.out.println("SĐT không hợp lệ!");
            }

            System.out.print("Nhập địa chỉ: ");
            String address = sc.nextLine();

            System.out.println("--- Nhập danh sách Order của KH này ---");
            List<Order> orders = orderService.inputOrderList();

            Customer customer = new Customer(name, phone, address, orders);
            list.add(customer);

            System.out.print("Thêm KH mới? (y/n): ");
            String cont = sc.nextLine();
            if (cont.equalsIgnoreCase("n")) break;
        }
        return list;
    }

    /**
     * Saves the given list of customers to the data file.
     *
     * @param customers the list of customers to be saved.
     * @return a message indicating success or failure.
     */
    public String save(List<Customer> customers) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(Constants.DATA_FILE))) {
            oos.writeObject(customers);
            return "Đã lưu danh sách khách hàng!";
        } catch (IOException e) {
            return "Lỗi lưu file: " + e.getMessage();
        }
    }

    /**
     * Loads and returns all customers from the data file.
     * If the file does not exist or cannot be read, an empty list is returned.
     *
     * @return a list of all customers.
     */
    @SuppressWarnings("unchecked")
    public List<Customer> findAll() {
        List<Customer> list = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(Constants.DATA_FILE))) {
            list = (List<Customer>) ois.readObject();
        } catch (Exception e) {
            // Return empty list if file not found or error occurs
        }
        return list;
    }

    /**
     * Displays a list of customers in a formatted table.
     *
     * @param customers the list of customers to display.
     */
    public void display(List<Customer> customers) {
        System.out.printf("%-20s %-20s %-15s %s\n", "Tên", "Địa chỉ", "SĐT", "Danh sách Orders");
        for (Customer c : customers) {
            System.out.printf("%-20s %-20s %-15s %s\n",
                    c.getName(), c.getAddress(), c.getPhoneNumber(), c.getOrders());
        }
    }

    /**
     * Searches for customers by phone number.
     *
     * @param phone the phone number to search for.
     * @return a list of customers matching the given phone number.
     */
    public List<Customer> search(String phone) {
        List<Customer> result = new ArrayList<>();
        for (Customer c : findAll()) {
            if (c.getPhoneNumber().equals(phone)) {
                result.add(c);
            }
        }
        return result;
    }

    /**
     * Removes a customer with the specified phone number from the data file.
     *
     * @param phone the phone number of the customer to remove.
     * @return true if a customer was removed, false otherwise.
     */
    public boolean remove(String phone) {
        List<Customer> list = findAll();
        boolean removed = list.removeIf(c -> c.getPhoneNumber().equals(phone));
        if (removed) save(list);
        return removed;
    }
}
