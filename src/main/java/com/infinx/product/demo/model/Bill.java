package com.infinx.product.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



@Entity
@Table(name="bill")
public class Bill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long billNumber;
	
	@Column(name = "billed_to", nullable = false)
	private String billedTo;
	
	@Column(name = "billed_date")
	private Date billedDate;

	@Column(name = "billed_amount")
	private Double billedAmount;
	
	@Column(name = "tax_on_the_bill")
	private Double taxOnTheBill;
	
	@Column(name = "total_amount")
	private Double totalAmount;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "due_date")
	private Date dueDate;

	public long getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(long billNumber) {
		this.billNumber = billNumber;
	}

	public String getBilledTo() {
		return billedTo;
	}

	public void setBilledTo(String billedTo) {
		this.billedTo = billedTo;
	}

	public Date getBilledDate() {
		return billedDate;
	}

	public void setBilledDate(Date billedDate) {
		this.billedDate = billedDate;
	}

	public Double getBilledAmount() {
		return billedAmount;
	}

	public void setBilledAmount(Double billedAmount) {
		this.billedAmount = billedAmount;
	}

	public Double getTaxOnTheBill() {
		return taxOnTheBill;
	}

	public void setTaxOnTheBill(Double taxOnTheBill) {
		this.taxOnTheBill = taxOnTheBill;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}	
}
