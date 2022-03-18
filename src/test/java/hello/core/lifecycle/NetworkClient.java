package hello.core.lifecycle;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class NetworkClient {
    private String url; //접속해야 할 서버의 url

    //생성자
    public NetworkClient() {
        System.out.println("생성자 호출, url = " + url);
    }
    //setter
    public void setUrl(String url) {
        this.url = url;
    }

    //서비스 시작시 호출
    public void connect() {
        System.out.println("connect : " + url);
    }

    public void call(String message) {
        System.out.println("call : " + url + ", (message : " + message + ")");

    }

    //서비스 종료시 호출
    public void disconnect() {
        System.out.println("disconnect : "+ url);
    }

    @PostConstruct
    public void init() {
        //초기화 콜백
        //빈의 의존관계 끝나면 호출될 것
        System.out.println("NetworkClient.afterPropertiesSet"); //soutm
        connect();  
        call("초기화 연결 메세지");

    }
    @PreDestroy
    public void close() {
        //종료 콜백
        //빈이 종료되기 직전에 호출
        System.out.println("NetworkClient.destroy");
        disconnect();

    }
}
