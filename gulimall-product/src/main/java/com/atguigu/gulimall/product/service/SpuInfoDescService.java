package com.atguigu.gulimall.product.service;

import com.atguigu.common.utils.PageUtils;
import com.atguigu.gulimall.product.entity.SpuInfoDescEntity;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * spu信息介绍
 *
 * @author zjm111
 * @email sun122@gmail.com
 * @date 2021-06-25 02:18:07
 */
public interface SpuInfoDescService extends IService<SpuInfoDescEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

