package labshopmonolith.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import labshopmonolith.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value="/orders")
@Transactional
public class OrderController {

    @Autowired
    OrderRepository orderRepository;

    @RequestMapping(
        value = "orders/{id}/order",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8"
    )
    public Order order(
        @PathVariable(value = "id") Long id,
        @RequestBody OrderCommand orderCommand,
        HttpServletRequest request,
        HttpServletResponse response
    ) throws Exception {
        System.out.println("##### /order/order  called #####");
        Optional<Order> optionalOrder = orderRepository.findById(id);

        optionalOrder.orElseThrow(() -> new Exception("No Entity Found"));
        Order order = optionalOrder.get();
        order.order(orderCommand);

        orderRepository.save(order);
        return order;
    }
}
