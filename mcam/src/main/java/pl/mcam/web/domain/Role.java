package pl.mcam.web.domain;

import java.util.List;

import javax.persistence.*;

/**
 * 
 * @author Tokarz Piotr
 *
 */
@Entity
@Table(name="roles")
public class Role {
	
	public Long getId() {
		return this.id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	public List<User> getUsers() {
		return this.users;
	}
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="ROLES_PK_SEQUENCE", sequenceName="roles_pk_sequence")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLES_PK_SEQUENCE")
	private Long id;
	
	@Column(name="name", unique=true, nullable=false)
	private String name;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=User.class)
	@PrimaryKeyJoinColumn
	private List<User> users;
}
