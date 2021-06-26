package com.atguigu.gulimall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.BrandEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * 品牌
 *
 * @author zjm111
 * @email sun122@gmail.com
 * @date 2021-06-25 02:18:08
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

