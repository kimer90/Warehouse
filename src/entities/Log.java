/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.Date;

/**
 *
 * @author Karelin
 */
public interface Log {
    public Integer getId();
    public void setId(Integer id);
    public Date getTime();
    public void setTime(Date time);
    public int getAmount();
    public void setAmount(int amount);
    public String getDocumentNumber();
    public void setDocumentNumber(String documentNumber);
    public Points getPassivePointId();
    public void setPassivePointId(Points facilityId);
    public Goods getGoodsId();
    public void setGoodsId(Goods goodsId);
    public Points getActivePointId();
    public void setActivePointId(Points warehousesId);
}
