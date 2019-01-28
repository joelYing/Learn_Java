package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

/**
 * @PackageName controller
 * @Author joel
 * @Date 2019/1/28 16:50
 **/

@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    // 跳转到添加用户信息页

    @RequestMapping(value = "/savePage")
    public String savePage() {
        return "view/save";
    }

    // 保存用户
    @RequestMapping(value = "/save", method = RequestMethod.POST)

    public String save(@RequestParam String username, @RequestParam String password, Model model) {
        userService.save(username, password);
        model.addAttribute("message", "保存数据成功");
        return "view/success";
    }
}
