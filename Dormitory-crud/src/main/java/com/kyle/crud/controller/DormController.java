package com.kyle.crud.controller;

import com.kyle.crud.bean.Dormitory;
import com.kyle.crud.service.DormitoryService;
import com.kyle.crud.utils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @auther kyle
 * @creat 2022-07-21:22
 */
@Controller
public class DormController {
    @Autowired
    private DormitoryService dormitoryService;

    @RequestMapping("/dorms")
    @ResponseBody
    public MsgUtil getDorms(){
        List<Dormitory> list = dormitoryService.getDorms();

        return MsgUtil.success().add("dorms",list);
    }
}
