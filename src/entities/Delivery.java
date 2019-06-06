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
@Table(name = "delivery")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Delivery.findAll", query = "SELECT d FROM Delivery d")
    , @NamedQuery(name = "Delivery.findById", query = "SELECT d FROM Delivery d WHERE d.id = :id")
    , @NamedQuery(name = "Delivery.findByWherePoint", query = "SELECT d FROM Delivery d WHERE d.wherePoint = :wherePoint")
    , @NamedQuery(name = "Delivery.findByFromPoint", query = "SELECT d FROM Delivery d WHERE d.fromPoint = :fromPoint")
    , @NamedQuery(name = "Delivery.findByAmount", query = "SELECT d FROM Delivery d WHERE d.amount = :amount")
    , @NamedQuery(name = "Delivery.findByDocumentNumber", query = "SELECT d FROM Delivery d WHERE d.documentNumber = :documentNumber")})
public class Delivery implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "where_point")
    private String wherePoint;
    @Basic(optional = false)
    @Column(name = "from_point")
    private String fromPoint;
    @Basic(optional = false)
    @Column(name = "amount")
    private int amount;
    @Basic(optional = false)
    @Column(name = "document_number")
    private String documentNumber;
    @JoinColumn(name = "goods_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Goods goodsId;

    public Delivery() {
    }

    public Delivery(Integer id) {
        this.id = id;
    }

    public Delivery(Integer id, String wherePoint, String fromPoint, int amount, String documentNumber) {
        this.id = id;
        this.wherePoint = wherePoint;
        this.fromPoint = fromPoint;
        this.amount = amount;
        this.documentNumber = documentNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWherePoint() {
        return wherePoint;
    }

    public void setWherePoint(String wherePoint) {
        this.wherePoint = wherePoint;
    }

    public String getFromPoint() {
        return fromPoint;
    }

    public void setFromPoint(String fromPoint) {
        this.fromPoint = fromPoint;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Goods getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Goods goodsId) {
        this.goodsId = goodsId;
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
        if (!(object instanceof Delivery)) {
            return false;
        }
        Delivery other = (Delivery) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Delivery[ id=" + id + " ]";
    }
    
}
