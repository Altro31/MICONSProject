package clases;

import java.io.Serializable;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3075924453208342684L;

	// Fields
	private String name;
	private String lastname1;
	private String lastname2;
	private String cI;
	private String mail;
	private String username;
	private String password;

	// Constructor
	public User(String nombre, String apellido1, String apellido2, String cI, String correo, String username,
			String password) {

		this.name = nombre;
		this.lastname1 = apellido1;
		this.lastname2 = apellido2;
		this.cI = cI;
		this.mail = correo;
		this.username = username;
		this.password = password;

	}

	/**
	 * Verify if username and password is the same to this instance's username and password
	 * @return True if it's correct or False if it's not
	 */
	
	public boolean checkUser(String username, String password) {

		boolean check = false;

		if (this.username.equals(username) && this.password.equals(password)) {
			check = true;
		}

		return check;
	}

	// Getters and Setters

	public String getName() {
		return name + "";
	}

	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty");
		}
		this.name = name;
	}

	public String getLastname1() {
		return lastname1 + "";
	}

	public void setLastname1(String lastname1) {
		if (lastname1 == null) {
			throw new IllegalArgumentException("lastname1 cannot be null");
		}
		if (lastname1.isEmpty()) {
			throw new IllegalArgumentException("lastname1 cannot be empty");
		}
		this.lastname1 = lastname1;
	}

	public String getLastname2() {
		return lastname2 + "";
	}

	public void setLastname2(String lastname2) {
		if (lastname2 == null) {
			throw new IllegalArgumentException("lastname2 cannot be null");
		}
		if (lastname2.isEmpty()) {
			throw new IllegalArgumentException("lastname2 cannot be empty");
		}
		this.lastname2 = lastname2;
	}

	public String getcI() {
		return cI + "";
	}

	public void setcI(String cI) {
		if (cI == null) {
			throw new IllegalArgumentException("cI cannot be null");
		}
		if (cI.isEmpty()) {
			throw new IllegalArgumentException("cI cannot be empty");
		}
		this.cI = cI;
	}

	public String getMail() {
		return mail + "";
	}

	public void setMail(String mail) {
		if (mail == null) {
			throw new IllegalArgumentException("mail cannot be null");
		}
		if (mail.isEmpty()) {
			throw new IllegalArgumentException("mail cannot be empty");
		}
		this.mail = mail;
	}

	public String getUsername() {
		return username + "";
	}

	public void setUsername(String username) {
		if (username == null) {
			throw new IllegalArgumentException("username cannot be null");
		}
		if (username.isEmpty()) {
			throw new IllegalArgumentException("username cannot be empty");
		}
		this.username = username;
	}

	public String getPassword() {
		return password + "";
	}

	public void setPassword(String password) {
		if (password == null) {
			throw new IllegalArgumentException("password cannot be null");
		}
		if (password.isEmpty()) {
			throw new IllegalArgumentException("password cannot be empty");
		}
		this.password = password;
	}

}
