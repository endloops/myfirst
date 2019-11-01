package com.wzz.demo.integration.service.repository.bean;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.DefaultDeserializer;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class RedisObjectSerializer implements RedisSerializer<Object>{

	private Converter<Object, byte[]> serializer = new SerializingConverter();
	
	private Converter<byte[], Object> deserializer = new DeserializingConverter();
	
	static final byte[] EMPTY_ARRAY = new byte[0];
	
//	private ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Object deserialize(byte[] arg0) throws SerializationException {
		if(isEmpty(arg0)){
			return null;
		}
		try {
			return deserializer.convert(arg0);
		} catch (Exception e) {
			throw new SerializationException("can not deserialize",e);
		}
		
	}

	@Override
	public byte[] serialize(Object arg0) throws SerializationException {
		if(arg0 == null){
			return EMPTY_ARRAY;
		}
		try {
			return serializer.convert(arg0);
		} catch (Exception e) {
			return EMPTY_ARRAY;
		}
	}
	private boolean isEmpty(byte[] data) {
	    return (data == null || data.length == 0);
	  }
}
