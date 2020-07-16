package xyz.mxue.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import xyz.mxue.crm.entity.User;
import xyz.mxue.crm.mapper.UserMapper;
import xyz.mxue.crm.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String phone, String password) {
        User user = userMapper.login(phone);
        if (user != null) {
            if (user.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
                return user;
            }
            return null;
        }
        return null;
    }

    @Override
    public User findEmail(String email) {
        return userMapper.findEmail(email);
    }

    @Override
    public Boolean saveResetPassword(String email,  String newPassword) {
        newPassword = DigestUtils.md5DigestAsHex(newPassword.getBytes());
        userMapper.resetPassword(email, newPassword);
        return null;
    }

    @Override
    public void saveUpdatePassword(User user) {
        int id = Math.toIntExact(user.getId());
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        userMapper.saveUpdatePassword(id, password);
    }
}
