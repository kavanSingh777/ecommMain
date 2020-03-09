package com.cardinal.ecomm.model;

public class Orders {
    private int order_id;
    private String cart_id;
    private String ord_date;
    private float tot_price;

    public Orders(int order_id,String cart_id,String ord_date,float tot_price){
        this.order_id=order_id;
        this.cart_id=cart_id;
        this.ord_date=ord_date;
        this.tot_price=tot_price;
    }

    public int getOrder_id() {
        return order_id;
    }
    public String getCart_id(){
        return cart_id;
    }
    public String getOrd_date(){
        return ord_date;
    }
    public float getTot_price(){return tot_price;}

    public void setOrder_id(){
        this.order_id=order_id;
    }
    public void setCart_id(){
        this.cart_id=cart_id;
    }
    public void setOrd_date(){
        this.ord_date=ord_date;
    }
    public void setTot_price(){this.tot_price=tot_price;}


}
