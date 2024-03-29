/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karelin
 */
@Entity
@Table(name = "arrival_warehouse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ArrivalWarehouse.findAll", query = "SELECT a FROM ArrivalWarehouse a")
    , @NamedQuery(name = "ArrivalWarehouse.findById", query = "SELECT a FROM ArrivalWarehouse a WHERE a.id = :id")
    , @NamedQuery(name = "ArrivalWarehouse.findByTime", query = "SELECT a FROM ArrivalWarehouse a WHERE a.time = :time")
    , @NamedQuery(name = "ArrivalWarehouse.findByAmount", query = "SELECT a FROM ArrivalWarehouse a WHERE a.amount = :amount")
    , @NamedQuery(name = "ArrivalWarehouse.findByDocumentNumber", query = "SELECT a FROM ArrivalWarehouse a WHERE a.documentNumber = :documentNumber")})
public class ArrivalWarehouse implements Serializable, Log {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date time;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @Column(name = "document_number")
    private String documentNumber;
    @JoinColumn(name = "facility_id", referencedColumnName = "id")
    @ManyToOne
    private Facility facilityId;
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Goods goodsId;
    @JoinColumn(name = "warehouses_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Warehouses warehousesId;

    public ArrivalWarehouse() {
    }

    public ArrivalWarehouse(Integer id) {
        this.id = id;
    }

    public ArrivalWarehouse(Integer id, Date time, int amount, String documentNumber) {
        this.id = id;
        this.time = time;
        this.amount = amount;
        this.documentNumber = documentNumber;
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
    public Date getTime() {
        return time;
    }

    @Override
    public void setTime(Date time) {
        this.time = time;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String getDocumentNumber() {
        return documentNumber;
    }

    @Override
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    @Override
    public Points getPassivePointId() {
        return facilityId;
    }

    @Override
    public void setPassivePointId(Points facilityId) {
        this.facilityId = (Facility)facilityId;
    }

    @Override
    public Goods getGoodsId() {
        return goodsId;
    }

    @Override
    public void setGoodsId(Goods goodsId) {
        this.goodsId = goodsId;
    }

    @Override
    public Points getActivePointId() {
        return warehousesId;
    }

    @Override
    public void setActivePointId(Points warehousesId) {
        this.warehousesId = (Warehouses)warehousesId;
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
        if (!(object instanceof ArrivalWarehouse)) {
            return false;
        }
        ArrivalWarehouse other = (ArrivalWarehouse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ArrivalWarehouse[ id=" + id + " ]";
    }
    
}
