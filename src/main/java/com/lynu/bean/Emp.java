package com.lynu.bean;

import java.util.Objects;

public class Emp {
    private Integer empNo;

    private String empName;

    private String empJob;

    private String empPhoto;

    private String empHiredate;

    private Double empSal;

    private Integer deptNo;

    private String deptName;

    private String empPw;

    private String empPhone;

    private String empEmail;

    public Emp() {
    }

    public Emp(Integer empNo, String empName, String empJob, String empPhoto, String empHiredate, Double empSal, Integer deptNo, String deptName, String empPw, String empPhone, String empEmail) {
        this.empNo = empNo;
        this.empName = empName;
        this.empJob = empJob;
        this.empPhoto = empPhoto;
        this.empHiredate = empHiredate;
        this.empSal = empSal;
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.empPw = empPw;
        this.empPhone = empPhone;
        this.empEmail = empEmail;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empNo=" + empNo +
                ", empName='" + empName + '\'' +
                ", empJob='" + empJob + '\'' +
                ", empPhoto='" + empPhoto + '\'' +
                ", empHiredate='" + empHiredate + '\'' +
                ", empSal=" + empSal +
                ", deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", empPw='" + empPw + '\'' +
                ", empPhone='" + empPhone + '\'' +
                ", empEmail='" + empEmail + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Emp emp = (Emp) o;
        return Objects.equals(empNo, emp.empNo) && Objects.equals(empName, emp.empName) && Objects.equals(empJob, emp.empJob) && Objects.equals(empPhoto, emp.empPhoto) && Objects.equals(empHiredate, emp.empHiredate) && Objects.equals(empSal, emp.empSal) && Objects.equals(deptNo, emp.deptNo) && Objects.equals(deptName, emp.deptName) && Objects.equals(empPw, emp.empPw) && Objects.equals(empPhone, emp.empPhone) && Objects.equals(empEmail, emp.empEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empNo, empName, empJob, empPhoto, empHiredate, empSal, deptNo, deptName, empPw, empPhone, empEmail);
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public Integer getEmpNo() {
        return empNo;
    }

    public void setEmpNo(Integer empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpJob() {
        return empJob;
    }

    public void setEmpJob(String empJob) {
        this.empJob = empJob;
    }

    public String getEmpPhoto() {
        return empPhoto;
    }

    public void setEmpPhoto(String empPhoto) {
        this.empPhoto = empPhoto;
    }

    public String getEmpHiredate() {
        return empHiredate;
    }

    public void setEmpHiredate(String empHiredate) {
        this.empHiredate = empHiredate;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public Integer getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(Integer deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getEmpPw() {
        return empPw;
    }

    public void setEmpPw(String empPw) {
        this.empPw = empPw;
    }
}