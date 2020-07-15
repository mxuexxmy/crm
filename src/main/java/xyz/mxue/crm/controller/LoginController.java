package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.mxue.crm.commons.contant.ContantUtils;
import xyz.mxue.crm.entity.User;
import xyz.mxue.crm.service.UserService;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 登录页
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /**
     * 登录成功页面
     * @param map
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String login(ModelMap map, @RequestParam(required = true) String phone, @RequestParam(required = true) String password, HttpServletRequest request) {
        User user = userService.login(phone, password);
        if (user == null) {
            return "redirect:/";
        }
        request.getSession().setAttribute(ContantUtils.SESSION_USER, user);
        return "redirect:/index";
    }

    /**
     * 验证邮箱
     * @return
     */
    @RequestMapping(value = "forget",method = RequestMethod.GET)
    public String forgetFirst() {
        return "forgetfirst";
    }

    /**
     * 重置密码
     * @param map
     * @return
     */
    @RequestMapping(value = "reset", method = RequestMethod.POST)
    public String forgetSecond(ModelMap map) {
      return "forgetsecond";
    }

    /**
     * 退出
     * @param map
     * @param request
     * @return
     */
    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(ModelMap map, HttpServletRequest request) {
        request.getSession().invalidate();
        return "redirect:/";
    }

}
