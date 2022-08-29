package com.net.bravas.backend.model.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Posts")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Post {
	
	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy ="uuid")
	@Column(name = "post_uuid")
	private String postUuid;
	
	@Column(name = "title", nullable = false, unique = true)
	private String title;
	
	@Column(name = "date", updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@Column(name = "body", nullable = false)
	private String body;
	
	@ManyToOne
	@JoinColumn(name = "user_uuid", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "group_uuid", nullable = false)
	private Group group;
	
	@OneToMany(mappedBy = "post")
	private List<Like> postLikes;
	
	@OneToMany(mappedBy = "post")
	private List<Comment> postComments;
	
}
