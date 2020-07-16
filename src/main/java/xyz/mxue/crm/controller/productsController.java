package xyz.mxue.crm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.mxue.crm.entity.Products;
import xyz.mxue.crm.model.CRUDResult;
import xyz.mxue.crm.model.PageResult;
import xyz.mxue.crm.service.ICproductsService;

@Controller
@RequestMapping("/products")
public class productsController {
    @Autowired
    private ICproductsService service;

    @RequestMapping("/toproductslist")
    public String toProductsList(){
        return "sales/productslist";
    }

    @ResponseBody
    @RequestMapping("/productslistjson")
    public PageResult<Products> productsListJson(){
        PageResult<Products> result = new PageResult<>();
        result  = service.productsListJson();
        return result;
    }



    @RequestMapping("/toprodusadd")
    public String tocustomeradd(){
        return "sales/productsadd";
    }

    @ResponseBody
    @RequestMapping(value = "/productsadd",method = RequestMethod.POST)
    public CRUDResult productsadd(Products products){
        CRUDResult result = new CRUDResult();
        result.setSuccess(service.productsadd(products));
        result.setMsg("成功");
        return result;
    }

    @ResponseBody
    @RequestMapping(value = "/productsdelete",method = RequestMethod.POST)
    public CRUDResult productsdelete(int proN0){

        CRUDResult result = new CRUDResult();
        Integer i = service.productsdelete(proN0);
        if(i==0){
            result.setMsg("删除失败");
        }else {
            result.setMsg("删除成功");
        }

        return result ;
    }



    @RequestMapping("/toproductsupdate")
    public String toproductsupdate(int proN0, Model model){
        Products products =  service.findProductsById(proN0);
        model.addAttribute("products",products);
        return "sales/productsupdate";
    }

    @ResponseBody
    @RequestMapping("/productsupdate")
    public CRUDResult productsUpdate(Products products){
        System.out.println("products = " + products);

        CRUDResult result = new CRUDResult();
        if(service.productsUpdate(products)==1){
            result.setMsg("修改成功");
        }else {
            result.setMsg("修改失败");
        }
        return result;
    }


    @RequestMapping("/toproductsdetail")
    public String toProductsDetail(int proN0,Model model){
        model.addAttribute("products",service.toProductsDetail(proN0));
        return "sales/productsdetail";
    }


}
