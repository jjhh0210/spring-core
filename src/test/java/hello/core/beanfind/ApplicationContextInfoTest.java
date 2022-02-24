package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        //스프링이 내부적으로 사용하는 기반 빈까지 모두 출력+ (AppConfig도 빈으로 등록되어 출력됨)
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = "+bean); //스트링 빈의 key(name), value(object) 출력
        }
    }  
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        //스프링 내부 빈 제외, 내가 쓰는 빈만 출력
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            //내가 등록한 빈만!
            if (beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = "+bean); //스트링 빈의 key(name), value(object) 출력
            }
        }
    }
}
