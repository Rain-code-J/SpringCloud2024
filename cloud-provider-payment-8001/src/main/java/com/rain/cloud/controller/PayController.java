package com.rain.cloud.controller;

import com.rain.cloud.entities.Pay;
import com.rain.cloud.entities.PayDTO;
import com.rain.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pay")
public class PayController {
	@Resource
	private PayService payService;

	@PostMapping(value = "/add")
	@Operation(summary = "新增", description = "新增支付流水方法,json串做参数")
	public String addPay(@RequestBody PayDTO payDTO) {
		System.out.println(payDTO.toString());
		int i = payService.add(payDTO);
		return "成功插入记录，返回值：" + i;
	}

	@DeleteMapping(value = "/del/{id}")
	@Operation(summary = "删除", description = "删除支付流水方法")
	public Integer deletePay(@PathVariable("id") Integer id) {
		return payService.delete(id);
	}

	@PutMapping(value = "/update")
	@Operation(summary = "修改", description = "修改支付流水方法")
	public String updatePay(@RequestBody PayDTO payDTO) {
		Pay pay = new Pay();
		BeanUtils.copyProperties(payDTO, pay);

		int i = payService.update(pay);
		return "成功修改记录，返回值：" + i;
	}

	@GetMapping(value = "/get/{id}")
	@Operation(summary = "按照ID查流水", description = "查询支付流水方法")
	public Pay getById(@PathVariable("id") Integer id) {
		return payService.getById(id);
	}

	@GetMapping(value = "/list")
	public List<Pay> list() {
		return payService.getAll();
	}
}
 

 