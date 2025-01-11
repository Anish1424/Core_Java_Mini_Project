package com.acc.model;

public class Medical {
	private int medicine_id;
	private String medicine_name;
	private String medicine_manufacturer;
	private double price;
	private int Quantity;
	private String manufacture_date;
	private String expiry_date;
	
	public Medical(int medicine_id, String medicine_name, String medicine_manufacturer, double price,
			int Quantity, String manufacture_date, String expiry_date) {
		super();
		this.medicine_id = medicine_id;
		this.medicine_name = medicine_name;
		this.medicine_manufacturer = medicine_manufacturer;
		this.price = price;
		this.Quantity = Quantity;
		this.manufacture_date = manufacture_date;
		this.expiry_date = expiry_date;
	}

	
	
	public int getMedicine_id() {
		return medicine_id;
	}



	public void setMedicine_id(int medicine_id) {
		this.medicine_id = medicine_id;
	}



	public String getMedicine_name() {
		return medicine_name;
	}



	public void setMedicine_name(String medicine_name) {
		this.medicine_name = medicine_name;
	}



	public String getMedicine_manufacturer() {
		return medicine_manufacturer;
	}



	public void setMedicine_manufacturer(String medicine_manufacturer) {
		this.medicine_manufacturer = medicine_manufacturer;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getQuantity() {
		return Quantity;
	}



	public void setQuantity(int quantity) {
		Quantity = quantity;
	}



	public String getManufacture_date() {
		return manufacture_date;
	}



	public void setManufacture_date(String manufacture_date) {
		this.manufacture_date = manufacture_date;
	}



	public String getExpiry_date() {
		return expiry_date;
	}



	public void setExpiry_date(String expiry_date) {
		this.expiry_date = expiry_date;
	}



	@Override
	public String toString() {
		return "Medicine Id=" + medicine_id + ", Medicine Name=" + medicine_name + ", Medicine Manufacturer="
				+ medicine_manufacturer + ", MRP(₹)=" + price + ", Quantity=" + Quantity + ", Manufacture Date="
				+ manufacture_date + ", Expiry Date=" + expiry_date ;
	}

	
	
	
	
	
		
}
