🏥 Medical Store Management System 

A Java Console-Based Mini Project to manage medical store operations such as medicines, stock, billing, and customers. The system is simple, lightweight, and runs entirely in the terminal.

📌 Features

➕ Add new medicines to the store

✏️ Update existing medicine details

❌ Delete medicines from stock

🔍 Search medicines by name or category

📦 Manage stock quantity and expiry dates

🧾 Generate and display bills

👥 Maintain customer purchase history

🛠 Tech Stack

Programming Language: Java (Core Java)

Database: MySQL (via JDBC)

IDE (Optional): Eclipse / IntelliJ IDEA / NetBeans

Interface: Console (Text-Based Menus)

⚙️ Installation & Setup

Clone this repository

git clone https://github.com/your-username/medical-store-management.git
cd medical-store-management


Create MySQL Database

CREATE DATABASE medical_store;
USE medical_store;


Create Tables (Example)

CREATE TABLE medicines (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    company VARCHAR(100),
    price DOUBLE,
    quantity INT,
    expiry_date DATE
);


Update Database Credentials

Open DBConnection.java

Update username, password, and database name

Compile and Run

javac *.java
java Main

▶️ Usage (Sample Console Flow)
====== Medical Store Management ======
1. Add Medicine
2. Update Medicine
3. Delete Medicine
4. Search Medicine
5. View Stock
6. Generate Bill
7. Exit
Enter your choice: 

🔮 Future Enhancements

User authentication (Admin, Staff)

Export bills to PDF

Low stock & expiry alerts

Reports on monthly sales
