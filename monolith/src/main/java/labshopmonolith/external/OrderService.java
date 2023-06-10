package labshopmonolith.external;

import java.util.Date;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "monolith", url = "${api.url.monolith}")
public interface OrderService {
    @RequestMapping(method = RequestMethod.PUT, path = "/orders/{id}/order")
    public void order(
        @PathVariable("id") Long id,
        @RequestBody OrderCommand orderCommand
    );
}
