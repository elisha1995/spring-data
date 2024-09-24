package com.data.springdata.repository;

import com.data.springdata.model.Ward;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WardRepository extends MongoRepository<Ward, String> {
}
