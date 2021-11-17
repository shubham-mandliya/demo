package com.infinx.product.demo.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.infinx.product.demo.exception.ResourceNotFoundException;
import com.infinx.product.demo.model.Bill;
import com.infinx.product.demo.repository.BillRepository;
import com.infinx.product.demo.service.BillService;

@Service
public class BillServiceImpl implements BillService{

	private BillRepository billRepository;
	
	public BillServiceImpl(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}

	@Override
	public Bill saveBill(Bill bill) {
		return billRepository.save(bill);
	}

	@Override
	public List<Bill> getAllBills() {
		return billRepository.findAll();
	}

	@Override
	public Bill getBillByBillNumber(long billNumber) {
		
		Optional<Bill> bill = billRepository.findById(billNumber);
		if(bill.isPresent()) {
			return bill.get();
		}else {
			return null;
		}
				
	}

	@Override
	public List<Bill> getBillsByDueDate(Date dueDate) {
		// TODO Auto-generated method stub
		return billRepository.findByDueDate(dueDate);
	}


	
}
