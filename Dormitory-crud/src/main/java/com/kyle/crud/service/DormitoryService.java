package com.kyle.crud.service;

import com.kyle.crud.bean.Dormitory;
import com.kyle.crud.dao.DormitoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther kyle
 * @creat 2022-07-21:24
 */
@Service
public class DormitoryService {
    @Autowired
    private DormitoryMapper dormitoryMapper;
    public List<Dormitory> getDorms() {
        List<Dormitory> dormitories = dormitoryMapper.selectByExample(null);
        return dormitories;
    }
}
