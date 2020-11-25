package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.clear();
      carService.clear();

      Car car1 = new Car("Nissan GTR");
      Car car2 = new Car("BMW X1");
      Car car3 = new Car("Toyota Camry");
      Car car4 = new Car("Lada Vesta");

      carService.add(car1);
      carService.add(car2);
      carService.add(car3);
      carService.add(car4);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));


      userService.getAsList().forEach(System.out::println);
      carService.getAsList().forEach(System.out::println);

      context.close();
   }
}
