package com.sn.auth.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Entity
@Table(name="roles")
public class Role {
	
	@Id
	private int id;
	
	private String name;

}
