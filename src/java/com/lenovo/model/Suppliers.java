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
@Table(name = "suppliers")
public class Suppliers implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "supplier_ref")
    private long SupplierRef;
 
    @Column(name = "supplier_name")
    private String OrderDate;
    
    @Column(name = "supplier_address")
    private String SupplierAddress;
    
    @Column(name = "supplier_tel")
    private String SupplierTel;
    
    @OneToMany(fetch=FetchType.LAZY, targetEntity=Parts.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "Psupplier_ref", referencedColumnName="supplier_ref")
    private Set parts;

    public long getSupplierRef() {
        return SupplierRef;
    }

    public void setSupplierRef(long SupplierRef) {
        this.SupplierRef = SupplierRef;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String OrderDate) {
        this.OrderDate = OrderDate;
    }

    public String getSupplierAddress() {
        return SupplierAddress;
    }

    public void setSupplierAddress(String SupplierAddress) {
        this.SupplierAddress = SupplierAddress;
    }

    public String getSupplierTel() {
        return SupplierTel;
    }

    public void setSupplierTel(String SupplierTel) {
        this.SupplierTel = SupplierTel;
    }

    public Set getParts() {
        return parts;
    }

    public void setParts(Set parts) {
        this.parts = parts;
    }
    
    
    
}
