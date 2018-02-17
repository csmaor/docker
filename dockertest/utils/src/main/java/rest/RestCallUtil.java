package rest;

import org.springframework.web.client.RestTemplate;

public class RestCallUtil {

    //private static Logger logger = Logger.getLogger(RestCallUtil.class.getName());

    private static final String REST_SUCCESS_CODE = "200";

    public static RestResult safeRestCall(String urlStr) {

        String result;
        try {
            RestTemplate restTemplate = new RestTemplate();
            //logger.debugFormat("Trigger Consumer", "Triggering Task '%s'  ", finalUrl);
            result = restTemplate.getForObject(urlStr, String.class);
            //logger.debugFormat("Trigger Consumer", "Triggering Task '%s'  Result: '%s' ", finalUrl, result);
        } catch (Exception ex) {
            //logger.error(String.format("Error Triggering Task '%s' \n Error %s  ", finalUrl, ex.getMessage()));
            return RestResult.Failed;
        }

        if (REST_SUCCESS_CODE.equals(result)) {
            return RestResult.Ok;
        } else {
            return RestResult.Failed;
        }
    }


    public enum RestResult {
        Ok,
        Failed

    }
    
}



