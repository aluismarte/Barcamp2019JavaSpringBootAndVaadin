package edu.aluismarte.barcamp.repository;

import edu.aluismarte.barcamp.domain.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aluis on 9/30/19.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
