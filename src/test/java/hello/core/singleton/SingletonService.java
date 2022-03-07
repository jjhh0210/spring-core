package hello.core.singleton;

public class SingletonService {
    
    //1. static 영역에 객체를 딱 1개만 생성해둔다
    private static final SingletonService instance = new SingletonService();
    
    //2. public으로 열어서 객체 인스턴스가 필요하면 오직 이 static 메서드를 통해서만 조회할 수 있다.
    //이 메서드를 호출하면 항상 같은 Instance를 반환
    public static SingletonService getInstance() {
        return instance;
    }
    //3. 생성자를 private으로 막아서 혹시라도 외부에서 new 키워드로 객체 인스턴스가 생성되는 것을 막음
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
