package xyz.mxue.crm.service;

import xyz.mxue.crm.entity.Products;
import xyz.mxue.crm.model.PageResult;

public interface ICproductsService {
    
    PageResult<Products> productsListJson();

    Integer productsadd(Products products);

    Integer productsdelete(int proN0);

    Products findProductsById(int proN0);

    int productsUpdate(Products products);

    Object toProductsDetail(int proN0);
}
