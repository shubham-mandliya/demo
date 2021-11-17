package com.infinx.product.demo.service;

import java.util.Date;
import java.util.List;

import com.infinx.product.demo.model.Bill;

public interface BillService {
	Bill saveBill(Bill bill);
	List<Bill> getAllBills();
	Bill getBillByBillNumber(long billNumber);
	List<Bill> getBillsByDueDate(Date dueDate);
	
}
