package com.iiitb.poshak.user;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findAllByEmailIdAndPassword(String emailId, String password);
    User findByEmailId(String email);

}
