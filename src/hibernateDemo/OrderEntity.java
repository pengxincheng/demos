package hibernateDemo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by pxc on 2017/8/21.
 * 测试索引
 */
@Entity
@Table(name = "tab_order")
public class OrderEntity {

    private String id;
    private String orderSn;
    private String name;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "classesGenerator")
    @GenericGenerator(name = "classesGenerator", strategy = "uuid")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "order_sn")
    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
