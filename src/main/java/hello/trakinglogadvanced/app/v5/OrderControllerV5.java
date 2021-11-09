package hello.trakinglogadvanced.app.v5;


import hello.trakinglogadvanced.trace.callback.TraceCallback;
import hello.trakinglogadvanced.trace.callback.TraceTemplate;
import hello.trakinglogadvanced.trace.logtrace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OrderControllerV5 {

    private final OrderServiceV5 orderService;
    private final LogTrace trace;

//    @Autowired
//    public OrderControllerV5(OrderServiceV5 orderService, LogTrace trace) {
//        this.orderService = orderService;
//        this.template = new TraceTemplate(trace);
//    }

    @GetMapping("/v5/request")
    public String request(String itemId) {
        TraceTemplate template = new TraceTemplate(trace);
        return template.execute("OrderController.request()", new TraceCallback<>() {
            @Override
            public String call() {
                orderService.orderItem(itemId);
                return "ok";
            }
        });
//        return template.execute("OrderController.request()", () -> {
//            orderService.orderItem(itemId);
//            return "ok";
//        });
    }
}
