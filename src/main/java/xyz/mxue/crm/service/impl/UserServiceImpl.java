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
}
