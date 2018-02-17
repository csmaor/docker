import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;


@RestController
@EnableAutoConfiguration
public class Runner {

    @RequestMapping("/rest")
    String home() {
        return "Hello From Controller Two!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }
}
