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
@Table(name = "goods")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goods.findAll", query = "SELECT g FROM Goods g")
    , @NamedQuery(name = "Goods.findById", query = "SELECT g FROM Goods g WHERE g.id = :id")
    , @NamedQuery(name = "Goods.findByName", query = "SELECT g FROM Goods g WHERE g.name = :name")
    , @NamedQuery(name = "Goods.findByUnit", query = "SELECT g FROM Goods g WHERE g.unit = :unit")})
public class Goods implements Serializable, Points {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsId")
    private Collection<Delivery> deliveryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsId")
    private Collection<ArrivalWarehouse> arrivalWarehouseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsId")
    private Collection<ConsumptionWarehouse> consumptionWarehouseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsId")
    private Collection<ArrivalFacility> arrivalFacilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsId")
    private Collection<ConsumptionFacility> consumptionFacilityCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "unit")
    private String unit;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsId")
    private Collection<GoodsInFacility> goodsInFacilityCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goodsId")
    private Collection<GoodsInWarehouse> goodsInWarehouseCollection;

    public Goods() {
    }

    public Goods(Integer id) {
        this.id = id;
    }

    public Goods(Integer id, String name, String unit) {
        this.id = id;
        this.name = name;
        this.unit = unit;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @XmlTransient
    public Collection<GoodsInFacility> getGoodsInFacilityCollection() {
        return goodsInFacilityCollection;
    }

    public void setGoodsInFacilityCollection(Collection<GoodsInFacility> goodsInFacilityCollection) {
        this.goodsInFacilityCollection = goodsInFacilityCollection;
    }

    @XmlTransient
    public Collection<GoodsInWarehouse> getGoodsInWarehouseCollection() {
        return goodsInWarehouseCollection;
    }

    public void setGoodsInWarehouseCollection(Collection<GoodsInWarehouse> goodsInWarehouseCollection) {
        this.goodsInWarehouseCollection = goodsInWarehouseCollection;
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
        if (!(object instanceof Goods)) {
            return false;
        }
        Goods other = (Goods) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Goods[ id=" + id + " ]";
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

    @XmlTransient
    public Collection<Delivery> getDeliveryCollection() {
        return deliveryCollection;
    }

    public void setDeliveryCollection(Collection<Delivery> deliveryCollection) {
        this.deliveryCollection = deliveryCollection;
    }
    
}
