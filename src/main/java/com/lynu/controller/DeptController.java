package com.lynu.controller;

import com.lynu.bean.Dept;
import com.lynu.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    DeptService deptService;



    @RequestMapping("/toAddDept.a")
    public String toAddDept(HttpServletRequest request,Integer pageNum,String likeName){
        request.setAttribute("pageNum",pageNum);
        request.setAttribute("likeName",likeName);
        return "deptPage/addDept";
    }

    @RequestMapping("/addDept.a")
    public String addDpet(Dept dept,Integer pageNum,String likeName) throws UnsupportedEncodingException {
        boolean b = deptService.addDeptSer(dept);
        if (b){
            return "redirect:/demo/toDeptById.a?pageNum="+pageNum+"&likeName="+URLEncoder.encode(likeName,"UTF-8");
        }
        return "redirect:/dept/toAddDept.a?pageNum="+pageNum+"&likeName="+URLEncoder.encode(likeName,"UTF-8");
    }

    @RequestMapping("/toUpdateDept.a")
    public String toUpdateDept(Integer deptNo,HttpServletRequest request,Integer pageNum,String likeName){
        Dept dept = deptService.selDeptSer(deptNo);
        request.setAttribute("pageNum",pageNum);
        request.setAttribute("likeName",likeName);
        request.setAttribute("dept",dept);
        return "deptPage/updateDept";
    }

    @RequestMapping("/upDept.a")
    public String upDept(Dept dept,Integer pageNum,String likeName) throws UnsupportedEncodingException {
        boolean b = deptService.upDateSer(dept);
        if (b) {
            return "redirect:/demo/toDeptById.a?pageNum="+pageNum+"likeName="+likeName;
        }else {
            return "redirect:/dept/toUpdateDept.a?deptNo="+dept.getDeptNo()+"pageNum="+pageNum+"likeName="+ URLEncoder.encode(likeName,"UTF-8");
        }
    }


    @RequestMapping("/deleleDept.a")
    @ResponseBody
    public String deleteDept(Integer deptNo) throws IOException {
        boolean b = deptService.delDeptSer(deptNo);
        if (b) {
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/delMore.a")
    @ResponseBody
    public String delMore(Integer[] list){
        String ids = "";
        for (int i = 0; i < list.length; i++) {
            if(i == list.length-1){
                ids += list[i];
            }else{
                ids = ids + list[i] + ",";
            }
        }
        boolean b = deptService.delMoreSer(ids);
        System.out.println("b = " + b);
        if (b) {
            return "success";
        }
        return "fail";
    }


}
