package hello.core.web;

import hello.core.common.MyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor    //생성자가 한개면 의존관계 자동주입(Autowired)
public class LogDemoController {

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;    //myLogger를 찾을 수 있는, dependency lookup 할 수 있는 애가 주입됨

    @RequestMapping("log-demo")
    @ResponseBody   //렌더링 없이 문자 그대로 내보냄
    public String logDemo(HttpServletRequest request) { //자바에서 제공하는 표준 서블릿 규약에 의한 http request 정보를 받음(고객요청정보)
        String requestURL = request.getRequestURL().toString();
        System.out.println("myLogger = " + myLogger.getClass());
        myLogger.setRequestURL(requestURL);

        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}
