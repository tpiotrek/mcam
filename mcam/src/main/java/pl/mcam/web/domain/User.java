package pl.mcam.web.domain;

import javax.persistence.*;

@Entity
@Table(name="users")
public class User {

	public Long getId() {
		return this.id;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public String getFname() {
		return this.fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public String getLname() {
		return this.lname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public Role getRole() {
		return this.role;
	}
	
	public void setRole(Role role) {
		this.role = role;
	}
	
	public void setStatus(UserStatus status) {
		this.status = status;
	}
	
	public UserStatus getStatus() {
		return this.status;
	}
	
	@Id
	@SequenceGenerator(name="USERS_PK_SEQUENCE", sequenceName="users_pk_sequence", initialValue=1, allocationSize=100)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="USERS_PK_SEQUENCE")
	@Column(name="id")
	private Long id;
	
	@Column(name="fname", nullable=false)
	private String fname;
	
	@Column(name="lname", nullable=false)
	private String lname;
	
	@Column(name="email", unique=true, nullable=false)
	private String email;
	
	@Column(name="password", nullable=false)
	private String password;
	
	@Column(name="status", nullable=false)
	private UserStatus status;
	
	@ManyToOne(fetch=FetchType.LAZY, targetEntity=Role.class)
	@JoinColumn(name="role")
	private Role role;
}
