package app.controller;

import app.dao.UserDao;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/people")
public class UserController {

    private final UserDao userDao;

    @Autowired
    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping()
    public String mainPage(Model model) {
        model.addAttribute("people", userDao.getUsers());
        return "people/all";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userDao.getOne(id));
        return "/people/person";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", userDao.getOne(id));
        return "people/edit";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("person", new User());
        return "people/new";
    }

    @PostMapping
    public String create(@ModelAttribute("person") User user) {

        try {
            System.out.println(user.toString());
            userDao.save(user);
        } catch (Exception e) {
            System.out.println("failed");
        }
        return "redirect:/people";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") User user,
                         @PathVariable("id")int id) {
        try {
            userDao.update(id, user.getName(), user.getAge(), user.getEmail());
        } catch (Exception e) {
            System.out.println("failed");
        }
        return "redirect:/people";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id")int id) {
        userDao.delete(id);
        return "redirect:/people";
    }

}
