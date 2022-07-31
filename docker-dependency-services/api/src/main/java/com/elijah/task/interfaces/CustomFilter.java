package com.elijah.task.interfaces;

/**
 *
 * @author elijah
 */
import com.elijah.task.models.Transaction;
import java.util.List;
import java.util.Optional;


public interface CustomFilter<T, ID> {

//  Optional<T> findByDates(String startDate, String endDate);
  List<Transaction> findById(ID id);
  List<Transaction> findAll();
//  <S extends T> S save(S entity);
  

}

