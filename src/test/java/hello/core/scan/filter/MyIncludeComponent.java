package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)  
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {
}

//MyIncludeComponent에 붙은것은 컴포넌트 스캔에 추가