package com.lynk.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.lynk.app.dao.UserDao;
import com.lynk.app.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String getAllUser(Model model) {
        List<User> userList = userDao.getAll();

        model.addAttribute("userList", userList);

        return "userInfo";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String getUserById(
            @PathVariable("id") Integer id,
            Model model) {
        User user = userDao.getById(id);

        model.addAttribute("id", user.getId());
        model.addAttribute("name", user.getName());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("address", user.getAddress());
        model.addAttribute("phone", user.getPhone());

        return "userInfo";
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String createUser(
            String name,
            String password,
            String address,
            String phone) {
        User user = new User(null, name, password, address, phone);
        userDao.create(user);

        return "redirect:/";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.PUT)
    public String updateUser(
            @PathVariable("id") Integer id,
            String name,
            String password,
            String address,
            String phone) {
        User user = new User(id, name, password, address, phone);

        userDao.update(user);

        return "redirect:/user";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id) {
        userDao.deleteById(id);

        return "redirect:/user";
    }
}
