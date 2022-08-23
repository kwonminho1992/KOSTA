package com.example.demo.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.docker.dto.Test;

public interface TestRepository extends JpaRepository<Test, String>{

}
