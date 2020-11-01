package com.lynelleherrera.bedtimeroutinedesigner.Models.Data;

import com.lynelleherrera.bedtimeroutinedesigner.Models.Routine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoutineDao extends CrudRepository<Routine, Integer> {
}
