package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RefreshScope
public class RandomController {

    private static final Logger logger = LoggerFactory.getLogger(RandomController.class);

    @RequestMapping(value = "/random", method = RequestMethod.GET)
    public Integer random() {
        logger.info(" >>> random");
        Random random = new Random();
        return random.nextInt(10);
    }

}
