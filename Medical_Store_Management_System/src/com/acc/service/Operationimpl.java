package com.acc.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.acc.model.Medical;
import com.acc.util.DBconnection;

public class Operationimpl implements MedicineOperations {

    @Override
    public List<Medical> viewMedicines() {
        Connection con = null;
        java.sql.Statement stmt = null;
        ResultSet rs = null;
        List<Medical> medicine_s = new ArrayList<>();
        con = DBconnection.getDBconnection();

        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from medical");
            while (rs.next()) {
                medicine_s.add(new Medical(rs.getInt("medicine_id"), rs.getString("medicine_name"), rs.getString("medicine_manufacturer"), rs.getDouble("price"), rs.getInt("Quantity"), rs.getString("manufacture_date"), rs.getString("expiry_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return medicine_s;
    }

    @Override
    public void addMedicine(Medical medical) {
        String query = "INSERT INTO medical (medicine_name, medicine_manufacturer, price, Quantity, manufacture_date, expiry_date) VALUES (?, ?, ?, ?, ?, ?)";
        try {
        	Connection con = DBconnection.getDBconnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, medical.getMedicine_name());
            pstmt.setString(2, medical.getMedicine_manufacturer());
            pstmt.setDouble(3, medical.getPrice());
            pstmt.setInt(4, medical.getQuantity());
            pstmt.setString(5, medical.getManufacture_date());
            pstmt.setString(6, medical.getExpiry_date());
            pstmt.executeUpdate();
            System.out.println("Medicine added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateMedicine(Medical medical) {
        String query = "UPDATE medical SET medicine_name = ?, medicine_manufacturer = ?, price = ?, Quantity = ?, manufacture_date = ?, expiry_date = ? WHERE medicine_id = ?";
        try {
        	Connection con = DBconnection.getDBconnection();
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, medical.getMedicine_name());
            pstmt.setString(2, medical.getMedicine_manufacturer());
            pstmt.setDouble(3, medical.getPrice());
            pstmt.setInt(4, medical.getQuantity());
            pstmt.setString(5, medical.getManufacture_date());
            pstmt.setString(6, medical.getExpiry_date());
            pstmt.setInt(7, medical.getMedicine_id());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Medicine updated successfully.");
            } else {
                System.out.println("No medicine found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteMedicine(int id) {
        String query = "DELETE FROM medical WHERE medicine_id = ?";
        try (Connection con = DBconnection.getDBconnection();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Medicine deleted successfully.");
            } else {
                System.out.println("No medicine found with the given ID.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<Medical> searchMedicineByName(String name, MedicineOperations operations) {
		List<Medical> allMedicines = operations.viewMedicines();
        List<Medical> searchResults = new ArrayList<>();
        for (Medical medical : allMedicines) {
            if (medical.getMedicine_name().equalsIgnoreCase(name)) {
                searchResults.add(medical);
            }
        }
        return searchResults;
	}
}
