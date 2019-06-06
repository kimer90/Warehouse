/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Karelin
 */
public interface GoodsInPoint {
    public Integer getId();
    public void setId(Integer id);
    public int getAmount();
    public void setAmount(int amount);
    public Points getPointsId();
    public void setPointsId(Points pointsId);
    public Goods getGoodsId();
    public void setGoodsId(Goods goodsId);
}
