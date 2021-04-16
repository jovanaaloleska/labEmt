package lab.emt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@ServletComponentScan
@SpringBootApplication
public class EmtApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmtApplication.class, args);
    }


}
