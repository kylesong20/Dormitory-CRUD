package com.kyle.crud.service;

import com.kyle.crud.bean.Student;
import com.kyle.crud.bean.StudentExample;
import com.kyle.crud.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @auther kyle
 * @creat 2022-07-17:20
 */
@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;

    public List<Student> getAll() {

        return studentMapper.selectByExampleWithDorm(null);
    }

    public void saveStu(Student student) {
        studentMapper.insertSelective(student);
    }

    public Student getStu(Integer id){
        Student student = studentMapper.selectByPrimaryKey(id);
        return student;
    }

    public void updateStu(Student student) {
        studentMapper.updateByPrimaryKeySelective(student);
    }

    public void deleteStu(Integer id) {
        studentMapper.deleteByPrimaryKey(id);
    }

    public void deleteBatch(List<Integer> ids) {

        StudentExample studentExample = new StudentExample();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        criteria.andStuIdIn(ids);
        studentMapper.deleteByExample(studentExample);
    }
}
