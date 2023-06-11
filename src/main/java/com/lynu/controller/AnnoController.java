package com.lynu.controller;

import com.lynu.bean.Admin;
import com.lynu.bean.Anno;
import com.lynu.mapper.AnnoMapper;
import com.lynu.service.AnnoService;
import com.lynu.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/anno")
public class AnnoController {
    @Autowired
    AnnoService annoService;

    @RequestMapping("/toAnnoById.a")
    public String toAnnoById(HttpServletRequest request, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "5") Integer pageSize) {
        int count = annoService.getCountSer();
        PageUtil page = PageUtil.createPage(pageNum,count,pageSize);
        List<Anno> annoList = annoService.selAllService(page.getPageIndex(), page.getPageSize());
        System.out.println("annoList = " + annoList);
        request.setAttribute("pageUtil",page);
        request.setAttribute("annoList", annoList);
        return "annoPage/index";
    }

    @RequestMapping("/toAddAnno.a")
    public String toAddAnno(Integer pageNum, HttpServletRequest request, HttpSession session){
        Admin admin = (Admin)session.getAttribute("admin");
        request.setAttribute("adminName",admin.getAdminName());
        request.setAttribute("pageNum",pageNum);
        return "annoPage/addAnno";
    }

    @RequestMapping("/addAnno.a")
    public String addAnno(Integer pageNum, Anno anno){
        annoService.addAnnoSer(anno);
        return "redirect:/demo/toAnnoById.a?pageNum="+pageNum;
    }

    @RequestMapping("/upAnno.a")
    public String upAnno(Integer pageNum, Integer annoId,HttpServletRequest request){
        request.setAttribute("pageNum",pageNum);
        Anno anno = annoService.selOneSer(annoId);
        request.setAttribute("anno",anno);
        return "annoPage/updateAnno";
    }

    @RequestMapping("/upAnnoMeth.a")
    public String upAnnoMeth(Integer pageNum, Anno anno){
        System.out.println("anno = " + anno);
        annoService.updateAnnoSer(anno);
        return "redirect:/demo/toAnnoById.a?pageNum="+pageNum;
    }

    @RequestMapping("/delAnno.a")
    @ResponseBody
    public String delAnno(Integer annoId){
        boolean b = annoService.delAnnoSer(annoId);
        if (b){
            return "success";
        }
        return "fail";
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
        boolean b = annoService.delMoreSer(ids);
        if (b) {
            return "success";
        }
        return "fail";
    }
}
