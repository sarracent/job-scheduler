package snd.com.ar.jobschedulerdeletetables;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JobSchedulerDeleteTablesApplication {

    public static void main(String[] args) {
        SpringApplication.run(JobSchedulerDeleteTablesApplication.class, args);
    }

}
