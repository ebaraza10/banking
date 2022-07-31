package com.elijah.task.controllers;

/**
 *
 * @author elijah
 */

import java.util.UUID;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Arrays;

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
import com.elijah.task.models.Loan;
import com.elijah.task.interfaces.TransactionRepository;
import com.elijah.task.interfaces.LoanRepository;
import com.elijah.task.utils.CustomResponse;
import com.elijah.task.utils.DashboardResponse;
import java.util.stream.Collectors;
        import com.elijah.task.utils.Enums.LoanStatus;
import java.util.Arrays;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class DashboardController {
    /*
    A controller to get a users dashboard(balances for loans,
    payments sent, payments recieved and total transactions)
    */

  @Autowired
  LoanRepository loanRepository;
  
  @Autowired
  TransactionRepository transactionRepository;

  @GetMapping("/dashboard")
  public DashboardResponse getDashboard(@RequestParam(required = false) String userId) {
      // The userId gets the specific user's balances
    try {
      // Get loan balance
      List<Loan> loans = new ArrayList<Loan>();

      loanRepository.findAll().forEach(loans::add);

      
      final float[] bal = {0};
      loans.forEach(loan -> {
          String loanStatus = loan.getLoanStatus().toString();
          String[] pendingArray = {
              LoanStatus.DISBURSED.toString(), LoanStatus.DEFAULTED.toString()
          };
          boolean isPending = (Arrays.toString(pendingArray).contains(loanStatus));
          if(isPending && loan.getUser().getId().toString().equals(userId)){
              bal[0] = loan.getAmount();
          }
      });
      float loanBalance = bal[0];
      System.out.println("loanBalance="+Float.toString(loanBalance));
      // End of getting the loan balance
      
      
      // Get all transactions
      List<Transaction> transactions = new ArrayList<Transaction>();

      transactionRepository.findAll().forEach(transactions::add);
      
      final float[] paymentsMade = {0};
      final float[] paymentsRecieved = {0};
      transactions.forEach(transaction -> {
          if(transaction.getSender().getId().toString().equals(userId) || 
                  transaction.getReceipient().getId().toString().equals(userId)
          ){
                if(transaction.getDirection().toString().equals("SENDING")){
                    paymentsMade[paymentsMade.length - 1] = transaction.getAmount();
                }
                else if(transaction.getDirection().toString().equals("RECEIVING")){
                    paymentsRecieved[paymentsRecieved.length - 1] = transaction.getAmount();
                }
          }
      });
      float paymentsMadeTotal = this.getTotal(paymentsMade);
      float paymentsRecievedTotal = this.getTotal(paymentsRecieved);
      float totalTransactions = paymentsMadeTotal + paymentsRecievedTotal + loanBalance;
      // End of getting all transactions
      
      
      return new DashboardResponse(
              loanBalance, paymentsMadeTotal, paymentsRecievedTotal, totalTransactions
      );
    }
    catch (Exception e) {
      return new DashboardResponse(
              0, 0, 0, 0
      );
    }
  }
  
  private float getTotal(Object obj) {
    float sum = 0;
    float[] ob = (float[]) obj;
    for (int i = 0; i < ob.length; i++) {
        sum += ob[i];
    }
    return sum;

}


}

