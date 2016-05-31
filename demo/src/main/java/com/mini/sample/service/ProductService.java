package com.mini.sample.service;

import com.mini.framework.dao.bean.Pager;
import com.mini.framework.mvc.bean.Multipart;
import com.mini.sample.bean.ProductBean;
import com.mini.sample.entity.Product;
import com.mini.sample.entity.ProductType;

import java.util.List;
import java.util.Map;

public interface ProductService {

    boolean createProduct(Map<String, Object> fieldMap, Multipart multipart);

    boolean deleteProduct(long id);

    boolean updateProduct(long id, Map<String, Object> fieldMap, Multipart multipart);

    Product getProduct(long id);

    ProductBean getProductBean(long id);

    Pager<ProductBean> getProductBeanPager(int pageNumber, int pageSize, String name);

    List<ProductType> getProductTypeList();
}
