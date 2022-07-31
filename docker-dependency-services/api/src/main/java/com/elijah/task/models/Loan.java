package com.elijah.task.models;

/**
 *
 * @author elijah
 */

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.elijah.task.interfaces.LendRepo;
import com.elijah.task.utils.Enums.LoanStatus;
import com.elijah.task.utils.Enums.Channel;



@Document(collection = "loan")
public class Loan implements LendRepo {
  @Id
  protected String id;
  protected User user;
  protected Float amount;
  protected Channel channel;
  protected String currency;
  protected String date;
  protected LoanStatus status;


public Loan() {

}

public Loan(User user, LoanStatus status, Float amount,
  String currency, String date, Channel channel){
  this.user = user;
  this.status = status;
  this.amount = amount;
  this.date = date;
  this.channel = channel;
  this.currency = currency;
}

public String getId() {
  return id;
}

public void setUser(User user) {
  this.user = user;
}

public User getUser() {
  return user;
}

public void setLoanStatus(LoanStatus status) {
  this.status = status;
}

public LoanStatus getLoanStatus() {
  return status;
}

public Float getAmount() {
  return amount;
}

public void setAmount(Float amount) {
  this.amount = amount;
}

public void setChannel(Channel channel) {
  this.channel = channel;
}

public void setDate(String date) {
  this.date = date;
}

public String getDate() {
  return date;
}

public Channel getChannel() {
  return channel;
}

public String getCurrency() {
  return currency;
}

public void setCurrency(String currency) {
  this.currency = currency;
}

@Override
 public String toString() {
    return String.format(
        "%s %s via %s from %s %s on %s",
        this.getCurrency(), this.getAmount().toString(),
        this.getChannel(), this.user.getFirstName(),
        this.getDate()
    );

 }

}
