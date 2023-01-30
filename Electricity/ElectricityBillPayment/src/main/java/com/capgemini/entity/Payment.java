package com.capgemini.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


@Entity
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.LAZY)
	@JoinColumn(name = "bill_fk", referencedColumnName = "billId")
	private Bill billPayment;

	private Date paymentDate;

	@Enumerated(EnumType.STRING)
	private PaymentMode paymentMode;

	private double latePaymentCharges;

	private double totalPaid;

	@Enumerated(EnumType.STRING)
	private PaymentStatus status;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public Bill getBillPayment() {
		return billPayment;
	}

	public void setBillPayment(Bill billPayment) {
		this.billPayment = billPayment;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(PaymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getLatePaymentCharges() {
		return latePaymentCharges;
	}

	public void setLatePaymentCharges(double latePaymentCharges) {
		this.latePaymentCharges = latePaymentCharges;
	}

	public double getTotalPaid() {
		return totalPaid;
	}

	public void setTotalPaid(double totalPaid) {
		this.totalPaid = totalPaid;
	}

	public PaymentStatus getStatus() {
		return status;
	}

	public void setStatus(PaymentStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", billPayment=" + billPayment + ", paymentDate=" + paymentDate
				+ ", paymentMode=" + paymentMode + ", latePaymentCharges=" + latePaymentCharges + ", totalPaid="
				+ totalPaid + ", status=" + status + "]";
	}

	public Payment(Long paymentId, Bill billPayment, Date paymentDate, PaymentMode paymentMode,
			double latePaymentCharges, double totalPaid, PaymentStatus status) {
		super();
		this.paymentId = paymentId;
		this.billPayment = billPayment;
		this.paymentDate = paymentDate;
		this.paymentMode = paymentMode;
		this.latePaymentCharges = latePaymentCharges;
		this.totalPaid = totalPaid;
		this.status = status;
	}

	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}