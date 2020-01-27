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
@Table(name = "part_types")
public class PartTypes implements Serializable {
    @Id
    @GeneratedValue
    @Column(name = "parttype_code")
    private long ParttypeCode;
 
    @Column(name = "parttype_description")
    private String ParttypeDescription;
 
    @OneToMany(fetch=FetchType.LAZY, targetEntity=Parts.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "Opart_typecode", referencedColumnName="parttype_code")
    private Set parts;

    public long getParttypeCode() {
        return ParttypeCode;
    }

    public void setParttypeCode(long ParttypeCode) {
        this.ParttypeCode = ParttypeCode;
    }

    public String getParttypeDescription() {
        return ParttypeDescription;
    }

    public void setParttypeDescription(String ParttypeDescription) {
        this.ParttypeDescription = ParttypeDescription;
    }

    public Set getParts() {
        return parts;
    }

    public void setParts(Set parts) {
        this.parts = parts;
    }
    
    
}
