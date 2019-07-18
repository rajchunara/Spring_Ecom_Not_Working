package com.fdmgroup.model;

import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;


@Entity
@NamedQueries({
	@NamedQuery(name = "E_Product.findAllProducts", query ="Select i from E_Product i"),
	@NamedQuery(name = "E_Product.findProductByName", query = "Select i from E_Product i WHERE i.ProductName = :productName")
	//@NamedQuery(name = "E_Product.removeProduct", query ="Delete i from E_Product i WHERE i.productId = :productid")
})


public class E_Product {
	
	@Id
	@SequenceGenerator(name="springproductseq",sequenceName = "Spring_Product_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "springproductseq" )
	private int productId;
	
	@Resource
	private String ProductName;
	@Resource
	private double ProductPrice;
	@Resource
	private String ImagePath;
	@Resource
	private String details;
	
	
	@ManyToMany(targetEntity=E_Users.class)
	@Resource
	 private Set Users;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getProductPrice() {
		return ProductPrice;
	}

	public void setProductPrice(double productPrice) {
		ProductPrice = productPrice;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Set getUsers() {
		return Users;
	}

	public void setUsers(Set users) {
		Users = users;
	}

	public E_Product(int productId, String productName, double productPrice, String imagePath, String details,
			Set users) {
		super();
		this.productId = productId;
		ProductName = productName;
		ProductPrice = productPrice;
		ImagePath = imagePath;
		this.details = details;
		Users = users;
	}

	public E_Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "E_Product [productId=" + productId + ", ProductName=" + ProductName + ", ProductPrice=" + ProductPrice
				+ ", ImagePath=" + ImagePath + ", details=" + details + ", Users=" + Users + "]";
	}	
	
	

}
