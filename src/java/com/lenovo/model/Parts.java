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
@Table(name = "parts")
public class Parts implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "part_no")
    private long PartNo;
 
    @Column(name = "part_name")
    private String PartName;
 
    @Column(name = "part_unit")
    private long PartUnit;
    
    @Column(name = "stock_level")
    private long StockLevel;
    
    @Column(name = "minstock_level")
    private long MinStockLevel;
    
    @Column(name = "cost_price")
    private long CostPrice;
    
    @Column(name = "sales_prices")
    private long SalesPrices;
    
    @Column(name = "location")
    private String Loaction;
    
    @Column(name = "part_notes")
    private String PartsNotes;
    
    @OneToMany(fetch=FetchType.LAZY, targetEntity=Orders.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "Opart_no", referencedColumnName="part_no")
    private Set orders;

    public long getPartNo() {
        return PartNo;
    }

    public void setPartNo(long PartNo) {
        this.PartNo = PartNo;
    }

    public String getPartName() {
        return PartName;
    }

    public void setPartName(String PartName) {
        this.PartName = PartName;
    }

    public long getPartUnit() {
        return PartUnit;
    }

    public void setPartUnit(long PartUnit) {
        this.PartUnit = PartUnit;
    }

    public long getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(long StockLevel) {
        this.StockLevel = StockLevel;
    }

    public long getMinStockLevel() {
        return MinStockLevel;
    }

    public void setMinStockLevel(long MinStockLevel) {
        this.MinStockLevel = MinStockLevel;
    }

    public long getCostPrice() {
        return CostPrice;
    }

    public void setCostPrice(long CostPrice) {
        this.CostPrice = CostPrice;
    }

    public long getSalesPrices() {
        return SalesPrices;
    }

    public void setSalesPrices(long SalesPrices) {
        this.SalesPrices = SalesPrices;
    }

    public String getLoaction() {
        return Loaction;
    }

    public void setLoaction(String Loaction) {
        this.Loaction = Loaction;
    }

    public String getPartsNotes() {
        return PartsNotes;
    }

    public void setPartsNotes(String PartsNotes) {
        this.PartsNotes = PartsNotes;
    }

    public Set getOrders() {
        return orders;
    }

    public void setOrders(Set orders) {
        this.orders = orders;
    }
    
    
    
}
