package com.infinx.product.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinx.product.demo.exception.ResourceNotFoundException;
import com.infinx.product.demo.model.Bill;
import com.infinx.product.demo.service.BillService;

@RestController
@RequestMapping("/bills")
public class BillController {
	
	private BillService billService;

	public BillController(BillService billService) {
		super();
		this.billService = billService;
	}
	
	// build create bill REST API
	@PostMapping()
	public ResponseEntity<Bill> saveBill(@RequestBody Bill bill){
		return new ResponseEntity<Bill>(billService.saveBill(bill), HttpStatus.CREATED);
	}
	
	// build get all bills REST API
	@GetMapping
	public List<Bill> getAllBills(){
		return billService.getAllBills();
	}
	
	// http://localhost:8080/bills/1
	@GetMapping("{id}")
	public ResponseEntity<Bill> getBillByBillNumber(@PathVariable("id") long billNumber){
		Bill bill = billService.getBillByBillNumber(billNumber);
		if(bill == null) throw new ResourceNotFoundException("Bill", "Bill Number", billNumber);
		return new ResponseEntity<Bill>(bill, HttpStatus.OK);
	}
	
//	// http://localhost:8080/bills/due/26-11-21
	@GetMapping("due/{date}")
	public List<Bill> getBillsByDueDate(@PathVariable("date") @DateTimeFormat(pattern="d-M-yy", fallbackPatterns = {"dd-MM-yyyy"})Date date){
		return billService.getBillsByDueDate(date);
	}
	
		
}
