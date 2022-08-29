package com.net.bravas.backend.model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Groups")
@Data
@NoArgsConstructor
public class Group {

	@Id
	@GeneratedValue(generator = "idGenerator")
	@GenericGenerator(name = "idGenerator", strategy ="uuid")
	@Column(name = "group_uuid")
	private String groupUuid;
	
	@Column(name ="group_name", nullable = false, unique = true)
	private String groupName;
	
	@Lob
	@Column(name = "group_image", nullable = true)
	private byte[] groupImage;
	
	@Column(name = "description", nullable = true)
	private String description;
	
	@OneToMany(mappedBy = "group")
	private List<GroupUsersInfo> groupUsers;
	
	@OneToMany(mappedBy = "group")
	private List<Post> groupPosts;
	
			
}
