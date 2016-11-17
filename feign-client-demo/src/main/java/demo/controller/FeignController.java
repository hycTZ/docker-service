package demo.controller;

import demo.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lh on 2016/11/17.
 */
@RestController
public class FeignController {

    @Autowired
    private AddService addService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(Integer a, Integer b) {
        return addService.add(a, b);
    }

}
