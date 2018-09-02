package com.imooc.sell.service.impl;

import com.google.common.base.Preconditions;
import com.imooc.sell.dataobject.ProductInfo;
import com.imooc.sell.dto.CartDTO;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.enums.ResultEnum;
import com.imooc.sell.exception.SellException;
import com.imooc.sell.repository.ProductRepository;
import com.imooc.sell.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-13
 * @Time: 14:06
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<ProductInfo> implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    protected JpaRepository getDaoClass() {
        return productRepository;
    }

    @Override
    public List<ProductInfo> findByCategoryType(Integer categoryType) {

        return productRepository.findByCategoryType(categoryType);
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productRepository.findByStatus(ProductStatusEnum.UP.getCode());
    }

    /**
     * 增加库存
     *
     * @param cartDTOList
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void increaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList) {
            //判断商品是否存在
            ProductInfo productInfo = productRepository.findOne(cartDTO.getProductId());
            if (productInfo == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

//            增加库存
            productInfo.setProductStock(cartDTO.getProductQuantity() + productInfo.getProductStock());
//          更新商品库存

            productRepository.save(productInfo);

        }
    }

    /**
     * 减库存
     *
     * @param cartDTOList
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for (CartDTO cartDTO : cartDTOList) {
            ProductInfo productInf = productRepository.findOne(cartDTO.getProductId());
            if (productInf == null) {
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }

            Integer result = productInf.getProductStock() - cartDTO.getProductQuantity();
            if (result < 0) {
                throw new SellException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInf.setProductStock(result);

            productRepository.save(productInf);

        }
    }

    /**
     * 商品上架
     *
     * @param productId
     * @return
     */
    @Override
    public ProductInfo onSale(String productId) {
        /*if (!checkExist(productId)) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        ProductInfo productInfo = productRepository.findOne(productId);
        if (productInfo.getProductStatusEnum() == ProductStatusEnum.UP) {
            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setStatus(ProductStatusEnum.UP.getCode());

        return productRepository.save(productInfo);*/
        return onSaleOrOffSale(productId, ProductStatusEnum.UP);
    }

    private boolean checkExist(String productId) {
        ProductInfo one = productRepository.findOne(productId);
        if (one != null) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * 下架
     *
     * @param productId
     * @return
     */
    @Override
    public ProductInfo offSale(String productId) {
        return onSaleOrOffSale(productId, ProductStatusEnum.DOWN);
    }


    private ProductInfo onSaleOrOffSale(String productId, ProductStatusEnum code) {
        if (!checkExist(productId)) {
            throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
        }
        ProductInfo productInfo = productRepository.findOne(productId);
        if (productInfo.getProductStatusEnum() == code) {

            throw new SellException(ResultEnum.PRODUCT_STATUS_ERROR);
        }
        productInfo.setStatus(code.getCode());

        return productRepository.save(productInfo);
    }
}
