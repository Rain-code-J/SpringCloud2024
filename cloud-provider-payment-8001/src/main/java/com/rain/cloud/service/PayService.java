package com.rain.cloud.service;

import com.rain.cloud.entities.Pay;
import com.rain.cloud.entities.PayDTO;
import com.rain.cloud.mapper.PayMapper;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayService {
	@Resource
	private PayMapper payMapper;


	public int add(PayDTO payDTO) {
		Pay pay = new Pay();
		BeanUtils.copyProperties(payDTO, pay);
		return payMapper.insertSelective(pay);
	}


	public int delete(Integer id) {
		return payMapper.deleteByPrimaryKey(id);
	}


	public int update(Pay pay) {
		return payMapper.updateByPrimaryKeySelective(pay);
	}


	public Pay getById(Integer id) {
		return payMapper.selectByPrimaryKey(id);
	}


	public List<Pay> getAll() {
		return payMapper.selectAll();
	}
}
 

 