package com.capgemini.service;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.Bill;
import com.capgemini.entity.ConnectionType;
import com.capgemini.entity.Reading;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.repository.BillRepository;
import com.capgemini.repository.ReadingRepository;

@Service
public class BillServiceImpl implements IBillService {
	@Autowired
	private BillRepository billRepository;

	@Autowired
	private ReadingRepository readingRepository;

	@Override
	public Bill generateBill(Reading reading) {
		Long readingId = reading.getReadingId();
		Reading existingReading = readingRepository.findById(readingId).get();

		Double pricePerUnit = existingReading.getPricePerUnits();
		Double unitsConsumed = existingReading.getUnitsConsumed();
		Bill bill = new Bill();
		bill.setBillDate(new Date());
		bill.setBillForReading(existingReading);
		bill.setUnitsConsumed(unitsConsumed);
		bill.setBillAmount(pricePerUnit * unitsConsumed);
		Bill generatedBill = billRepository.save(bill);
		return generatedBill;
	}

	@Override
	public Bill viewBillByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		return billRepository.viewBillByConsumerNumber(consumerNumber)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));

	}

	@Override
	public Bill viewBillByMobileNumber(String mobileNumber) throws NoSuchCustomerException {
		return billRepository.viewBillByMobileNumber(mobileNumber)
				.orElseThrow(() -> new NoSuchCustomerException("No Customer Exist!"));
	}

	@Override
	public Bill viewBillByEmail(String email) throws NoSuchCustomerException {
		return billRepository.viewBillByEmail(email)
				.orElseThrow(() -> new NoSuchCustomerException("Bill Is Not available for given email :" + email));
	}

	@Override
	public List<Bill> viewBillForDateRange(Date from, Date to) throws NoSuchCustomerException {
		try {
			return billRepository.findAllByBillDateBetween(from, to);
		} catch (Exception e) {
			throw new NoSuchCustomerException("Bill Is Not Available For Date from" + from + "to" + to);
		}
	}

	@Override
	public void emailBillToCustomer(Long consumerNumber, String email) throws NoSuchCustomerException {
		System.out.println(("email bill to customer" + billRepository.viewBillByConsumerNumber(consumerNumber)));

	}

	@Override
	public double energyBillCalculator(ConnectionType connectionType, double units) {
		
		if(connectionType==ConnectionType.AGRICULTURAL) {
			return units*5;
		}
		if(connectionType==ConnectionType.INDUSTRIAL) {
			return units*8;
		}
		else {
			return units*6;
		}
	}

}
