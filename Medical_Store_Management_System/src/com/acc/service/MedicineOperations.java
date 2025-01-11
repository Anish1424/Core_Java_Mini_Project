package com.acc.service;

import java.util.List;

import com.acc.model.Medical;

public interface MedicineOperations {
	   public void addMedicine(Medical medical);
	   public void updateMedicine(Medical medical);
	   public void deleteMedicine(int id);
	   public List<Medical> viewMedicines();
	   public List<Medical> searchMedicineByName(String name, MedicineOperations operations);


}
