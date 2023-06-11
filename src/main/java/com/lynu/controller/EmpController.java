package com.lynu.controller;


import com.lynu.bean.Dept;
import com.lynu.bean.Emp;
import com.lynu.service.DeptService;
import com.lynu.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    DeptService deptService;
    @Autowired
    EmpService empService;




    //去到添加页面
    @RequestMapping("/toAddEmp.a")
    public String toAddEmp(HttpServletRequest request,Integer pageNum) {
        List<Dept> depts = deptService.selAllDeptSer();
        System.out.println("pageNum = " + pageNum);
        request.setAttribute("pageNum",pageNum);
        request.setAttribute("depts", depts);
        return "empPage/addEmp";
    }
    //添加页面的处理器
    @RequestMapping("/addEmpCon.a")
    public String addEmpCon(HttpServletRequest request,Integer pageNum,Emp emp,MultipartFile upImg) throws IOException {
        if (!upImg.isEmpty()){
            String originalFilename = upImg.getOriginalFilename();
            String s = originalFilename.substring(originalFilename.lastIndexOf("."));
            String realPath = request.getServletContext().getRealPath("/fileupload");
            String uuid = UUID.randomUUID().toString().replace("-", "");
            String fileName = uuid+s;
            File file = new File(realPath + "/" + fileName);
            upImg.transferTo(file);
            emp.setEmpPhoto(fileName);
        }
//        for (int i = 0;i < 20;i++){
//        }
        Dept dept = deptService.selDeptNameSer(emp.getDeptNo());
        emp.setDeptName(dept.getDeptName());
        boolean b = empService.addEmpService(emp);
        return "redirect:/demo/toEmpById.a?pageNum="+pageNum;
    }
    //去到修改页面
    @RequestMapping("/toUpdateEmp.a")
    public String toUpdateEmp(Integer empNo,Integer pageNum,String likeName,HttpServletRequest request){
        Emp emp = empService.selEmpNoSer(empNo);
        List<Dept> depts = deptService.selAllDeptSer();
        System.out.println(likeName);
        System.out.println("更新传递的页码pageNum = " + pageNum);
        request.setAttribute("likeName",likeName);
        request.setAttribute("pageNum",pageNum);
        request.setAttribute("emp",emp);
        request.setAttribute("depts",depts);
        return "empPage/updateEmp";
    }
    //修改页面的处理器        emp/toUpdateEmp.a
    @RequestMapping("/updateEmpjsp.a")
    public String updateEmpjsp(Emp emp, Integer pageNum, String likeName) throws UnsupportedEncodingException {
        boolean b = empService.updateEmpSer(emp);
        if (b){
            System.out.println("-----------------"+likeName);
            System.out.println("更新传递的页码成功pageNum=" + pageNum);
            return "redirect:/demo/toEmpById.a?pageNum="+pageNum+"&likeName="+ URLEncoder.encode(likeName,"UTF-8");
        }else {
            return "redirect:/demo/toUpdateEmp.a?empNo="+emp.getEmpNo()+"&pageNum="+pageNum+"&likeName="+URLEncoder.encode(likeName,"UTF-8");
        }
    }

    @RequestMapping("/checkEmpName.a")
    public String checkEmpName(Emp emp,HttpServletRequest request){
        System.out.println("empName = " + emp.getEmpName());
        List<Emp> empList = empService.checkEmpNameSer(emp.getEmpName());
        request.setAttribute("empList",empList);
        return "empPage/employee";
    }

    @RequestMapping("/delEmp.a")
    @ResponseBody
    public  String delEmp(Integer empNo, HttpServletResponse response) throws IOException {
        boolean b = empService.delEmpSer(empNo);
        if (b) {
            return "success";
        }else {
            return "fail";
        }
    }

    @RequestMapping("/delMore.a")
    @ResponseBody
    public String delMore(Integer[] list){
        System.out.println("list = " + list);
        String ids = "";
        for (int i = 0; i < list.length; i++) {
            if(i == list.length-1){
                ids += list[i];
            }else{
                ids = ids + list[i] + ",";
            }
        }
        System.out.println("ids = " + ids);
        boolean b = empService.delMoreSer(ids);
        if (b) {
            return "success";
        }
        return "fail";
    }

    @RequestMapping("/empAflOk.a")
    public String empAflOk(int id) {
        int i = empService.upAskForLeaveById(1,id);
        if (i == 0) {
            return "fail";
        }
        return "success";
    }

    @RequestMapping("/empAflNo.a")
    public String empAflNo(int id) {
        int i = empService.upAskForLeaveById(2,id);
        if (i == 0) {
            return "fail";
        }
        return "success";
    }


}
