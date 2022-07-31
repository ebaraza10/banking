package com.elijah.task.controllers;

/**
 *
 * @author elijah
 */

import com.elijah.task.interfaces.CustomTransactionFilterRepository;
import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elijah.task.models.Transaction;
import com.elijah.task.models.User;
import com.elijah.task.utils.Enums;
import com.elijah.task.interfaces.TransactionRepository;
import com.elijah.task.utils.CustomResponse;
import com.elijah.task.utils.CustomFilter;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    /*
    Controller to get all transactions for a given user.
    */

  @Autowired
  TransactionRepository transactionRepository;
  

  @GetMapping("/transactions")
  public ResponseEntity<List<Transaction>> getAllUserTransactions(@RequestParam(required = false) String startDate, @RequestParam(required = false) String endDate, @RequestParam(required = false) String userId) {
      /*
      Get all a user's transactions: payments made and payments recieved.
      */
      
      try {
      List<Transaction> transactions = new ArrayList<Transaction>();

      if (startDate == null && endDate == null)
        transactionRepository.findAll().forEach(transactions::add);
      if (userId != null)
      CustomFilter.findUserTransByDates(
                userId, startDate, endDate, transactionRepository.findAll()
      ).forEach(transactions::add);
      else
      // Apply a custom filter that filters dates
      CustomFilter.findByDates(
              startDate, endDate, transactionRepository.findAll()
      ).forEach(transactions::add);
      
      if (transactions.isEmpty()) {
        List<Transaction> transactions2 = new ArrayList<Transaction>();
        return new ResponseEntity<>(transactions2, HttpStatus.OK);
      }

      return new ResponseEntity<>(transactions, HttpStatus.OK);
    }
    catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }
  }

}

