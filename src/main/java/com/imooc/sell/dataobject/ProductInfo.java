package com.imooc.sell.dataobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.imooc.sell.enums.ProductStatusEnum;
import com.imooc.sell.utils.EnumUtil;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhouheng
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class ProductInfo {
    /** id*/
    @Id
    private String productId;

    /** 名称*/
    private String productName;

    /**价格*/
    private BigDecimal productPrice;

    /** 库存*/

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer categoryType;

    private Integer status = ProductStatusEnum.UP.getCode();

    @JsonIgnore
    public ProductStatusEnum getProductStatusEnum() {
        return EnumUtil.getByCode(status, ProductStatusEnum.class);
    }


}