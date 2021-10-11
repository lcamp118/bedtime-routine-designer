package com.lynelleherrera.bedtimeroutinedesigner.Controllers.Service;

import com.lynelleherrera.bedtimeroutinedesigner.Models.MyUser;

public interface UserContext {

    MyUser getCurrentUser();
    void setCurrentUser(MyUser myUser);


}
