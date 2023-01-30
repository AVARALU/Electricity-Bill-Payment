package com.capgemini.service;

import java.util.Date;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.Connection;
import com.capgemini.entity.Reading;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.repository.ReadingRepository;

@Service
public class ReadingService implements IReadingService {

	@Autowired
	private ReadingRepository read;

	@Autowired
	private IBillService billService;
	
	@Override
	public Reading selfSubmit(Reading reading) {
		Double pricePerUnit = 4.5;
		Reading reading1 = null;
		Connection existingConnection = reading.getReadingForConnection();
		Long connectionId = existingConnection.getConnectionId();
		if (connectionId == 0) {
			reading.setPricePerUnits(pricePerUnit);
			reading.setReadingDate(new Date());
			reading.setReadingPhoto("Photo");
			reading1 = read.save(reading);
			billService.generateBill(reading1);
			
		} else {
			reading.setReadingForConnection(existingConnection);
			reading.setPricePerUnits(pricePerUnit);
			reading.setReadingDate(new Date());
			reading.setReadingPhoto("Photo");
			reading1 = read.save(reading);
			billService.generateBill(reading1);
		}

		return reading1;
	}

	@Override
	public Reading findMeterReadingByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		return read.findMeterReadingByConsumerNumber(consumerNumber)
				.orElseThrow(() -> new NoSuchCustomerException("Customer Not Exist!"));
	}

}
