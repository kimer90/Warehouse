/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Karelin
 */
@Entity
@Table(name = "facility")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Facility.findAll", query = "SELECT f FROM Facility f")
    , @NamedQuery(name = "Facility.findById", query = "SELECT f FROM Facility f WHERE f.id = :id")
    , @NamedQuery(name = "Facility.findByName", query = "SELECT f FROM Facility f WHERE f.name = :name")})
public class Facility implements Serializable, Points {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityId")
    private Collection<GoodsInFacility> goodsInFacilityCollection;
    @OneToMany(mappedBy = "facilityId")
    private Collection<ArrivalWarehouse> arrivalWarehouseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityId")
    private Collection<ConsumptionWarehouse> consumptionWarehouseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityId")
    private Collection<ArrivalFacility> arrivalFacilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facilityId")
    private Collection<ConsumptionFacility> consumptionFacilityCollection;

    public Facility() {
    }

    public Facility(Integer id) {
        this.id = id;
    }

    public Facility(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<GoodsInFacility> getGoodsInFacilityCollection() {
        return goodsInFacilityCollection;
    }

    public void setGoodsInFacilityCollection(Collection<GoodsInFacility> goodsInFacilityCollection) {
        this.goodsInFacilityCollection = goodsInFacilityCollection;
    }

    @XmlTransient
    public Collection<ArrivalWarehouse> getArrivalWarehouseCollection() {
        return arrivalWarehouseCollection;
    }

    public void setArrivalWarehouseCollection(Collection<ArrivalWarehouse> arrivalWarehouseCollection) {
        this.arrivalWarehouseCollection = arrivalWarehouseCollection;
    }

    @XmlTransient
    public Collection<ConsumptionWarehouse> getConsumptionWarehouseCollection() {
        return consumptionWarehouseCollection;
    }

    public void setConsumptionWarehouseCollection(Collection<ConsumptionWarehouse> consumptionWarehouseCollection) {
        this.consumptionWarehouseCollection = consumptionWarehouseCollection;
    }

    @XmlTransient
    public Collection<ArrivalFacility> getArrivalFacilityCollection() {
        return arrivalFacilityCollection;
    }

    public void setArrivalFacilityCollection(Collection<ArrivalFacility> arrivalFacilityCollection) {
        this.arrivalFacilityCollection = arrivalFacilityCollection;
    }

    @XmlTransient
    public Collection<ConsumptionFacility> getConsumptionFacilityCollection() {
        return consumptionFacilityCollection;
    }

    public void setConsumptionFacilityCollection(Collection<ConsumptionFacility> consumptionFacilityCollection) {
        this.consumptionFacilityCollection = consumptionFacilityCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Facility)) {
            return false;
        }
        Facility other = (Facility) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Facility[ id=" + id + " ]";
    }
    
}
