package com.capgemini.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long billId;

	private Date billDate;

	private LocalDate billDueDate;

	private double unitsConsumed;

	private double billAmount;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "reading_fk", referencedColumnName = "readingId")
	private Reading billForReading;

	public Long getBillId() {
		return billId;
	}

	public void setBillId(Long billId) {
		this.billId = billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public LocalDate getBillDueDate() {
		return billDueDate;
	}

	public void setBillDueDate(LocalDate billDueDate) {
		this.billDueDate = billDueDate;
	}

	public double getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}

	public Reading getBillForReading() {
		return billForReading;
	}

	public void setBillForReading(Reading billForReading) {
		this.billForReading = billForReading;
	}

	public Bill(Long billId, Date billDate, LocalDate billDueDate, double unitsConsumed, double billAmount,
			Reading billForReading) {
		super();
		this.billId = billId;
		this.billDate = billDate;
		this.billDueDate = billDueDate;
		this.unitsConsumed = unitsConsumed;
		this.billAmount = billAmount;
		this.billForReading = billForReading;
	}

	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Bill [billId=" + billId + ", billDate=" + billDate + ", billDueDate=" + billDueDate + ", unitsConsumed="
				+ unitsConsumed + ", billAmount=" + billAmount + ", billForReading=" + billForReading + "]";
	}
	
	
}
