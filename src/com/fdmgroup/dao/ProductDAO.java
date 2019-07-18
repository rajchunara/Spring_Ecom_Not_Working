package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;

import com.fdmgroup.model.E_Product;

public class ProductDAO {

	@Autowired
	private DbConnection con;	
	
	public ProductDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DbConnection getCon() {
		return con;
	}

	public void setCon(DbConnection con) {
		this.con = con;
	}

	//ADD Product
    public void addProduct(E_Product product){
         
         EntityManager em = con.getEntityManager();
         em.getTransaction().begin();
           em.persist(product);
         em.getTransaction().commit();
         em.close();
    }
    
    //FIND BY product name
    
    public E_Product findByProductname(String productname){
         
         List<E_Product> qResult = new ArrayList<>();
         EntityManager em = con.getEntityManager();
             
         TypedQuery<E_Product> q = em.createNamedQuery("E_Product.findProductByName",E_Product.class);
         q.setParameter("productName", productname);
         qResult = q.getResultList();
         em.close();
         if(qResult != null && qResult.size() == 1){
             return qResult.get(0);
         }
         else{
             return null;
         }
         
    }
    
    //FIND ALL users
    
    public List<E_Product> findAllUsers(){
             
             List<E_Product> qResult = new ArrayList<>();
             
             EntityManager em = con.getEntityManager();
                  
             TypedQuery<E_Product> q = em.createNamedQuery("E_Product.findAllProducts",E_Product.class);
             
             qResult = q.getResultList();
             
             em.close();
             
             return qResult;
    }



}
