package com.capgemini.service;

import com.capgemini.entity.Reading;
import com.capgemini.exception.NoSuchCustomerException;

public interface IReadingService {
	
	public Reading selfSubmit(Reading reading);
	public Reading findMeterReadingByConsumerNumber(Long consumerNumber)throws NoSuchCustomerException;
	//public Reading findMeterReadingByConsumerNumberAndBillDate(Long consumerNumber, Date billDate)throws NoSuchCustomerException;
}



