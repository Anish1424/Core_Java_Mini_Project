package com.acc.client;

import java.util.List;
import java.util.Scanner;
import com.acc.model.Medical;
import com.acc.service.Operationimpl;
import com.acc.service.Billing;
import com.acc.service.MedicineOperations;

public class Client {

    private static Billing billing = new Billing();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicineOperations operations = new Operationimpl();

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. View Medicines");
            System.out.println("2. Add Medicine");
            System.out.println("3. Update Medicine");
            System.out.println("4. Delete Medicine");
            System.out.println("5. Search Medicine by Name");
            System.out.println("6. Cart Menu");
            System.out.println("7. Generate Bill");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    List<Medical> medicines = operations.viewMedicines();
                    for (Medical medical : medicines) {
                        System.out.println(medical);
                    }
                    break;
                case 2:
                    System.out.println("Enter medicine name:");
                    String name = scanner.nextLine();
                    System.out.println("Enter medicine manufacturer:");
                    String manufacturer = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Enter manufacture date (YYYY-MM-DD):");
                    String manufactureDate = scanner.nextLine();
                    System.out.println("Enter expiry date (YYYY-MM-DD):");
                    String expiryDate = scanner.nextLine();
                    Medical newMedicine = new Medical(0, name, manufacturer, price, quantity, manufactureDate, expiryDate);
                    operations.addMedicine(newMedicine);
                    break;
                case 3:
                    System.out.print("Enter medicine ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Enter new medicine name:");
                    String newName = scanner.nextLine();
                    System.out.println("Enter new medicine manufacturer:");
                    String newManufacturer = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = scanner.nextDouble();
                    System.out.print("Enter new quantity: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.println("Enter new manufacture date (YYYY-MM-DD):");
                    String newManufactureDate = scanner.nextLine();
                    System.out.println("Enter new expiry date (YYYY-MM-DD):");
                    String newExpiryDate = scanner.nextLine();
                    Medical updatedMedicine = new Medical(updateId, newName, newManufacturer, newPrice, newQuantity, newManufactureDate, newExpiryDate);
                    operations.updateMedicine(updatedMedicine);
                    break;
                case 4:
                    System.out.print("Enter medicine ID to delete: ");
                    int deleteId = scanner.nextInt();
                    operations.deleteMedicine(deleteId);
                    break;
                case 5:
                    System.out.println("Enter medicine name to search:");
                    String searchName = scanner.nextLine();
                    List<Medical> searchResults = operations.searchMedicineByName(searchName, operations);
                    if (!searchResults.isEmpty()) {
                        for (Medical medical : searchResults) {
                            System.out.println(medical);
                        }
                    } else {
                        System.out.println("No medicines found with the name: " + searchName);
                    }
                    break;
                case 6:
                    billing.cartMenu(operations);
                    break;
                case 7:
                    billing.generateBill();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}