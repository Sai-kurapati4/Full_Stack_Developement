STEP BY STEP

1. Import this project into Eclipse as Dynamic Web Project.
2. Add MySQL connector jar to project build path.
3. Create database:

CREATE DATABASE inventorydb;

USE inventorydb;

CREATE TABLE products(
id INT PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(100),
price DOUBLE,
quantity INT
);

4. Run on Tomcat server.

Open:
http://localhost:8080/YourProjectName/ViewProductsServlet

Low stock (<5) will appear in red.