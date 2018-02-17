import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestControllers.class)
public class TestControllers {

    @Test
    public void testTwoControllers(){

        String url = "http://localhost";
        int controllerOnePort = 8081;
        String controllerOneAddress = String.format("%s:%s/rest", url, controllerOnePort);

        int controllerTwoPort = 8082;
        String controllerTwoAddress = String.format("%s:%s/rest", url, controllerTwoPort);

        RestTemplate restTemplate = new RestTemplate();
        String result = "empty";

        try {
            result = restTemplate.getForObject(controllerOneAddress, String.class);
        } catch (Exception e) {
            System.out.print(e.toString());
        }

        Assert.assertEquals("Expecting response from Controller Two", "Hello From Controller Two!", result);

    }

}
