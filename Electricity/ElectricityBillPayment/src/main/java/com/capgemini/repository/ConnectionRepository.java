package com.capgemini.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.Connection;

@Repository
public interface ConnectionRepository extends JpaRepository<Connection, Long> {
	@Query(value = "select o from Connection o where o.consumerNumber=?1")
	public Optional<Connection> findByConsumerNumber(Long consumerNumber);

	@Query(value = "select o from Connection o where o.connectionStatus='ACTIVE' and o.connectionAddress.village=?1")
	public List<Connection> getActiveConnectionsByVillage(String village);

	@Query(value = "select o from Connection o where o.connectionStatus='INACTIVE' and o.connectionAddress.village=?1")
	public List<Connection> getInActiveConnectionsByVillage(String village);

	@Query(value = "select o from Connection o where o.connectionStatus='ACTIVE' and o.connectionAddress.taluk=?1")
	public List<Connection> getActiveConnectionsByTaluk(String taluk);

	@Query(value = "select o from Connection o where o.connectionStatus='INACTIVE' and o.connectionAddress.taluk=?1")
	public List<Connection> getInActiveConnectionsByTaluk(String taluk);

	@Query(value = "select o from Connection o where o.connectionStatus='ACTIVE' and o.connectionAddress.district=?1")
	public List<Connection> getActiveConnectionsByDistrict(String district);

	@Query(value = "select o from Connection o where o.connectionStatus='INACTIVE' and o.connectionAddress.district=?1")
	public List<Connection> getInActiveConnectionsByDistrict(String district);

	@Query(value = "select o from Connection o where o.connectionStatus='ACTIVE' and o.connectionAddress.pincode=?1")
	public List<Connection> getActiveConnectionsByPincode(String pincode);

	@Query(value = "select o from Connection o where o.connectionStatus='INACTIVE' and o.connectionAddress.pincode=?1")
	public List<Connection> getInActiveConnectionsByPincode(String pincode);

	
}
