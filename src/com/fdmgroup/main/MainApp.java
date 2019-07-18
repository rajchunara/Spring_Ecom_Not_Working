package com.fdmgroup.main;

import java.util.List;

import com.fdmgroup.dao.ProductDAO;
import com.fdmgroup.dao.UsersDAO;
import com.fdmgroup.model.E_Product;
import com.fdmgroup.model.E_Users;

public class MainApp {
	
	public static void main(String args[]){
		
		E_Product p1 = new E_Product();
		p1.setProductName("Surface Laptop");
		p1.setProductPrice(2255.00);
		p1.setDetails("Some details");
		p1.setImagePath("ImagePath");
		
		E_Product p2 = new E_Product();
		p2.setProductName("Dell Laptop");
		p2.setProductPrice(1100.00);
		p2.setDetails("Some dell laptop details");
		p2.setImagePath("dellImagePath");
		
		E_Product p3 = new E_Product();
		p3.setProductName("Adidas Bag");
		p3.setProductPrice(100.00);
		p3.setDetails("Some bag details");
		p3.setImagePath("adidasImagePath");
		
		E_Users u1 = new E_Users();
		u1.setUsername("Raj");
		u1.setUserEmail("rajchunara545@gmail.com");
		u1.setPassword("1234");
		u1.setType("Admin");
		
		E_Users u2 = new E_Users();
		u2.setUsername("Ankur");
		u2.setUserEmail("Ankurpatel@gmail.com");
		u2.setPassword("4321");
		u2.setType("User");
		
		E_Users u3 = new E_Users();
		u3.setUsername("Shreya");
		u3.setUserEmail("Shreyapatel@gmail.com");
		u3.setPassword("7899");
		u3.setType("User");
		
		UsersDAO userdao = new UsersDAO();
		ProductDAO productdao = new ProductDAO();
		
		userdao.addUser(u1);
		userdao.addUser(u2);
		userdao.addUser(u3);
		
		productdao.addProduct(p1);
		productdao.addProduct(p2);
		productdao.addProduct(p3);
		
		System.out.println("6 Records added");
		
		List<E_Users> userList = userdao.findAllUsers();
	    
	    System.out.println("ALL Users --->"+userList);
	    
	    List<E_Product> productList = productdao.findAllUsers();
	    
	    System.out.println("ALL Products --->"+ productList);
	    
	   /* spy spyFound = dao.findByID(2);
	    System.out.println("FOUND --->"+spyFound);*/
	    
	    E_Users userFound = userdao.findByUsername("Raj");
	    System.out.println("userFound--->" + userFound);
	    
	    E_Product productFound = productdao.findByProductname("Surface Laptop");
	    System.out.println("productFound---->" + productFound);
		
		
	}

}
