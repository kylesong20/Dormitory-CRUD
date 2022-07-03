package com.kyle.crud.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kyle.crud.bean.Student;
import com.kyle.crud.service.StudentService;
import com.kyle.crud.utils.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @auther kyle
 * @creat 2022-07-17:09
 */
@Controller
public class StudentController {
    @Autowired
    StudentService studentService;


    /**
     * 删除
     * @param ids
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stu/{ids}",method = RequestMethod.DELETE)
    public MsgUtil delStuById(@PathVariable("ids") String ids){
        if (ids.contains("-")){
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
            for (String string:str_ids){
                del_ids.add(Integer.parseInt(string));
            }
            studentService.deleteBatch(del_ids);
        }else {
            Integer id = Integer.parseInt(ids);
            studentService.deleteStu(id);
        }
        return MsgUtil.success();
    }

    /**
     * 根据id更新员工信息
     * @param student
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/stu/{stuId}",method = RequestMethod.PUT)
    public MsgUtil saveStu(Student student){
        studentService.updateStu(student);
        return MsgUtil.success();
    }

    /**
     * 根据id查询学生
     * @param id
     * @return
     */
    @RequestMapping(value = "/stu/{id}",method = RequestMethod.GET)
    @ResponseBody
    public MsgUtil getStu(@PathVariable("id") Integer id){
        Student student = studentService.getStu(id);
        return MsgUtil.success().add("stu",student);
    }

    /**
     * 保存新增学生
     * @param student
     * @param result
     * @return
     */
    @RequestMapping(value = "/stu",method = RequestMethod.POST)
    @ResponseBody
    public MsgUtil saveStu(@Valid Student student, BindingResult result){
        if (result.hasErrors()){
            Map<String,Object> map = new HashMap<>();
            List<FieldError> fieldErrors = result.getFieldErrors();
            for(FieldError fieldError : fieldErrors){
                System.out.println("错误的字段名："+fieldError.getField());
                System.out.println("错误信息："+fieldError.getDefaultMessage());
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return MsgUtil.fail().add("errorFields",map);
        }else {
            studentService.saveStu(student);
            return MsgUtil.success();
        }
    }

    @RequestMapping("/students")
    @ResponseBody
    public MsgUtil getStusWithJson(@RequestParam(value = "pn",defaultValue = "1")Integer pn){
        PageHelper.startPage(pn,5);

        List<Student> stus = studentService.getAll();
        PageInfo<Student> page = new PageInfo<>(stus, 5);
        return MsgUtil.success().add("pageInfo",page);
    }

    //@RequestMapping("/students")
    public String getStus(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

        //分页插件
        PageHelper.startPage(pn,5);

        List<Student> stus = studentService.getAll();
        PageInfo<Student> page = new PageInfo<>(stus, 5);
        model.addAttribute("pageInfo",page);
        return "studentList";
    }
}
