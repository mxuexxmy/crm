package xyz.mxue.crm.controller;

import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.commons.contant.ContantUtils;
import xyz.mxue.crm.commons.utils.EmailSendUtils;
import xyz.mxue.crm.entity.User;
import xyz.mxue.crm.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmailSendUtils sendUtils;

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
    public String login(ModelMap map, @RequestParam(required = true) String phone, @RequestParam(required = true) String password, HttpServletRequest request)  {
        User user = userService.login(phone, password);
        if (user == null) {
            map.addAttribute("message", "手机号或密码错误");
            return "login";
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
    public String forgetSecond(ModelMap map, String email, HttpServletRequest request) throws EmailException {
      User user = userService.findEmail(email);
      if (user == null) {
          map.addAttribute("message", "邮箱不存在");
          return "forgetfirst";
      }
      String code = randomCode();
      sendUtils.send("找回密码", String.format("【CRM系统】管理员 %s 你的验证码是：%s\n", user.getName(),code), user.getEmail());
      request.getSession().setAttribute(ContantUtils.CODE, code);
      map.addAttribute("user", user);
      return "forgetsecond";
    }

    @RequestMapping(value = "saveResetPaddword", method = RequestMethod.POST)
    public String saveResetPassword(ModelMap map, User user, String newCode, String newPassword, HttpServletRequest request) {
        if (newCode.equals(request.getSession().getAttribute("code"))){
            userService.saveResetPassword(user.getEmail(), newPassword);
            map.addAttribute("message", "重置密码成功");
            return "login";
        }
        map.addAttribute("message", "验证码错误");
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

    /**
     * 随机生成 6 位验证码
     * @return
     */
    private String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
