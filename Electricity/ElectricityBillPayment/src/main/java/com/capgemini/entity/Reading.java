package com.capgemini.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
 
@Entity
public class Reading {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long readingId;

	private Double unitsConsumed;
	private String readingPhoto;
	private Date readingDate;
	private Double pricePerUnits;

	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "connection_id_fk", referencedColumnName = "connectionId")
	private Connection readingForConnection;

	public Long getReadingId() {
		return readingId;
	}

	public void setReadingId(Long readingId) {
		this.readingId = readingId;
	}

	public Double getUnitsConsumed() {
		return unitsConsumed;
	}

	public void setUnitsConsumed(Double unitsConsumed) {
		this.unitsConsumed = unitsConsumed;
	}

	public String getReadingPhoto() {
		return readingPhoto;
	}

	public void setReadingPhoto(String readingPhoto) {
		this.readingPhoto = readingPhoto;
	}

	public Date getReadingDate() {
		return readingDate;
	}

	public void setReadingDate(Date readingDate) {
		this.readingDate = readingDate;
	}

	public Double getPricePerUnits() {
		return pricePerUnits;
	}

	public void setPricePerUnits(Double pricePerUnits) {
		this.pricePerUnits = pricePerUnits;
	}

	public Connection getReadingForConnection() {
		return readingForConnection;
	}

	public void setReadingForConnection(Connection readingForConnection) {
		this.readingForConnection = readingForConnection;
	}

	@Override
	public String toString() {
		return "Reading [readingId=" + readingId + ", unitsConsumed=" + unitsConsumed + ", readingPhoto=" + readingPhoto
				+ ", readingDate=" + readingDate + ", pricePerUnits=" + pricePerUnits + ", readingForConnection="
				+ readingForConnection + "]";
	}

	public Reading(Long readingId, Double unitsConsumed, String readingPhoto, Date readingDate, Double pricePerUnits,
			Connection readingForConnection) {
		super();
		this.readingId = readingId;
		this.unitsConsumed = unitsConsumed;
		this.readingPhoto = readingPhoto;
		this.readingDate = readingDate;
		this.pricePerUnits = pricePerUnits;
		this.readingForConnection = readingForConnection;
	}

	public Reading() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}