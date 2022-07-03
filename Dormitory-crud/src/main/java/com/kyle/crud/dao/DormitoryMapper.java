package com.kyle.crud.dao;

import com.kyle.crud.bean.Dormitory;
import com.kyle.crud.bean.DormitoryExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DormitoryMapper {
    long countByExample(DormitoryExample example);

    int deleteByExample(DormitoryExample example);

    int deleteByPrimaryKey(Integer dormId);

    int insert(Dormitory row);

    int insertSelective(Dormitory row);

    List<Dormitory> selectByExample(DormitoryExample example);

    Dormitory selectByPrimaryKey(Integer dormId);

    int updateByExampleSelective(@Param("row") Dormitory row, @Param("example") DormitoryExample example);

    int updateByExample(@Param("row") Dormitory row, @Param("example") DormitoryExample example);

    int updateByPrimaryKeySelective(Dormitory row);

    int updateByPrimaryKey(Dormitory row);
}