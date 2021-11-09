package hello.trakinglogadvanced.trace.strategy.code.template;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class TemplateCallbackTest {

//    template callback pattern
    @Test
    void callbackV1(){
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(new Callback(){
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        template.execute(new Callback(){
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }

    // lamda
    @Test
    void callbackV2(){
        TimeLogTemplate template = new TimeLogTemplate();
        template.execute(() -> log.info("비즈니스 로직 1 실행"));
        template.execute(() -> log.info("비즈니스 로직 2 실행"));
    }
}
