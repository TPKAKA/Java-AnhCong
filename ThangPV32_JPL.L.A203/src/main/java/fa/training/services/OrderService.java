package fa.training.services;

import fa.training.entities.Order;
import fa.training.utils.Validator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderService {
    private final Scanner sc = new Scanner(System.in);

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
