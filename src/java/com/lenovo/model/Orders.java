package com.lenovo.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "orders")
public class Orders implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "order_no")
    private long OrderNo;
 
    @Column(name = "order_date")
    private String OrderDate;

    public long getOrderNo() {
        return OrderNo;
    }

    public void setOrderNo(long OrderNo) {
        this.OrderNo = OrderNo;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    
    
}
