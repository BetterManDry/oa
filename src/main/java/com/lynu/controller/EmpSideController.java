package com.lynu.controller;

import com.lynu.bean.Anno;
import com.lynu.bean.AskForLeave;
import com.lynu.bean.CheckAtten;
import com.lynu.bean.Emp;
import com.lynu.service.AnnoService;
import com.lynu.service.EmpSideService;
import com.lynu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/empSide")
public class EmpSideController {

    @Autowired
    EmpSideService empSideService;

    @Autowired
    AnnoService annoService;

    @RequestMapping("/login.a")
    public String login() {
        return "empSide/login";
    }

    //登录员工
    @RequestMapping("/toIndex.a")
    public String toIndex(Emp emp, HttpServletRequest request) {
        emp = empSideService.queryEmpByNameAndPass(emp);
        CheckAtten atten = empSideService.queryCheckAttenByEmpId(emp.getEmpNo());
        if (emp == null) {
            return "empSide/login";
        }
        request.setAttribute("checkAtten", atten);
        request.getSession().setAttribute("emp", emp);
        return "empSide/index";
    }

    //登录成功  未打卡
    @RequestMapping("/checkAtten.a")
    public String checkAtten() {
        return "empSide/checkAttendance/checkAtten";
    }

    //登录成功  已打卡
    @RequestMapping("/checkAttenOk.a")
    public String checkAttenOk() {
        return "empSide/checkAttendance/checkAttenOk";
    }

    //打卡
    @RequestMapping("/EmpCheckAtten.a")
    public String EmpCheckAtten(HttpSession session) {
        Emp emp = (Emp) session.getAttribute("emp");
        int i = empSideService.upEmpCheckAtten(1,emp.getEmpNo());
        if (i == 0) {
            return "empSide/checkAttendance/checkAtten";
        }
        return "empSide/checkAttendance/checkAttenOk";
    }

    @RequestMapping("/EmpCheckAttenNo.a")
    public String EmpCheckAttenNo(HttpSession session) {
        Emp emp = (Emp) session.getAttribute("emp");
        int i = empSideService.upEmpCheckAtten(0,emp.getEmpNo());
        if (i == 0) {
            return "empSide/checkAttendance/checkAttenOk";
        }
        return "empSide/checkAttendance/checkAtten";
    }

    //员工公告页面
    @RequestMapping("/anno/toAnnoById.a")
    public String toAnnoById(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        int count = annoService.getCountSer();
        PageUtil page = PageUtil.createPage(pageNum, count, pageSize);
        List<Anno> annoList = annoService.selAllService(page.getPageIndex(), page.getPageSize());
        System.out.println("annoList = " + annoList);
        request.setAttribute("pageUtil", page);
        request.setAttribute("annoList", annoList);
        return "empSide/anno/index";
    }

    //查看请假记录
    @RequestMapping("/askForLeave/toSeeAfl.a")
    public String toSeeAfl(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "5") Integer pageSize, HttpServletRequest request) {
        Emp emp = (Emp) request.getSession().getAttribute("emp");
        int count = empSideService.queryAflCountByEmpId(emp.getEmpNo());
        PageUtil pageUtil = PageUtil.createPage(pageNum, count, pageSize);
        List<AskForLeave> askForLeaveList = empSideService.queryAfls(emp.getEmpNo(), pageUtil.getPageIndex(), pageUtil.getPageSize());
        request.setAttribute("askForLeaveList", askForLeaveList);
        request.setAttribute("pageUtil", pageUtil);
        return "empSide/askForLeave/toSeeAfl";
    }

    //请假申请
    @RequestMapping("/askForLeave/toAddEmpSfl.a")
    public String toAddEmpSfl(int pageNum, AskForLeave askForLeave, HttpServletRequest request) {
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("askForLeave", askForLeave);
        return "empSide/askForLeave/addEmpSfl";
    }

    @RequestMapping("/insert.a")
    public String insert(AskForLeave askForLeave, HttpServletRequest request, int pageNum) {
        Emp emp = (Emp) request.getSession().getAttribute("emp");
        askForLeave.setEmpId(emp.getEmpNo());
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        askForLeave.setCreateTime(format);
        boolean b = empSideService.insert(askForLeave);
        if (b) {
            return "redirect:/empSide/askForLeave/toSeeAfl.a?pageNum=" + pageNum;
        } else {
            return "redirect:/empSide/askForLeave/toAddEmpSfl.a?askForLeave=" + askForLeave + "&pageNum=" + pageNum;
        }

    }

    @RequestMapping("/askForLeave/updateAfl.a")
    public String updateAfl(int pageNum, int id, HttpServletRequest request) {
        AskForLeave askForLeave = empSideService.queryAflById(id);
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("askForLeave", askForLeave);
        return "empSide/askForLeave/addEmpSfl";
    }

    @RequestMapping("/toPass.a")
    public String toPass() {
        return "empSide/pass";
    }

    @RequestMapping("/upEmpPass.a")
    public String upEmpPass(String mPass, String newPass, String reNewPass, HttpSession session) {
        System.out.println("-------------------");
        Emp emp = (Emp) session.getAttribute("emp");
        boolean b = empSideService.queryEmpPassById(emp.getEmpNo(), mPass);
        System.out.println("b = " + b);
        if (!b) {
            return "原密码错误";
        }
        if (!reNewPass.equals(newPass)) {
            return "密码不一致，请重新输入";
        }
        boolean b1 = empSideService.upEmpPass(emp.getEmpNo(), newPass);
        System.out.println("b1 = " + b1);
        if (b1) {
            return "修改成功";
        }
        return "修改失败";
    }

    @RequestMapping("/toPersonal.a")
    public String toPersonal() {
        return "empSide/personal";
    }

    @RequestMapping("/upEmpPersonal.a")
    public String upEmpPersonal(Emp emp, HttpSession session) {
        Emp e1 = (Emp) session.getAttribute("emp");
        emp.setEmpNo(e1.getEmpNo());
        boolean b = empSideService.upEmpPwesonal(emp);
        if (b) {
            e1.setEmpEmail(emp.getEmpEmail());
            e1.setEmpPhone(emp.getEmpPhone());
        }
        return "empSide/personal";
    }


}
