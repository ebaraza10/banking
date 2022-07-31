package com.elijah.task.interfaces;

/**
 *
 * @author elijah
 */

import java.util.UUID;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elijah.task.models.Transaction;


public interface TransactionRepository extends MongoRepository<Transaction, String> {
  List<Transaction> findById(UUID id);
  List<Transaction> findByDirection(String direction);
  List<Transaction> findByDate(String date);
  List<Transaction> findAll();
  
}

