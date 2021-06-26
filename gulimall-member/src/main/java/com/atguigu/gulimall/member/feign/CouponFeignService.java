package com.atguigu.gulimall.member.feign;

import com.atguigu.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther zjm
 * Create  2021-06-25 7:33
 */
@FeignClient("gulimall-coupon")
public interface CouponFeignService {

    // 远程服务的url
    @RequestMapping("/coupon/coupon/member/list")//这个请求映射请求的不中心的
    public R membercoupons();//得到一个R对象

}
