package com.capgemini.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.entity.Connection;
import com.capgemini.entity.Customer;
import com.capgemini.exception.NoSuchConnectionException;
import com.capgemini.exception.NoSuchCustomerException;
import com.capgemini.repository.ConnectionRepository;


@Service
public class ConnectionServiceImpl implements IConnectionService {

	@Autowired
	private ConnectionRepository connectionRepository;


	@Override
	public Connection newConnectionRequest(Connection newConnection) throws Exception {

		Optional<Connection> c = connectionRepository.findById(newConnection.getConnectionId());
		if (c.isPresent()) {
			throw new Exception("Connection already exist with id :" + newConnection.getConnectionId());
		}

		Customer customer = newConnection.getCustomerConnection();
		Long userId = customer.getUserId();
		Connection con = null;
		if (userId == 0) {
			newConnection.setConnectionDate(new Date());
			Random random = new Random();
			Integer randonNumber = random.nextInt(12);
			Long random1 = (long) ((int) Math.random() * randonNumber);
			System.out.println(random1);
			newConnection.setConsumerNumber(random1);
			newConnection.setApplicationDate(new Date());
			con = connectionRepository.save(newConnection);
		} else {
			Customer existingCustomer = newConnection.getCustomerConnection();
			newConnection.setCustomerConnection(existingCustomer);
			newConnection.setConnectionDate(new Date());
			newConnection.setConsumerNumber(new Random().nextLong() + new Random(1000).nextInt());
			newConnection.setApplicationDate(new Date());
			con = connectionRepository.save(newConnection);

		}

		return con;
	}

	@Override
	public Customer searchCustomerByConsumerNumber(Long consumerNumber) throws NoSuchCustomerException {
		Connection c = connectionRepository.findByConsumerNumber(consumerNumber)
				.orElseThrow(() -> new NoSuchConnectionException("No Connection Exists!"));
		Customer c1 = new Customer();
		c1.setAadhaarNumber(c.getCustomerConnection().getAadhaarNumber());
		c1.setEmail(c.getCustomerConnection().getEmail());
		c1.setFirstName(c.getCustomerConnection().getFirstName());
		c1.setGender(c.getCustomerConnection().getGender());
		c1.setLastName(c.getCustomerConnection().getLastName());
		c1.setMiddleName(c.getCustomerConnection().getMiddleName());
		c1.setMobileNumber(c.getCustomerConnection().getMobileNumber());
		c1.setPassword(c.getCustomerConnection().getPassword());
		c1.setUserId(c.getCustomerConnection().getUserId());
		c1.setUserName(c.getCustomerConnection().getUserName());
		return c1;

	}

	@Override
	public List<Connection> findActiveConnectionsByVillage(String village) throws NoSuchConnectionException {
		List<Connection> connection = connectionRepository.getActiveConnectionsByVillage(village);
		if (connection == null) {
			throw new NoSuchConnectionException("connections are not available for this village name:" + village);
		} else {
			return connection;
		}

	}

	@Override
	public List<Connection> findActiveConnectionsByTaluk(String taluk) throws NoSuchConnectionException {
		return connectionRepository.getActiveConnectionsByTaluk(taluk);
	}

	@Override
	public List<Connection> findActiveConnectionsByDistrict(String district) throws NoSuchConnectionException {
		return connectionRepository.getActiveConnectionsByDistrict(district);
	}

	@Override
	public List<Connection> findActiveConnectionsByPincode(String pincode) throws NoSuchConnectionException {
		return connectionRepository.getActiveConnectionsByPincode(pincode);
	}

	@Override
	public List<Connection> findInActiveConnectionsByVillage(String village) throws NoSuchConnectionException {
		return connectionRepository.getInActiveConnectionsByVillage(village);
	}

	@Override
	public List<Connection> findInActiveConnectionsByTaluk(String taluk) throws NoSuchConnectionException {
		return connectionRepository.getInActiveConnectionsByTaluk(taluk);
	}

	@Override
	public List<Connection> findInActiveConnectionsByDistrict(String district) throws NoSuchConnectionException {
		return connectionRepository.getInActiveConnectionsByDistrict(district);
	}

	@Override
	public List<Connection> findInActiveConnectionsByPincode(String pincode) throws NoSuchConnectionException {
		return connectionRepository.getInActiveConnectionsByPincode(pincode);
	}

}
