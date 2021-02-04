package com.renwei.module_nginx.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author renwei
 * @since 2020/12/17 0017
 */

@RestController
@RequestMapping
public class MyNginx {
    @RequestMapping("/my/nginx")
    public String getMyNginx() {
        return "333";
    }
}
