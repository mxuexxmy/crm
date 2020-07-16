package xyz.mxue.crm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.mxue.crm.entity.Products;
import xyz.mxue.crm.mapper.productsMapper;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.ICproductsService;

import java.util.List;

@Service
public class ProductsService implements ICproductsService {
    @Autowired
     private productsMapper mapper;

    @Override
    public PageResult<Products> productsListJson() {
        List<Products> list =  mapper.productsListJson();
        PageResult<Products> result = new PageResult<>();
        result.setData(list);
        result.setCode(0);
        return result;
    }

    @Override
    public Integer productsadd(Products products) {
        return mapper.productsadd(products) ;
    }

    @Override
    public Integer productsdelete(int proN0) {
        return mapper.productsdelete(proN0);
    }

    @Override
    public Products findProductsById(int proN0) {
        return mapper.findProductsById(proN0);
    }

    @Override
    public int productsUpdate(Products products) {
        return mapper.productsUpdate(products);
    }

    @Override
    public Object toProductsDetail(int proN0) {
        return mapper.findProductsById(proN0);
    }
}
