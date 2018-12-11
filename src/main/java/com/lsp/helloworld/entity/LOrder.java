package com.lsp.helloworld.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * l_order
 * @author 
 */
public class LOrder implements Serializable {
    /**
     * 自增主键
     */
    private Long id;

    /**
     * 订单号(生成随机)
     */
    private String orderSn;

    /**
     * 1零售 2魔兽 3五毒 4退货 5滴滴 6站点  7找油网 8线上
     */
    private Integer tag;

    /**
     * 优惠码
     */
    private String couponSeq;

    /**
     * 卖家类型 1 司机 2 站点 3线上 4油站
     */
    private Integer sellerType;

    /**
     * 卖家id
     */
    private Long sellerId;

    /**
     * 卖家编码
     */
    private String sellerSn;

    /**
     * 买家类型 1 用户ID 2 司机ID 3 员工
     */
    private Integer buyerType;

    /**
     * 买家id
     */
    private Long buyerId;

    /**
     * 买家类型
     */
    private String buyerSn;

    /**
     * 经度
     */
    private Double longitude;

    /**
     * 纬度
     */
    private Double latitude;

    /**
     * 原价，单位分
     */
    private Integer price;

    /**
     * 优惠金额，单位分
     */
    private Integer discountAmount;

    /**
     * 订单总金额，单位分
     */
    private Integer payAmount;

    /**
     * 商品总个数
     */
    private Integer num;

    /**
     * 订单状态 1待支付/待确认 2未发货 3已发货 4订单完成/签收 5未支付/拒收 6支付失败  7退货  
     */
    private Integer status;

    /**
     * 支付类型  1微信 2招行
     */
    private Boolean payType;

    /**
     * 支付的 支付宝订单号，或者是 微信订单号
     */
    private String payOrderSn;

    /**
     * 是否是新订单 0 不是  1 是
     */
    private Integer isFirst;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 支付时间
     */
    private Date payTime;

    /**
     * 退款时间
     */
    private Date refundTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Integer getTag() {
        return tag;
    }

    public void setTag(Integer tag) {
        this.tag = tag;
    }

    public String getCouponSeq() {
        return couponSeq;
    }

    public void setCouponSeq(String couponSeq) {
        this.couponSeq = couponSeq;
    }

    public Integer getSellerType() {
        return sellerType;
    }

