package demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lh on 2016/11/17.
 */
@RestController
public class RibbonController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Integer a, Integer b) {
        return restTemplate.getForEntity("http://ADD-SERVICE-DEMO/add?a="+a+"&b=" + b, String.class).getBody();
    }

}
