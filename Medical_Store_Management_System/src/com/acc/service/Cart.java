package com.acc.service;

import java.util.HashMap;
import java.util.Map;
import com.acc.model.Medical;

public class Cart {
    private HashMap<Medical, Integer> cart = new HashMap<>();

    public void addToCart(Medical medical, int quantity) {
        if (medical.getQuantity() >= quantity) {
            cart.put(medical, quantity);
            medical.setQuantity(medical.getQuantity() - quantity); // Update stock
            System.out.println(quantity + " units of " + medical.getMedicine_name() + " added to cart.");
        } else {
            System.out.println("Insufficient stock for " + medical.getMedicine_name());
        }
    }

    public void deleteFromCart(int medicineId, int quantity) {
        for (Map.Entry<Medical, Integer> entry : cart.entrySet()) {
            Medical medical = entry.getKey();
            if (medical.getMedicine_id() == medicineId) {
                int currentQuantity = entry.getValue();
                if (currentQuantity >= quantity) {
                    if (currentQuantity == quantity) {
                        cart.remove(medical);
                    } else {
                        cart.put(medical, currentQuantity - quantity);
                    }
                    medical.setQuantity(medical.getQuantity() + quantity); // Update stock
                    System.out.println(quantity + " units of " + medical.getMedicine_name() + " removed from cart.");
                } else {
                    System.out.println("Quantity to remove exceeds quantity in cart.");
                }
                return;
            }
        }
        System.out.println("Medicine not found in cart.");
    }

    public void viewCart() {
        System.out.println("\nCart Contents:");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (Map.Entry<Medical, Integer> entry : cart.entrySet()) {
                Medical medical = entry.getKey();
                int quantity = entry.getValue();
                System.out.println(medical + " - Quantity: " + quantity);
            }
        }
    }

    public HashMap<Medical, Integer> getCartContents() {
        return cart;
    }
}
