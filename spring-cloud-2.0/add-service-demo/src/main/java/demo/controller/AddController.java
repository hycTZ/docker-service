package demo.controller;

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

    @Value("${my.info.str}")
    private String infoStr;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Map<String, Object> add(Integer a, Integer b) {
        System.out.println("端口为8100的实例被调用");
        System.out.println("infoStr : " + infoStr);
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", 200);
        returnMap.put("msg", "操作成功");
        returnMap.put("result", a + b);
        return returnMap;
    }

}
