package com.net.bravas.backend.model.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Group_Users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class GroupUsersInfo {
	
	@EmbeddedId
	private GroupUsersInfoKey id;
	
	@ManyToOne
	@MapsId("userUuid")
	@JoinColumn(name = "user_uuid")
	private User user;
	
	@ManyToOne
	@MapsId("groupUuid")
	@JoinColumn(name = "group_uuid")
	private Group group;
	
	private boolean isAdmin;
	private boolean isOwner;
	
	
}
