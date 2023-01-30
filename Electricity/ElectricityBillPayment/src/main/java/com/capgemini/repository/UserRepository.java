package com.capgemini.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	Optional<User> findByUserName(String userName);

	@Query(value = "select o from users o where o.userName=?1 AND o.password=?2")
	Optional<User> findByUserNameAndPassword(String userName,String password);

	@Query(value = "select o from users o where o.userName=?1")
	Optional<User> getUserByUserName(String name);

}
