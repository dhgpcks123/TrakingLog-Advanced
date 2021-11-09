package hello.trakinglogadvanced.app.v5;


import hello.trakinglogadvanced.trace.callback.TraceCallback;
import hello.trakinglogadvanced.trace.callback.TraceTemplate;
import hello.trakinglogadvanced.trace.logtrace.LogTrace;
import hello.trakinglogadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceV5 {

    private final OrderRepositoryV5 orderRepository;
    private final TraceTemplate template;

    public OrderServiceV5(OrderRepositoryV5 orderRepository, LogTrace trace) {
        this.orderRepository = orderRepository;
        this.template = new TraceTemplate(trace);
    }

    public void orderItem(String itemId) {

        template.execute("OrderService.orderItem()", () -> {
            orderRepository.save(itemId);
            return null;
        });
    }
}
