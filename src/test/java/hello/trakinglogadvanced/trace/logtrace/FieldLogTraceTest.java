package hello.trakinglogadvanced.trace.logtrace;

import hello.trakinglogadvanced.trace.TraceStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FieldLogTraceTest {

    FieldLogTrace trace = new FieldLogTrace();

    @Test
    void begin_end_level2 (){
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        TraceStatus status3 = trace.begin("hello3");
        TraceStatus status4 = trace.begin("hello4");
        trace.end(status4);
        trace.end(status3);
        trace.end(status2);
        trace.end(status1);
    }

    @Test
    void begin_exception_level2 (){
        TraceStatus status1 = trace.begin("hello1");
        TraceStatus status2 = trace.begin("hello2");
        TraceStatus status3 = trace.begin("hello3");

        trace.exception(status3, new IllegalStateException());
        trace.exception(status2, new IllegalStateException());
        trace.exception(status1, new IllegalStateException());
    }
}
