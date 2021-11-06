package hello.trakinglogadvanced.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//Controller + ResponseBody
@RequiredArgsConstructor
public class OrderControllerV0 {

    private final OrderServiceV0 orderService;

    @GetMapping("/v0/request")
    public String request(String itemId){
        /* URL 요청 : http://localhost:8080/V0/request?itemId=hello
        * 여기서 V0/request 로 @GetMapping 했지만,
        * 메시지 컨버터가 ?itemId=hello 인걸 확인하고 컨트롤러를 살핀다.
        * 어 itemId로 받고 있네? 그러면 담아주는 방식으로 쓸 수 있다.
         */
        orderService.orderItem(itemId);
        return "ok";
    }
}
