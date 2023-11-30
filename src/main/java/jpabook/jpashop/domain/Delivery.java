package jpabook.jpashop.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import static javax.persistence.FetchType.LAZY;

@Entity
public class Delivery extends BaseEntity{

    @Id @GeneratedValue
    private Long id;

    private String city;
    private String street;
    private String zipcode;
    private DeliveryStatus status;

    @OneToOne(mappedBy = "delivery", fetch = LAZY) // 어떤 주문에 의해 배송이 되는 지 알고싶어
    private Order order;

}
