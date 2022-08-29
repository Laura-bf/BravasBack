package com.net.bravas.backend.model.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Data
public class GroupUsersInfoKey implements Serializable{

	private static final long serialVersionUID = 1725658759442790362L;
	
	@Column(name = "user_uuid")
	private String userUuid;
	@Column(name = "group_uuid")
	private String groupUuid;

}
