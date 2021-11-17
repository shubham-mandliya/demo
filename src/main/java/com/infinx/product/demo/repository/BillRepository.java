package com.infinx.product.demo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.infinx.product.demo.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long>{
	
	List<Bill> findByDueDate(Date date);

}
