package com.lynelleherrera.bedtimeroutinedesigner.Models.Data;

import com.lynelleherrera.bedtimeroutinedesigner.Models.MyUser;
import org.springframework.data.repository.CrudRepository;

public interface MyUserDao extends CrudRepository<MyUser, Integer> {

    MyUser findByUsername(String username);

}
