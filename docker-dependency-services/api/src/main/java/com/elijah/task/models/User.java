package com.elijah.task.models;

/**
 *
 * @author elijah
 */
import java.util.UUID;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.elijah.task.interfaces.LendRepo;



@Document(collection = "user")
public class User implements LendRepo {
  @Id
  private String id;

  private String firstName;
  private String lastName;
  private String profileLink;

  public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getFirstName() {
    return firstName;
}

public void setFirstName(String firstName) {
    this.firstName = firstName;
}

public String getLastName() {
    return lastName;
}

public void setLastName(String lastName) {
    this.lastName = lastName;
}




public User() {

  }
  
  public User(String firstName, String lastName, String profileLink) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.profileLink = profileLink;
  }
  
  public User(String id, String firstName, String lastName, String profileLink) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.profileLink = profileLink;
  }

    public String getProfileLink() {
        return profileLink;
    }

    public void setProfileLink(String profileLink) {
        this.profileLink = profileLink;
    }
    
    @Override
    public String toString() {
       return String.format(
           "%s %s.", this.firstName, this.lastName
       );
    }
}
