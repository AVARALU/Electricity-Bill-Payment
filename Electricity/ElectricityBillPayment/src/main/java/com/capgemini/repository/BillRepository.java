package com.capgemini.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {

	@Query(value = "select o from Bill o where  o.billForReading.readingForConnection.consumerNumber=?1")
	public Optional<Bill> viewBillByConsumerNumber(Long consumerNumber);

	@Query(value = "select o from Bill o where  o.billForReading.readingForConnection.customerConnection.mobileNumber=?1")
	public Optional<Bill> viewBillByMobileNumber(String mobileNumber);

	@Query(value = "SELECT b from Bill b where b.billForReading.readingForConnection.customerConnection.email=?1")
	public Optional<Bill> viewBillByEmail(String email);

	@Query(value = "select b from Bill b where b.billDate>=?1 AND b.billDate<=?2")
	List<Bill> findAllByBillDateBetween(Date from, Date to);
}
