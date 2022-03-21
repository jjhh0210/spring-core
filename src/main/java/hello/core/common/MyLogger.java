package hello.core.common;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {
    //로그 출력을 위한 클래스
    private String uuid;
    private String requestURL;

    public void setRequestURL(String requestURL) {
        this.requestURL = requestURL;
    }

    public void log(String msg) {
        System.out.println("["+uuid+"]" + "["+requestURL+"]"+msg);
    }

    @PostConstruct
    public void init() {
        uuid = UUID.randomUUID().toString();    //절대 겹치지 않는 글로벌하게 유니크한 uuid 하나 생성
        System.out.println("["+uuid+"]request scope bean create: "+this);

    }

    @PreDestroy
    public void close() {
        //고객요청이 빠져나가면 close 호출되며 빈 소멸
        System.out.println("["+uuid+"]request scope bean close: "+this);
    }

}
