package app.controller;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class AdminController {

    private UserDao userDao;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    public AdminController(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping("/admin")
    public String mainPage(Model model) {
        model.addAttribute("people", userDao.getUsers());
        return "admin/all";
    }

    @GetMapping("admin/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userDao.getOne(id));
        return "/admin/personA";
    }

    @GetMapping("/admin/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userDao.getOne(id));
        return "admin/edit";
    }

    @GetMapping("/admin/new")
    public String newUser(Model model) {
        model.addAttribute("person", new User());
        return "admin/new";
    }

    @PostMapping("/admin")
    public String create(@ModelAttribute("person") User user) {
        userDao.setDefaultRole(user);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.saveUser(user);
        return "redirect:/admin";
    }

    @PatchMapping("/admin/{id}")
    public String update(@ModelAttribute("person") User user,
                         @PathVariable("id")int id) {
        userDao.update(id, user.getName(), user.getAge(), user.getEmail(), user.getPassword());
        return "redirect:/admin";
    }

    @DeleteMapping("/admin/{id}")
    public String delete(@PathVariable("id")int id) {
        userDao.delete(id);
        return "redirect:/admin";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "/login";
    }


}
