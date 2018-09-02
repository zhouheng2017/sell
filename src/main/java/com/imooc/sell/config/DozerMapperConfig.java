package com.imooc.sell.config;

import com.imooc.sell.dataobject.OrderDetail;
import com.imooc.sell.dto.OrderDetail2;
import org.dozer.DozerBeanMapper;
import org.dozer.classmap.RelationshipType;
import org.dozer.loader.api.BeanMappingBuilder;
import org.dozer.loader.api.FieldsMappingOptions;
import org.dozer.loader.api.TypeMappingOptions;
import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import static org.dozer.loader.api.FieldsMappingOptions.*;
import static org.dozer.loader.api.TypeMappingOptions.mapId;
import static org.dozer.loader.api.TypeMappingOptions.mapNull;


/**
 * @Author: zhouheng
 * @Created: with IntelliJ IDEA.
 * @Description:
 * @Date: 2018-08-15
 * @Time: 13:09
 */
@Configuration
public class DozerMapperConfig {
    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean(@Value("classpath*:dozer/*.xml") Resource[] resources) throws Exception {
        final DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean = new DozerBeanMapperFactoryBean();
        dozerBeanMapperFactoryBean.setMappingFiles(resources);
        return dozerBeanMapperFactoryBean;
    }

//    @Bean
    public DozerBeanMapper mapper(){
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.addMapping(beanMappingBuilder);
        return mapper;
    }
    BeanMappingBuilder beanMappingBuilder = new BeanMappingBuilder() {
        @Override
        protected void configure() {            //a-->>b-->>a' ==>>a != a'
//            mapping(OrderDetail.class, OrderDetail.class,
//                    TypeMappingOptions.oneWay());
            mapping(OrderDetail.class, OrderDetail2.class, TypeMappingOptions.oneWay());

            mapping(OrderDetail.class, OrderDetail2.class,
                    TypeMappingOptions.oneWay(),
                    mapId("detailId"),
                    mapNull(true)
            )
//                    .exclude("excluded")
                    .fields("orderId", "orderIds",
                            copyByReference(),
                            collectionStrategy(true,
                                    RelationshipType.NON_CUMULATIVE),
                            hintA(String.class),
                            hintB(Integer.class),
                            FieldsMappingOptions.oneWay(),
                            useMapId("detailId"),
                            customConverterId("b")
                    );

        }
    };
}
