package com.fdmgroup.model;

import java.util.Set;

import javax.annotation.Resource;
import javax.annotation.Resources;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table
@NamedQueries({
	@NamedQuery(name = "E_Users.findUser", query ="Select i from E_Users i where i.Username = :name and i.Password = :password"),
	@NamedQuery(name = "E_Users.findUsername", query ="Select i from E_Users i where i.Username = :name"),
	@NamedQuery(name = "E_Users.findByUserid", query ="Select i from E_Users i where i.UserId = :userid"),
	@NamedQuery(name = "E_Users.findAllUser", query ="Select i from E_Users i "),
})
public class E_Users {
	
	@Id
	@SequenceGenerator(name="springuserseq",  sequenceName = "Spring_User_SEQ", initialValue=1, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "springuserseq" )
	private int UserId;	
	
	
	@Resource
	private String Username;
	
	@Resource
	private String UserEmail;
	
	@Resource
	private String Password;
	
	@Resource
	private String UserAddress;
	
	@Resource
	private String Type;
	
	@ManyToMany(targetEntity=E_Product.class)
	 @JoinTable(name="E_Cart")
	@Resource
	 private Set Products;

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public String getUsername() {
		return Username;
	}

	public void setUsername(String username) {
		Username = username;
	}

	public String getUserEmail() {
		return UserEmail;
	}

	public void setUserEmail(String userEmail) {
		UserEmail = userEmail;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getUserAddress() {
		return UserAddress;
	}

	public void setUserAddress(String userAddress) {
		UserAddress = userAddress;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public Set getProducts() {
		return Products;
	}

	public void setProducts(Set products) {
		Products = products;
	}

	public E_Users(int userId, String username, String userEmail, String password, String userAddress, String type,
			Set products) {
		super();
		UserId = userId;
		Username = username;
		UserEmail = userEmail;
		Password = password;
		UserAddress = userAddress;
		Type = type;
		Products = products;
	}

	public E_Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "E_Users [UserId=" + UserId + ", Username=" + Username + ", UserEmail=" + UserEmail + ", Password="
				+ Password + ", UserAddress=" + UserAddress + ", Type=" + Type + ", Products=" + Products + "]";
	}
		

}
