package xyz.mxue.crm.mapper;

import org.apache.ibatis.annotations.*;
import xyz.mxue.crm.entity.Products;

import java.util.List;

@Mapper
public interface productsMapper {

    @Select("select * from products")
    List<Products> productsListJson();


    @Insert("insert into products(proName,proPrice,proShelves,proGenre,proNumber) " +
            "values(#{proName},#{proPrice},#{proShelves},#{proGenre},#{proNumber})")
    int productsadd(Products products);

    @Delete("delete from  products where proN0=#{proN0}")
    Integer productsdelete(int proN0);

    @Select("select * from products where proN0=#{proN0}")
    Products findProductsById(int proN0);

    @Update("update products set proN0=#{proN0},proName=#{proName},proPrice=#{proPrice}," +
            "proShelves=#{proShelves},proGenre=#{proGenre},proNumber=#{proNumber} " +
            "where proN0=#{proN0}")
    int productsUpdate(Products products);
}
