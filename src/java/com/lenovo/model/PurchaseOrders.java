package com.lenovo.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "purchase_orders")
public class PurchaseOrders implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "po_no")
    private long PONo;
 
    @Column(name = "po_date")
    private String PODate;
 
    @Column(name = "po_quantity")
    private long POQty;

    public long getPONo() {
        return PONo;
    }

    public void setPONo(long PONo) {
        this.PONo = PONo;
    }

    public String getPODate() {
        return PODate;
    }

    public void setPODate(String PODate) {
        this.PODate = PODate;
    }

    public long getPOQty() {
        return POQty;
    }

    public void setPOQty(long POQty) {
        this.POQty = POQty;
    }
    
    
    
}
