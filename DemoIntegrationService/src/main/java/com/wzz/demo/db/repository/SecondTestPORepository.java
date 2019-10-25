package com.wzz.demo.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wzz.demo.db.SecondTestPO;
import java.lang.String;
import java.util.List;

public interface SecondTestPORepository extends JpaRepository<SecondTestPO, Integer>{
	SecondTestPO findByName(String name);
}
