package labshopmonolith.external;

import java.util.Date;
import lombok.Data;

@Data
public class Order {

    private Long id;
    private String productId;
    private Integer qty;
    private String customerId;
    private Double amount;
}
