package com.lovego.controller;

import com.common.po.User;
import com.lovego.service.RibbonHystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/5/22 0022.
 */
@RestController
public class RibbonHystrixController {
    @Autowired
    private RibbonHystrixService ribbonHystrixService;
    @GetMapping("/ribbonhystrix/{id}")
    public User findById(@PathVariable Long id) {
        return this.ribbonHystrixService.findById(id);
    }
}