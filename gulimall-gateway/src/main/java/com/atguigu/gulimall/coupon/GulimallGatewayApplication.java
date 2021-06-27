package com.atguigu.gulimall.coupon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * @Auther zjm
 * Create  2021-06-26 21:40
 */
@EnableDiscoveryClient
@SpringBootApplication
public class GulimallGatewayApplication {

        public static void main(String[] args) {
            SpringApplication.run(GulimallGatewayApplication.class, args);
        }

}
