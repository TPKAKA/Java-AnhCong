package fa.training.services;

import fa.training.entities.Order;
import fa.training.utils.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Service class for handling order input operations.
 * Provides methods to input a single order and a list of orders from user input.
 */
public class OrderService {
    private final Scanner sc = new Scanner(System.in);

    /**
     * Prompts the user to enter an order number and order date.
     * The order number must be exactly 10 digits and the date must follow dd/MM/yyyy format.
     *
     * @return a new Order object with validated number and date.
     */
    public Order inputOrder() {
        String number;
        while (true) {
            System.out.print("Nhập số Order (10 số): ");
            number = sc.nextLine();
            if (Validator.isValidOrderNumber(number)) break;
            System.out.println("Order number phải đúng 10 số!");
        }
        Date date = null;
        while (date == null) {
            System.out.print("Nhập ngày Order (dd/MM/yyyy): ");
            String dateStr = sc.nextLine();
            try {
                date = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
            } catch (ParseException e) {
                System.out.println("Định dạng ngày sai!");
            }
        }
        return new Order(number, date);
    }

    /**
     * Continuously prompts the user to enter orders until they choose to stop.
     *
     * @return a list of Order objects entered by the user.
     */
    public List<Order> inputOrderList() {
        List<Order> orders = new ArrayList<>();
        while (true) {
            orders.add(inputOrder());
            System.out.print("Thêm order nữa? (y/n): ");
            String opt = sc.nextLine();
            if (opt.equalsIgnoreCase("n")) break;
        }
        return orders;
    }
}
