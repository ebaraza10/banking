/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.elijah.task.utils;

/**
 *
 * @author elijah
 */
import java.util.Date;
import com.elijah.task.models.Transaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public abstract class CustomFilter {
    
        public static List < Transaction > findByDates(String startDate, String endDate, List<Transaction> transactions) throws ParseException {
        
        Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        
        List < Transaction > filteredTransactions = (List < Transaction >) transactions.stream()
                .filter(transaction -> {
                    try {
                        Date currStart = new SimpleDateFormat("yyyy-MM-dd").parse(transaction.getDate());
                        Date currEnd = new SimpleDateFormat("yyyy-MM-dd").parse(transaction.getDate());
                        boolean date1Fits1 = dateStart.after(currStart);
                        boolean date2Fits2 = dateEnd.after(currEnd);
                        
                        boolean date1Fits1_2 = dateStart.equals(currStart);
                        boolean date2Fits2_2 = dateEnd.equals(currEnd);
                        
//                        boolean belongsToUser = userId.equals(transaction.getSender().getId().toString()) || userId.equals(transaction.getReceipient().getId().toString());
                        
                        return (date1Fits1 == true || date1Fits1_2  == true) && (date2Fits2 == true || date2Fits2_2  == true);
                    }
                    catch (ParseException ex) {
                        return false;
                    }
            } 
        )
            .collect(Collectors.toList());
        
        return filteredTransactions;
      }
        
   public static List < Transaction > findUserTransByDates(String userId, String startDate, String endDate, List<Transaction> transactions) throws ParseException {
        System.out.println("transactions.length="+Integer.toString(transactions.size()));
        Date dateStart = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date dateEnd = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        
        final List < Transaction > filteredTransactions2 = new ArrayList<Transaction>();
        List < Transaction > filteredTransactions = (List < Transaction >) transactions.stream().filter(transaction -> {
                    try {
                        Date transStartDate = new SimpleDateFormat("yyyy-MM-dd").parse(transaction.getDate());
                        Date transEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(transaction.getDate());
                        boolean date1Fits1 = transStartDate.after(dateStart);
                        boolean date1Fits1_2 = dateStart.equals(transStartDate);
                        
                        boolean date2Fits2 = dateEnd.after(transEndDate);
                        boolean date2Fits2_2 = dateEnd.equals(transEndDate);
                        
                        boolean belongsToUser = userId.equals(transaction.getSender().getId().toString()) || userId.equals(transaction.getReceipient().getId().toString());
                        if((date1Fits1 == true || date1Fits1_2  == true) && (date2Fits2 == true || date2Fits2_2  == true) && (belongsToUser == true)){
                            filteredTransactions2.add(transaction);
                            System.out.println("belongsToUser2="+Boolean.toString(belongsToUser)+"transaction="+Float.toString(transaction.getAmount()));
                        
                        }
                    }
                    catch (Exception ex) {
                        return false;
                    }
            return false;
                    
            }
        ).collect(Collectors.toList());
        
        return filteredTransactions2;
      }
    
}
