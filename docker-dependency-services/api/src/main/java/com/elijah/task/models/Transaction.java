package com.elijah.task.models;

/**
 *
 * @author elijah
 */

import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.elijah.task.interfaces.LendRepo;
import com.elijah.task.utils.Enums.Channel;
import com.elijah.task.utils.Enums.Direction;



@Document(collection = "transaction")
public class Transaction implements LendRepo {
  @Id
  protected String id;
  protected User sender;
  protected User receipient;
  protected Float amount;
  protected String date;
  protected String currency;
  protected Channel channel;
  protected Direction direction;
  private String senderAccountNumber;
  private String recipientAccountNumber;


public Transaction() {

}

public Transaction(User sender, User receipient, Float amount,
String date, String currency, Channel channel, Direction direction,
String senderAccountNumber, String recipientAccountNumber){
  this.sender = sender;
  this.receipient = receipient;
  this.amount = amount;
  this.date = date;
  this.currency = currency;
  this.channel = channel;
  this.direction = direction;
  this.senderAccountNumber = senderAccountNumber;
  this.recipientAccountNumber = recipientAccountNumber;
}

public String getId() {
  return id;
}

public User getSender() {
  return sender;
}

public User getReceipient() {
  return receipient;
}

public Float getAmount() {
  return amount;
}

public void setAmount(Float amount) {
  this.amount = amount;
}

public String getCurrency() {
  return currency;
}

public void setCurrency(String currency) {
  this.currency = currency;
}

public String getDate() {
  return date;
}

public void setDate(String date) {
  this.date = date;
}

public void setChannel(Channel channel) {
  this.channel = channel;
}

public Channel getChannel() {
  return channel;
}


public Direction getDirection() {
  return direction;
}

public void setDirection(Direction direction) {
  this.direction = direction;
}

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public void setSenderAccountNumber(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }

    public String getRecipientAccountNumber() {
        return recipientAccountNumber;
    }

    public void setRecipientAccountNumber(String recipientAccountNumber) {
        this.recipientAccountNumber = recipientAccountNumber;
    }



@Override
 public String toString() {
    return String.format(
        "%s %s via %s from %s %s to %s %s on %s",
        this.getCurrency(), this.getAmount().toString(),
        this.getChannel(), this.sender.getFirstName(),
        this.sender.getLastName(), this.receipient.getFirstName(),
        this.receipient.getLastName(), this.getDate()
    );

 }

}