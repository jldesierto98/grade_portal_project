package com.ltp.gradesubmission.repository;

import com.ltp.gradesubmission.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
