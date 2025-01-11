package com.acc.service;

import java.util.Scanner;
import java.util.List;
import java.util.Map;
import com.acc.model.Medical;

public class Billing {
    private Cart cart = new Cart();
    Scanner scanner = new Scanner(System.in);

    public void cartMenu( MedicineOperations operations) {
        while (true) {
            System.out.println("\nCart Menu:");
            System.out.println("1. Add to Cart");
            System.out.println("2. Delete from Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Back to Main Menu");

            System.out.print("Enter your choice: ");
            int cartChoice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (cartChoice) {
                case 1:
                    System.out.print("Enter medicine ID to add to cart: ");
                    int addMedicineId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int addQuantity = scanner.nextInt();
                    List<Medical> allMedicines = operations.viewMedicines();
                    boolean found = false;
                    for (Medical medical : allMedicines) {
                        if (medical.getMedicine_id() == addMedicineId) {
                            cart.addToCart(medical, addQuantity);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No medicine found with the given ID.");
                    }
                    break;
                case 2:
                    System.out.print("Enter medicine ID to delete from cart: ");
                    int deleteMedicineId = scanner.nextInt();
                    System.out.print("Enter quantity: ");
                    int deleteQuantity = scanner.nextInt();
                    cart.deleteFromCart(deleteMedicineId, deleteQuantity);
                    break;
                case 3:
                    cart.viewCart();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public void generateBill() {
        double total = 0;
        System.out.printf("%-20s %-10s %-10s %-10s%n", "Medicine", "Qty", "Price", "Total");
        System.out.println("---------------------------------------------");

        for (Map.Entry<Medical, Integer> entry : cart.getCartContents().entrySet()) {
            Medical medical = entry.getKey();
            int quantity = entry.getValue();
            double price = medical.getPrice();
            double subtotal = price * quantity;

            total += subtotal;

            System.out.printf("%-20s %-10d %-10.2f %-10.2f%n",
                    medical.getMedicine_name(), quantity, price, subtotal);
        }

        System.out.println("---------------------------------------------");
        System.out.printf("Total Bill: %.2f%n", total);
    }
}
