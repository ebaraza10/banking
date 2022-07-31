package com.elijah.task.interfaces;

/**
 *
 * @author elijah
 */
import java.util.Date;
import com.elijah.task.models.Transaction;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class CustomTransactionFilterRepository<T, ID> implements CustomFilter<T, ID> {

  @Autowired
  private MongoTemplate mongoTemplate;



    public List < Transaction > findByDates(String startDate, String endDate) throws ParseException {
        List<Transaction> transactions= this.findAll();
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
                        
                        return (date1Fits1 == true || date1Fits1_2  == true) && (date2Fits2 == true || date2Fits2_2  == true);
                    }
                    catch (ParseException ex) {
                        Logger.getLogger(CustomTransactionFilterRepository.class.getName()).log(Level.SEVERE, null, ex);
                        return false;
                    }
            } 
        )
            .collect(Collectors.toList());
        
        return filteredTransactions;
      }

    @Override
    public List<Transaction> findById(ID id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = mongoTemplate.findAll(Transaction.class);
        return transactions;
    }
   

}
