package ru.bkiyakov.myexpenses.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ru.bkiyakov.myexpenses.models.User;

@Repository
public interface UserRepository extends MongoRepository <User, String> {
    User getUserByUserId(String userId);
}
