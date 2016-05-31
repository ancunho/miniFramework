package com.mini.sample.action;

//import com.mini.framework.dao.bean.Pager;
import com.mini.framework.annotation.Inject;
//import com.mini.framework.mvc.DataContext;
import com.mini.framework.annotation.Action;
import com.mini.framework.annotation.Request;
import com.mini.framework.mvc.bean.*;
//import com.mini.framework.util.WebUtil;
//import com.mini.plugin.security.annotation.HasPermissions;
//import com.mini.plugin.security.annotation.HasRoles;
//import com.mini.sample.Constant;
//import com.mini.sample.Tool;
//import com.mini.sample.bean.ProductBean;
import com.mini.sample.entity.Product;
import com.mini.sample.entity.ProductType;
import com.mini.sample.service.ProductService;

import java.util.List;
import java.util.Map;

@Action
public class ProductAction {

    @Inject
    private ProductService productService;

    @Request.Get("/products")
    public View index() {
        /*
        int pageNumber = 1;
        int pageSize = Tool.getPageSize("product_pager");
        String name = "";

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        return new View("product.jsp")
            .data("productBeanPager", productBeanPager);
        */
        return new View("product.jsp").data("productBeanPager",null);
    }

    @Request.Post("/product/search")
    public View search(Params params) {
        /*
        int pageNumber = params.getInt(Constant.PAGE_NUMBER);
        int pageSize = params.getInt(Constant.PAGE_SIZE);
        String name = params.getString("name");

        Pager<ProductBean> productBeanPager = productService.getProductBeanPager(pageNumber, pageSize, name);
        return new View("product_list.jsp")
            .data("productBeanPager", productBeanPager);
        */
        return null;
    }
    /*

    @HasPermissions("product.create")
    @Request.Get("/product/create")
    public View create() {
        List<ProductType> productTypeList = productService.getProductTypeList();
        return new View("product_create.jsp")
            .data("productTypeList", productTypeList);
    }

    @HasPermissions("product.create")
    @Request.Post("/product/create")
    public Result create(Params params, Multiparts multiparts) {
        Map<String, Object> fieldMap = params.getFieldMap();
        Multipart multipart = multiparts.getOne();
        boolean success = productService.createProduct(fieldMap, multipart);
        return new Result(success);
    }

    @HasPermissions("product.delete")
    @Request.Delete("/product/delete/{id}")
    public Result delete(long id) {
        boolean success = productService.deleteProduct(id);
        return new Result(success);
    }

    @HasPermissions("product.view")
    @Request.Get("/product/view/{id}")
    public View view(long id) {
        ProductBean productBean = productService.getProductBean(id);
        return new View("product_view.jsp")
            .data("productBean", productBean);
    }

    @HasPermissions("product.edit")
    @Request.Get("/product/edit/{id}")
    public View edit(long id) {
        List<ProductType> productTypeList = productService.getProductTypeList();
        ProductBean productBean = productService.getProductBean(id);
        return new View("product_edit.jsp")
            .data("productTypeList", productTypeList)
            .data("productBean", productBean);
    }

    @HasRoles("admin")
    @Request.Put("/product/update/{id}")
    public Result update(long id, Params params) {
        Map<String, Object> fieldMap = params.getFieldMap();
        boolean success = productService.updateProduct(id, fieldMap, null);
        return new Result(success);
    }

    @HasRoles("admin")
    @Request.Get("/product/upload_picture/{id}")
    public View uploadPicture(long id) {
        Product product = productService.getProduct(id);
        return new View("product_upload.jsp")
            .data("product", product);
    }

    @HasRoles("admin")
    @Request.Post("/product/upload_picture/{id}")
    public Result uploadPicture(long id, Params params, Multiparts multiparts) {
        Map<String, Object> fieldMap = params.getFieldMap();
        Multipart multipart = multiparts.getOne();
        boolean success = productService.updateProduct(id, fieldMap, multipart);
        return new Result(success)
            .data(multipart.getFileName());
    }

    @Request.Get("/product/download_picture/{id}")
    public void downloadPicture(long id) {
        Product product = productService.getProduct(id);
        String picture = product.getPicture();

        String filePath = Tool.getBasePath() + picture;
        WebUtil.downloadFile(DataContext.getResponse(), filePath);
    }

    */
}
