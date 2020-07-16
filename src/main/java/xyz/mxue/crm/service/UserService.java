package xyz.mxue.crm.service;

import org.springframework.stereotype.Service;
import xyz.mxue.crm.entity.User;

public interface UserService {

    User login(String phone, String password);

    User findEmail(String email);

    Boolean saveResetPassword(String email, String newPassword);

    void saveUpdatePassword(User user);
}
