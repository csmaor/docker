import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


@RestController
@EnableAutoConfiguration
public class Runner {

    @RequestMapping("/rest")
    String home() {

        String url = "http://localhost";
        int controllerTwoPort = 8082;
        String controllerTwoAddress = String.format("%s:%s/rest", url, controllerTwoPort);

        String result = "Empty Result From Controller One";
        try {
            RestTemplate restTemplate = new RestTemplate();
            System.out.print("Redirecting to controller two");
            result = restTemplate.getForObject(controllerTwoAddress, String.class);
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        return result;

        //return "Hello From Controller One!";
    }

    public static void main(String[] args) {
        SpringApplication.run(Runner.class, args);
    }
}
