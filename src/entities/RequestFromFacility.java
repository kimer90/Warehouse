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
@Table(name = "request_from_facility")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RequestFromFacility.findAll", query = "SELECT r FROM RequestFromFacility r")
    , @NamedQuery(name = "RequestFromFacility.findById", query = "SELECT r FROM RequestFromFacility r WHERE r.id = :id")
    , @NamedQuery(name = "RequestFromFacility.findByTime", query = "SELECT r FROM RequestFromFacility r WHERE r.time = :time")
    , @NamedQuery(name = "RequestFromFacility.findByAmount", query = "SELECT r FROM RequestFromFacility r WHERE r.amount = :amount")
    , @NamedQuery(name = "RequestFromFacility.findByDocumentNumber", query = "SELECT r FROM RequestFromFacility r WHERE r.documentNumber = :documentNumber")
    , @NamedQuery(name = "RequestFromFacility.findByStatus", query = "SELECT r FROM RequestFromFacility r WHERE r.status = :status")})
public class RequestFromFacility implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "status")
    private String status;
    @JoinColumn(name = "goods_in_facility_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private GoodsInFacility goodsInFacilityId;

    public RequestFromFacility() {
    }

    public RequestFromFacility(Integer id) {
        this.id = id;
    }

    public RequestFromFacility(Integer id, Date time, int amount, String documentNumber, String status) {
        this.id = id;
        this.time = time;
        this.amount = amount;
        this.documentNumber = documentNumber;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public GoodsInFacility getGoodsInFacilityId() {
        return goodsInFacilityId;
    }

    public void setGoodsInFacilityId(GoodsInFacility goodsInFacilityId) {
        this.goodsInFacilityId = goodsInFacilityId;
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
        if (!(object instanceof RequestFromFacility)) {
            return false;
        }
        RequestFromFacility other = (RequestFromFacility) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RequestFromFacility[ id=" + id + " ]";
    }
    
}
