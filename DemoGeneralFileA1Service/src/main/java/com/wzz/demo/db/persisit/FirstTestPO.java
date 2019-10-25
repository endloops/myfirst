package com.wzz.demo.db.persisit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="T_fitst")
public class FirstTestPO {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO,generator="first_id")
	@GenericGenerator(name="first_id",strategy="com.wzz.demo.db.persisit.IdGeneral")
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
}
