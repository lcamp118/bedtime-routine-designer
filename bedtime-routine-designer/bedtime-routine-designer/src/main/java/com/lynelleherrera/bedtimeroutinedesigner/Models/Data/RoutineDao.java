package com.lynelleherrera.bedtimeroutinedesigner.Models.Data;

import com.lynelleherrera.bedtimeroutinedesigner.Models.Activity;
import org.springframework.data.repository.CrudRepository;

public interface RoutineDao extends CrudRepository<Activity, Integer> {
}
