package com.iiitb.poshak.logging;

import com.iiitb.poshak.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoggingRepository extends MongoRepository<Logging, String> {
    Logging findByEmail(String emailId);
}
