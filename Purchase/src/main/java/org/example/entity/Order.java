package org.example.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.dto.forbackend.OrderSaveRequest;

import java.time.LocalDate;



@Table(name = "orders")
@Entity
@Getter
@RequiredArgsConstructor
public class Order {

    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long orderId;

    @Column(name = "product_id")
    private Long productId ;

    @Column(name = "order_price")
    private int orderPrice ;

    @Column(name = "consumer_email")
    private String consumerEmail ;

    @Column(name = "seller_email")
    private String sellerEmail ;

    @Column(name = "order_at")
    private LocalDate orderAt;

    @Builder
    public Order (Long productId, int orderPrice, String consumerEmail, String sellerEmail, LocalDate orderAt)
    {
        this.productId = productId ;
        this.orderPrice=orderPrice ;
        this.consumerEmail = consumerEmail;
        this.sellerEmail = sellerEmail;
        this.orderAt= orderAt ;
    }

    public static Order ToOrder(OrderSaveRequest orderSaveRequest)
    {
        return Order.builder()
                .productId(orderSaveRequest.getProduct_id())
                .orderPrice(orderSaveRequest.getProduct_point())
                .consumerEmail(orderSaveRequest.getConsumer())
                .sellerEmail(orderSaveRequest.getSeller())
                .orderAt(orderSaveRequest.getPurchase_at())
                .build() ;
    }

}



