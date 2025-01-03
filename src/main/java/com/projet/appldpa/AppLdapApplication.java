package com.projet.appcnss;

import com.projet.appcnss.entities.App;
import com.projet.appcnss.repositories.AppRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppLdapApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppLdapApplication.class, args);
    }
//   @Bean
//    CommandLineRunner commandLineRunner(AppRepository appRepo){
//        return args->{
//            appRepo.save(new App(null,"App1","www.google.com",true));
//            appRepo.save(new App(null,"App2","www.youtube.com",false));
//            appRepo.save(new App(null,"App3","www.instagram.com",true));
//            appRepo.save(new App(null,"App4","www.facebook.com",false));
//            appRepo.save(new App(null,"App5","www.linkden.com",false));
//       appRepo.findAll().forEach(p->{
//           System.out.println(p.getTitle());
//             });
//        };
//  }
}
