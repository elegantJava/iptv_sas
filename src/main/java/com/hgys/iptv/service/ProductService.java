package com.hgys.iptv.service;

import com.hgys.iptv.model.Product;
import com.hgys.iptv.model.vo.ResultVO;

import java.util.List;

public interface ProductService {

    ResultVO<?> save(Product prod);

    ResultVO<?> update(Product prod);

    ResultVO<?> logicDelete(Product prod);

    ResultVO<?> batchLogicDelete(List<Product> prods);

    ResultVO<?> findById(Integer id);

    ResultVO<?> findByCode(String code);

    ResultVO<?> findAll();
}