package com.elijah.task.interfaces;

/**
 *
 * @author elijah
 */

import java.util.UUID;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elijah.task.models.Loan;


public interface LoanRepository extends MongoRepository<Loan, String> {
  List<Loan> findById(UUID id);
  List<Loan> findByUser(String userId);
  List<Loan> findAll();
}
