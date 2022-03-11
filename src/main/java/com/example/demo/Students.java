package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@Entity
public class Students {
	@Id
	private int sid;
	private String sname;
	private String stopic;
	private int smark;

}
