package app;

import app.webConfig.SpringConfig;
import app.model.User;
import app.service.*;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        UserService userService = context.getBean(UserService.class);

//        UserService userService = new UserServiceImpl();
//        User user = new User("Jame", 34, "lanister@mail.ru");
//        userService.save(user);

        System.out.println(userService.getUserByName("new user"));
//        System.out.println(userService.getOne(15));
//        userService.save(user);

//        userService.dropTable();                      //1
//        userService.createTable();                    //2

//        userService.save("tom", 14, "tom@mail.ru");   //3
//        userService.save("Bob", 25, "tom@mail.ru");
//        userService.save("Sergey", 30, "Serj@mail.ru");
//
//        userService.update(2, "Update1", 33, "date@mail.ru"); //4
//
//        userService.delete(1);                        ///7
//
//        userService.cleanTable();                       // 8
//
//        System.out.println(userService.getOne(1));   // 5

//        List<User> list = userService.getUsers();     //6
//        list.forEach(System.out::println);
    }
}
