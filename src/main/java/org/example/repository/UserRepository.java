package org.example.repository;

import com.scalar.db.sql.springdata.ScalarDbRepository;
import org.example.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ScalarDbRepository<User, String> {
}
