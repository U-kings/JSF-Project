package com.lenovo.model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customers implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "customer_ref")
    private long CustomerRef;
 
    @Column(name = "customer_firstname")
    private String CustomerFirstname;
 
    @Column(name = "customer_lastname")
    private String CustomerLastname;
    
    @Column(name = "customer_address")
    private String CustomerAddress;
    
    @OneToMany(fetch=FetchType.LAZY, targetEntity=Orders.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "Ocustomer_ref", referencedColumnName="customer_ref")
    private Set orders;

    public long getCustomerRef() {
        return CustomerRef;
    }

    public void setCustomerRef(long CustomerRef) {
        this.CustomerRef = CustomerRef;
    }

    public String getCustomerFirstname() {
        return CustomerFirstname;
    }

    public void setCustomerFirstname(String CustomerFirstname) {
        this.CustomerFirstname = CustomerFirstname;
    }

    public String getCustomerLastname() {
        return CustomerLastname;
    }

    public void setCustomerLastname(String CustomerLastname) {
        this.CustomerLastname = CustomerLastname;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String CustomerAddress) {
        this.CustomerAddress = CustomerAddress;
    }

    public Set getOrders() {
        return orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }
    
    
}
