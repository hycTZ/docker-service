package demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AddController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Map<String, Object> add(Integer a, Integer b) {
        System.out.println("端口为8100的实例被调用");
        Map<String, Object> returnMap = new HashMap<>();
        returnMap.put("code", 200);
        returnMap.put("msg", "操作成功");
        returnMap.put("result", a + b);
        return returnMap;
    }

}
