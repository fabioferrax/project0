package it.uniroma3.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private Long id;
	@Column(unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	
	/*
	@Column(nullable = true)
	private String mail;*/
	
	public Utente(){}
	
	public Utente(String username,String password){
		this.username = username;
		this.password = password;
	}
	/*
	public Utente(String username,String password,String mail){
		this.username = username;
		this.password = password;
		this.mail = mail;
	}*/
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
