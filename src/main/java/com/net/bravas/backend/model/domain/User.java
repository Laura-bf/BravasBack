package com.net.bravas.backend.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy ="uuid")
	@Column(name = "user_uuid")
	private String userUuid;
	
	@Column(name = "user_name", nullable = false, unique = true)
	private String userName;
	
	@Column(name = "email", nullable = false, unique = true)
	private String email;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@OneToMany(mappedBy = "user")
	private List<GroupUsersInfo> userGroups;
	
	@OneToMany(mappedBy = "user")
	private List<Post> userPosts;
	
	@OneToMany(mappedBy = "user")
	private List<Like> userLikes;
	
	@OneToMany(mappedBy = "user")
	private List<Comment> userComments;
}
