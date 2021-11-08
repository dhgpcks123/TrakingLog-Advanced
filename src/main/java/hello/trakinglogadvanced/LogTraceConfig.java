package hello.trakinglogadvanced;

import hello.trakinglogadvanced.trace.logtrace.FieldLogTrace;
import hello.trakinglogadvanced.trace.logtrace.LogTrace;
import hello.trakinglogadvanced.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }
}
