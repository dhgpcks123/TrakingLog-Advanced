package hello.trakinglogadvanced.trace.strategy;

import hello.trakinglogadvanced.trace.strategy.code.strategy.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV2Test {

    @Test
    void strategyV1(){
        ContextV2 context = new ContextV2();
        context.execute(new StrategyLogic1());
        context.execute(new StrategyLogic2());
    }

    //익명 내부 클래스
    @Test
    void strategyV2(){
        ContextV2 context = new ContextV2();
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 1 실행");
            }
        });
        context.execute(new Strategy() {
            @Override
            public void call() {
                log.info("비즈니스 로직 2 실행");
            }
        });
    }
    //람다
    @Test
    void strategyV3(){
        new ContextV2().execute(()->log.info("비즈니스 로직 1 실행"));
        new ContextV2().execute(()->{
            log.info("비즈니스 로직 2 실행");
        });
    }
}
