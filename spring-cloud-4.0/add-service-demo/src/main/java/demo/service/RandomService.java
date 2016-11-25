package demo.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("RANDOM-SERVICE-DEMO")
public interface RandomService {
    @RequestMapping(method = RequestMethod.GET, value = "/random")
    Integer random();
}