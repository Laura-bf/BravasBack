package com.net.bravas.backend.model.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Comments")
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Comment {

	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy ="uuid")
	@Column(name = "comment_uuid")
	private String commentUuid;
	
	@Column(name = "comment_text", nullable = false)
	private String body;
	
	@Column(name = "date", updatable = false, nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	@ManyToOne
	@JoinColumn(name = "user_uuid", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "upost_uuid", nullable = false)
	private Post post;
}
