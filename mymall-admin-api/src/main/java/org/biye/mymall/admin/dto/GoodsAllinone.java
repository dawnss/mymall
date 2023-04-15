package org.biye.mymall.admin.dto;

import org.biye.mymall.db.domain.MymallGoods;
import org.biye.mymall.db.domain.MymallGoodsAttribute;
import org.biye.mymall.db.domain.MymallGoodsProduct;
import org.biye.mymall.db.domain.MymallGoodsSpecification;

public class GoodsAllinone {
    MymallGoods goods;
    MymallGoodsSpecification[] specifications;
    MymallGoodsAttribute[] attributes;
    MymallGoodsProduct[] products;

    public MymallGoods getGoods() {
        return goods;
    }

    public void setGoods(MymallGoods goods) {
        this.goods = goods;
    }

    public MymallGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(MymallGoodsProduct[] products) {
        this.products = products;
    }

    public MymallGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(MymallGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public MymallGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(MymallGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}
