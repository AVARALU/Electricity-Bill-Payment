package com.capgemini.service;

import java.util.List;

import com.capgemini.entity.Payment;
import com.capgemini.entity.PaymentStatus;
import com.capgemini.exception.NoSuchCustomerException;

public interface IPaymentService
{
	public PaymentStatus payBill(Payment payment);
	public void sendEmailOnPaymentCompletion(Long consumerId, String email);
	public List<Payment> viewHistoricalPayment(Long consumerNumber)throws NoSuchCustomerException;
	

}
