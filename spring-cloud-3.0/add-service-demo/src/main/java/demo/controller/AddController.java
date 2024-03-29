package demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RefreshScope
public class AddController {
    private static final Logger addLogger = LoggerFactory.getLogger("addLogger");

    @Value("${my.info.str}")
    private String infoStr;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Map<String, Object> add(Integer a, Integer b) {
        System.out.println("端口为8100的实例被调用");
        System.out.println("infoStr : " + infoStr);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", 200);
        returnMap.put("msg", "操作成功");
        Integer result = a + b;
        returnMap.put("result", result);

        addLogger.info("a : " + a + ", b : " + b + ", a + b :" + result);
        return returnMap;
    }

}
