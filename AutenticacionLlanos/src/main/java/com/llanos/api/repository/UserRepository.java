package com.llanos.api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.llanos.api.model.UserContractor;

@Repository
public interface UserRepository extends MongoRepository<UserContractor, Integer> {

	List<UserContractor> findByEmail(String email);

}
