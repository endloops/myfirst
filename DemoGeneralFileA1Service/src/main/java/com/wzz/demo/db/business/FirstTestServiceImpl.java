package com.wzz.demo.db.business;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingapi.txlcn.tc.annotation.DTXPropagation;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.wzz.demo.db.persisit.FirstTestPO;
import com.wzz.demo.db.persisit.repository.FirstTestRepository;

@Service
public class FirstTestServiceImpl implements FirstTestService{

	@Autowired
	FirstTestRepository firstTestRepository;
	
	@Override
	@LcnTransaction(propagation=DTXPropagation.SUPPORTS)
	@Transactional
	public FirstTestPO saveNewFirstTestPO(FirstTestPO firstTestPO) {
		FirstTestPO res = firstTestRepository.save(firstTestPO);
		return res;
	}

}
