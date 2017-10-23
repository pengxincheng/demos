package hibernateDemo;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.search.annotations.*;
import org.hibernate.search.annotations.Index;

import javax.persistence.*;

/**
 * Created by pxc on 2017/8/21.
 * 测试索引
 */
@Entity
@Table(name = "tab_order")
@Indexed
public class OrderEntity {

    private String id;
    private String orderSn;
    private String name;

    @Field(index= Index.YES, analyze= Analyze.YES, store= Store.NO)
    private String searchWord;

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

    @Column(name = "search_word")
    public String getSearchWord() {
        return searchWord;
    }

    public void setSearchWord(String searchWord) {
        this.searchWord = searchWord;
    }
}
