package com.cardinal.ecomm.model;

public class Products
{
    private int product_id;
    private String productSKU;
    private String product_name;
    private float product_price;
    private String short_desc;
    private String long_desc;
    private String product_image;
    private String product_category_id;

    public Products(int product_id, String productSKU, String product_name, float product_price, String short_desc, String long_desc, String product_image, String product_category_id) {
        this.product_id = product_id;
        this.productSKU = productSKU;
        this.product_name = product_name;
        this.product_price = product_price;
        this.short_desc = short_desc;
        this.long_desc = long_desc;
        this.product_image = product_image;
        this.product_category_id = product_category_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProductSKU() {
        return productSKU;
    }

    public void setProductSKU(String productSKU) {
        this.productSKU = productSKU;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public float getProduct_price() {
        return product_price;
    }

    public void setProduct_price(float product_price) {
        this.product_price = product_price;
    }

    public String getShort_desc() {
        return short_desc;
    }

    public void setShort_desc(String short_desc) {
        this.short_desc = short_desc;
    }

    public String getLong_desc() {
        return long_desc;
    }

    public void setLong_desc(String long_desc) {
        this.long_desc = long_desc;
    }

    public String getProduct_image() {
        return product_image;
    }

    public void setProduct_image(String product_image) {
        this.product_image = product_image;
    }

    public String getProduct_category_id() {
        return product_category_id;
    }

    public void setProduct_category_id(String product_category_id) {
        this.product_category_id = product_category_id;
    }
}
