package com.wzz.demo.db.persisit;

import java.io.Serializable;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentityGenerator;
import org.hibernate.id.UUIDGenerator;

public class IdGeneral extends UUIDGenerator {

	@Override
	public Serializable generate(SharedSessionContractImplementor s, Object obj) {
		Object id = SnowflakeIdHelper.getId();
		if (id != null) {
			return (Serializable) id;
		}
		return super.generate(s, obj);
	}
}
