package com.capgemini.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.entity.Bill;
import com.capgemini.entity.Reading;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.entity.ConnectionType;
import com.capgemini.service.IBillService;

@RestController
@RequestMapping("/bill")
public class BillController {
	
	@Autowired
	private IBillService billService;

	@PostMapping(value = "/generateBill")
	public ResponseEntity<Bill> generateBill(@RequestBody Reading reading) {
		Bill generatedBill = billService.generateBill(reading);
		return new ResponseEntity<Bill>(generatedBill, HttpStatus.CREATED);
	}

	@GetMapping(value = "/consumernumber/{consumerNumber}")
	public ResponseEntity<Bill> viewBillByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		return new ResponseEntity<Bill>(billService.viewBillByConsumerNumber(consumerNumber), HttpStatus.OK);

	}

	@GetMapping(value = "/mobilenumber/{mobileNumber}")
	public ResponseEntity<Bill> viewBillByMobileNumber(String mobileNumber) throws NoSuchCustomerException {
		Bill billByMobileNumber = billService.viewBillByMobileNumber(mobileNumber);
		return new ResponseEntity<Bill>(billByMobileNumber, HttpStatus.OK);
	}

	@GetMapping(value = "/email/{email}")
	public ResponseEntity<Bill> viewBillByEmail(String email) throws NoSuchCustomerException {
		Bill billByEmail = billService.viewBillByEmail(email);
		return new ResponseEntity<Bill>(billByEmail, HttpStatus.OK);
	}

	@GetMapping(value = "/dateRange")
	public ResponseEntity<List<Bill>> viewBillForDateRange(String from, String to)
			throws NoSuchCustomerException, ParseException {
		Date f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(from);
		Date t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S").parse(to);
		List<Bill> billForDateRange = billService.viewBillForDateRange(f, t);
		return new ResponseEntity<List<Bill>>(billForDateRange, HttpStatus.OK);
	}

	@GetMapping("/emailBillToCustomer")
	public ResponseEntity<?> emailBillToCustomer(@RequestParam String email, @RequestParam Long consumerNumber)
			throws NoSuchCustomerException {
		billService.emailBillToCustomer(consumerNumber, email);
		return new ResponseEntity<>("Bill sent successfully to this email " + email, HttpStatus.OK);
	}
	
	@GetMapping("/energyBillCalculator")
	public  ResponseEntity<Object> energyBillCalculator(@RequestParam ("connectionType") String connectionType,@RequestParam("units") double units) {
		
		double b=billService.energyBillCalculator(ConnectionType.valueOf(connectionType), units);
		return new ResponseEntity<Object>("Energy Bill for the "+connectionType+" for units "+units+" is: "+b,HttpStatus.OK);
		
	}
}
