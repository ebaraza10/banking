package com.elijah.task.interfaces;

/**
 *
 * @author elijah
 */

import java.util.UUID;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.elijah.task.models.User;


public interface UserRepository extends MongoRepository<User, String> {
  List<User> findById(UUID id);
  List<User> findAll();
  User findByFirstName(String firstName);
}

