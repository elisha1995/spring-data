package com.data.springdata.repository;

import com.data.springdata.model.Hospitalization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HospitalizationRepository extends MongoRepository<Hospitalization, String> {
}