    public void setSellerType(Integer sellerType) {
        this.sellerType = sellerType;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerSn() {
        return sellerSn;
    }

    public void setSellerSn(String sellerSn) {
        this.sellerSn = sellerSn;
    }

    public Integer getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(Integer buyerType) {
        this.buyerType = buyerType;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerSn() {
        return buyerSn;
    }

    public void setBuyerSn(String buyerSn) {
        this.buyerSn = buyerSn;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(Integer discountAmount) {
        this.discountAmount = discountAmount;
    }

    public Integer getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(Integer payAmount) {
        this.payAmount = payAmount;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getPayType() {
        return payType;
    }

    public void setPayType(Boolean payType) {
        this.payType = payType;
    }

    public String getPayOrderSn() {
        return payOrderSn;
    }

    public void setPayOrderSn(String payOrderSn) {
        this.payOrderSn = payOrderSn;
    }

    public Integer getIsFirst() {
        return isFirst;
    }

    public void setIsFirst(Integer isFirst) {
        this.isFirst = isFirst;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public Date getRefundTime() {
        return refundTime;
    }

    public void setRefundTime(Date refundTime) {
        this.refundTime = refundTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        LOrder other = (LOrder) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getOrderSn() == null ? other.getOrderSn() == null : this.getOrderSn().equals(other.getOrderSn()))
            && (this.getTag() == null ? other.getTag() == null : this.getTag().equals(other.getTag()))
            && (this.getCouponSeq() == null ? other.getCouponSeq() == null : this.getCouponSeq().equals(other.getCouponSeq()))
            && (this.getSellerType() == null ? other.getSellerType() == null : this.getSellerType().equals(other.getSellerType()))
            && (this.getSellerId() == null ? other.getSellerId() == null : this.getSellerId().equals(other.getSellerId()))
            && (this.getSellerSn() == null ? other.getSellerSn() == null : this.getSellerSn().equals(other.getSellerSn()))
            && (this.getBuyerType() == null ? other.getBuyerType() == null : this.getBuyerType().equals(other.getBuyerType()))
            && (this.getBuyerId() == null ? other.getBuyerId() == null : this.getBuyerId().equals(other.getBuyerId()))
            && (this.getBuyerSn() == null ? other.getBuyerSn() == null : this.getBuyerSn().equals(other.getBuyerSn()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getDiscountAmount() == null ? other.getDiscountAmount() == null : this.getDiscountAmount().equals(other.getDiscountAmount()))
            && (this.getPayAmount() == null ? other.getPayAmount() == null : this.getPayAmount().equals(other.getPayAmount()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPayType() == null ? other.getPayType() == null : this.getPayType().equals(other.getPayType()))
            && (this.getPayOrderSn() == null ? other.getPayOrderSn() == null : this.getPayOrderSn().equals(other.getPayOrderSn()))
            && (this.getIsFirst() == null ? other.getIsFirst() == null : this.getIsFirst().equals(other.getIsFirst()))
            && (this.getAddTime() == null ? other.getAddTime() == null : this.getAddTime().equals(other.getAddTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPayTime() == null ? other.getPayTime() == null : this.getPayTime().equals(other.getPayTime()))
            && (this.getRefundTime() == null ? other.getRefundTime() == null : this.getRefundTime().equals(other.getRefundTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getOrderSn() == null) ? 0 : getOrderSn().hashCode());
        result = prime * result + ((getTag() == null) ? 0 : getTag().hashCode());
        result = prime * result + ((getCouponSeq() == null) ? 0 : getCouponSeq().hashCode());
        result = prime * result + ((getSellerType() == null) ? 0 : getSellerType().hashCode());
        result = prime * result + ((getSellerId() == null) ? 0 : getSellerId().hashCode());
        result = prime * result + ((getSellerSn() == null) ? 0 : getSellerSn().hashCode());
        result = prime * result + ((getBuyerType() == null) ? 0 : getBuyerType().hashCode());
        result = prime * result + ((getBuyerId() == null) ? 0 : getBuyerId().hashCode());
        result = prime * result + ((getBuyerSn() == null) ? 0 : getBuyerSn().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getDiscountAmount() == null) ? 0 : getDiscountAmount().hashCode());
        result = prime * result + ((getPayAmount() == null) ? 0 : getPayAmount().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPayType() == null) ? 0 : getPayType().hashCode());
        result = prime * result + ((getPayOrderSn() == null) ? 0 : getPayOrderSn().hashCode());
        result = prime * result + ((getIsFirst() == null) ? 0 : getIsFirst().hashCode());
        result = prime * result + ((getAddTime() == null) ? 0 : getAddTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPayTime() == null) ? 0 : getPayTime().hashCode());
        result = prime * result + ((getRefundTime() == null) ? 0 : getRefundTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", orderSn=").append(orderSn);
        sb.append(", tag=").append(tag);
        sb.append(", couponSeq=").append(couponSeq);
        sb.append(", sellerType=").append(sellerType);
        sb.append(", sellerId=").append(sellerId);
        sb.append(", sellerSn=").append(sellerSn);
        sb.append(", buyerType=").append(buyerType);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", buyerSn=").append(buyerSn);
        sb.append(", longitude=").append(longitude);
        sb.append(", latitude=").append(latitude);
        sb.append(", price=").append(price);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", payAmount=").append(payAmount);
        sb.append(", num=").append(num);
        sb.append(", status=").append(status);
        sb.append(", payType=").append(payType);
        sb.append(", payOrderSn=").append(payOrderSn);
        sb.append(", isFirst=").append(isFirst);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", payTime=").append(payTime);
        sb.append(", refundTime=").append(refundTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}