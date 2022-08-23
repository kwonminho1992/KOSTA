package com.example.demo.docker.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="test_docker")
@Getter @Setter
public class Test {
	@Id
	private String a;
	private Integer b;
}
