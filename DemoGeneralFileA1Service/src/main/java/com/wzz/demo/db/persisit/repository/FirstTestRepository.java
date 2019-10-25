package com.wzz.demo.db.persisit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wzz.demo.db.persisit.FirstTestPO;

@Repository
public interface FirstTestRepository extends JpaRepository<FirstTestPO, String>{

}
