package edu.aluismarte.barcamp.repository;

import edu.aluismarte.barcamp.domain.security.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by aluis on 9/30/19.
 */
@Repository
public interface ParamRepository extends JpaRepository<Param, Long> {

    Param findByCode(int code);
}
