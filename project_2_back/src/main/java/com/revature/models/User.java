package com.revature.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "users")
@Component
public class User {
	
	/* Defining fields/DB columns -------------------------------------------------------------------------- */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // makes id serial
	private int userId;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true
	)
	private String userUsername;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"
	)
	private String userPassword;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"			
	)
	private String userFirstName;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT"			
	)
	private String userLastName;
	
	@Column(
			nullable = false,
			columnDefinition = "TEXT",
			unique = true
	)
	private String userEmail;
	
	// noticed I might've done something extra below
	
	// @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	// @JoinColumn(name = "roleId") // or role_id
	// private Roles userRoleIdFk;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userRole", referencedColumnName="userRoleId") //referencedColumName needs to match field name in the referenced table's model
	private UserRole userRole;

	/* Constructors ---------------------------------------------------------------------------------------- */
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userUsername, String userPassword, String userFirstName, String userLastName, String userEmail) {
		super();
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
	}

	public User(String userUsername, String userPassword, String userFirstName, String userLastName, String userEmail,
			UserRole userRole) {
		super();
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}

	public User(int userId, String userUsername, String userPassword, String userFirstName, String userLastName,
			String userEmail, UserRole userRole) {
		super();
		this.userId = userId;
		this.userUsername = userUsername;
		this.userPassword = userPassword;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmail = userEmail;
		this.userRole = userRole;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", userFirstName=" + userFirstName + ", userLastName=" + userLastName + ", userEmail=" + userEmail
				+ ", userRole=" + userRole + "]";
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	
	// all except id for creating users


	// all except id and password (for accessing user object post login)


	//all args


	/* toString -------------------------------------------------------------------------------------------- */


	/* Getters & Setters ----------------------------------------------------------------------------------- */

}
