package com.springboottutorials.springboottutorials;

import com.springboottutorials.springboottutorials.entity.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringBootTutorialsApplication
{

    public static void main(String[] args)
    {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(SpringBootTutorialsApplication.class, args);

//        UserRepository repository = applicationContext.getBean(UserRepository.class);

//			User user = new User();
//			user.setName("Dayyan Ali");
//			user.setCity("Karachi");
//			user.setJobStatus("Java Programmer, Unemployed");
//
//			// Saving single User
//			repository.save(user);

        User user1 = new User();
        user1.setName("Kamlesh");
        user1.setCity("Kolkatta");
        user1.setJobStatus("Potty Expert");

        User user2 = new User();
        user2.setName("Jeremy");
        user2.setCity("Seattle");
        user2.setJobStatus("suicide master");

        // Saving multiple users in one go
//        List<User> userList = List.of(user1, user2);
//        List<User> resultIter = repository.saveAll(userList);
//        for (User u : resultIter)
//        {
//            System.out.println(u);
//        }

        // Updating existing user
//        Optional<User> optional = repository.findById(3L);
//        if (optional.isPresent())
//        {
//            User user = optional.get();
//            user.setJobStatus("Suicider Man");
//            User resUser = repository.save(user);
//            System.out.println(resUser);
//        }

        // Deleting from database
//        repository.delete(User entity);
//        repository.deleteById(3L);

//        List<User> usersByNativeQuery = repository.getUsersByNativeQuery();
//        for (User user : usersByNativeQuery)
//            System.out.println(user);

    }

}
