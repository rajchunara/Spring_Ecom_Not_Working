package com.fdmgroup.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import com.fdmgroup.model.E_Users;


public class UsersDAO {
	

	@Autowired
	private DbConnection con;

	
	
	public UsersDAO() {
		super();
		// TODO Auto-generated constructor stub
		//this.con = DbConnection.getInstance();
	}

	public DbConnection getCon() {
		return con;
	}

	public void setCon(DbConnection con) {
		this.con = con;
	}

	//ADD user
    public void addUser(E_Users user){
         
         EntityManager em = con.getEntityManager();
         em.getTransaction().begin();
           em.persist(user);
         em.getTransaction().commit();
         em.close();
    }
    
    //FIND BY username
    
    public E_Users findByUsername(String username){
         
         List<E_Users> qResult = new ArrayList<>();
         EntityManager em = con.getEntityManager();
             
         TypedQuery<E_Users> q = em.createNamedQuery("E_Users.findUsername",E_Users.class);
         q.setParameter("name", username);
         qResult = q.getResultList();
         em.close();
         if(qResult != null && qResult.size() == 1){
             return qResult.get(0);
         }
         else{
             return null;
         }
         
    }
    
    //Find by userid
    public E_Users findByUserid(int i){
        
        List<E_Users> qResult = new ArrayList<>();
        EntityManager em = con.getEntityManager();
            
        TypedQuery<E_Users> q = em.createNamedQuery("E_Users.findByUserid",E_Users.class);
        q.setParameter("userid", i);
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
    
    public List<E_Users> findAllUsers(){
             
             List<E_Users> qResult = new ArrayList<>();
             
             EntityManager em = con.getEntityManager();
                  
             TypedQuery<E_Users> q = em.createNamedQuery("E_Users.findAllUser",E_Users.class);
             
             qResult = q.getResultList();
             
             em.close();
             
             return qResult;
    }
    
}
