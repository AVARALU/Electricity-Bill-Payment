package com.capgemini.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Connection {
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long connectionId;

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long consumerNumber;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private Customer customerConnection;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "addressId")
	private Address connectionAddress;

	@Enumerated(EnumType.STRING)
	private ConnectionType connectionType;

	private Date applicationDate;

	private Date connectionDate;

	@Enumerated(EnumType.STRING)
	private ConnectionStatus connectionStatus;

	public Long getConnectionId() {
		return connectionId;
	}

	public void setConnectionId(Long connectionId) {
		this.connectionId = connectionId;
	}

	public Long getConsumerNumber() {
		return consumerNumber;
	}

	public void setConsumerNumber(Long consumerNumber) {
		this.consumerNumber = consumerNumber;
	}

	public Customer getCustomerConnection() {
		return customerConnection;
	}

	public void setCustomerConnection(Customer customerConnection) {
		this.customerConnection = customerConnection;
	}

	public Address getConnectionAddress() {
		return connectionAddress;
	}

	public void setConnectionAddress(Address connectionAddress) {
		this.connectionAddress = connectionAddress;
	}

	public ConnectionType getConnectionType() {
		return connectionType;
	}

	public void setConnectionType(ConnectionType connectionType) {
		this.connectionType = connectionType;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public Date getConnectionDate() {
		return connectionDate;
	}

	public void setConnectionDate(Date connectionDate) {
		this.connectionDate = connectionDate;
	}

	public ConnectionStatus getConnectionStatus() {
		return connectionStatus;
	}

	public void setConnectionStatus(ConnectionStatus connectionStatus) {
		this.connectionStatus = connectionStatus;
	}

	@Override
	public String toString() {
		return "Connection [connectionId=" + connectionId + ", consumerNumber=" + consumerNumber
				+ ", customerConnection=" + customerConnection + ", connectionAddress=" + connectionAddress
				+ ", connectionType=" + connectionType + ", applicationDate=" + applicationDate + ", connectionDate="
				+ connectionDate + ", connectionStatus=" + connectionStatus + "]";
	}

	public Connection(Long connectionId, Long consumerNumber, Customer customerConnection, Address connectionAddress,
			ConnectionType connectionType, Date applicationDate, Date connectionDate,
			ConnectionStatus connectionStatus) {
		super();
		this.connectionId = connectionId;
		this.consumerNumber = consumerNumber;
		this.customerConnection = customerConnection;
		this.connectionAddress = connectionAddress;
		this.connectionType = connectionType;
		this.applicationDate = applicationDate;
		this.connectionDate = connectionDate;
		this.connectionStatus = connectionStatus;
	}

	public Connection() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
