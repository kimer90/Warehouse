/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Karelin
 */
@Entity
@Table(name = "goods_in_warehouse")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoodsInWarehouse.findAll", query = "SELECT g FROM GoodsInWarehouse g")
    , @NamedQuery(name = "GoodsInWarehouse.findById", query = "SELECT g FROM GoodsInWarehouse g WHERE g.id = :id")
    , @NamedQuery(name = "GoodsInWarehouse.findByAmount", query = "SELECT g FROM GoodsInWarehouse g WHERE g.amount = :amount")})
public class GoodsInWarehouse implements Serializable, GoodsInPoint {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Goods goodsId;
    @JoinColumn(name = "warehouses_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Warehouses warehousesId;

    public GoodsInWarehouse() {
    }

    public GoodsInWarehouse(Integer id) {
        this.id = id;
    }

    public GoodsInWarehouse(Integer id, int amount) {
        this.id = id;
        this.amount = amount;
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
    public int getAmount() {
        return amount;
    }

    @Override
    public void setAmount(int amount) {
        this.amount = amount;
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
    public Points getPointsId() {
        return warehousesId;
    }

    @Override
    public void setPointsId(Points warehousesId) {
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
        if (!(object instanceof GoodsInWarehouse)) {
            return false;
        }
        GoodsInWarehouse other = (GoodsInWarehouse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GoodsInWarehouse[ id=" + id + " ]";
    }
    
}
