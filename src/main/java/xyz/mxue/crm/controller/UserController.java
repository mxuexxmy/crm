package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.entity.User;
import xyz.mxue.crm.model.CRUDResult;
import xyz.mxue.crm.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 基本信息
     * @return
     */
    @RequestMapping(value = "profile", method = RequestMethod.GET)
    private String userProfile() {
        return "user/profile";
    }

    @RequestMapping(value = "updatePassword", method = RequestMethod.GET)
    public String updatePassword() {
        return "user/password";
    }

    @RequestMapping(value = "saveUpdatePassword", method = RequestMethod.POST)
    @ResponseBody
    public CRUDResult saveUpdatePassword(User user) {
        CRUDResult result = new CRUDResult();
        result.setSuccess(0);
        userService.saveUpdatePassword(user);
        result.setMsg("修改密码成功");
        return result;
    }
}
