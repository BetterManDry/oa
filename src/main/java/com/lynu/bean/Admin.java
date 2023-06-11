package com.lynu.bean;

import java.util.Objects;

public class Admin {
    private Integer adminId;

    private String adminName;

    private String adminCode;

    private String adminPwd;

    private String adminPhoto;

    private String adminEmail;

    private String adminTel;

    private String adminRemarks;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String adminCode, String adminPwd, String adminPhoto, String adminEmail, String adminTel, String adminRemarks) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminCode = adminCode;
        this.adminPwd = adminPwd;
        this.adminPhoto = adminPhoto;
        this.adminEmail = adminEmail;
        this.adminTel = adminTel;
        this.adminRemarks = adminRemarks;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", adminCode='" + adminCode + '\'' +
                ", adminPwd='" + adminPwd + '\'' +
                ", adminPhoto='" + adminPhoto + '\'' +
                ", adminEmail='" + adminEmail + '\'' +
                ", adminTel='" + adminTel + '\'' +
                ", adminRemarks='" + adminRemarks + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return Objects.equals(adminId, admin.adminId) && Objects.equals(adminName, admin.adminName) && Objects.equals(adminCode, admin.adminCode) && Objects.equals(adminPwd, admin.adminPwd) && Objects.equals(adminPhoto, admin.adminPhoto) && Objects.equals(adminEmail, admin.adminEmail) && Objects.equals(adminTel, admin.adminTel) && Objects.equals(adminRemarks, admin.adminRemarks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminId, adminName, adminCode, adminPwd, adminPhoto, adminEmail, adminTel, adminRemarks);
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }

    public String getAdminPwd() {
        return adminPwd;
    }

    public void setAdminPwd(String adminPwd) {
        this.adminPwd = adminPwd;
    }

    public String getAdminPhoto() {
        return adminPhoto;
    }

    public void setAdminPhoto(String adminPhoto) {
        this.adminPhoto = adminPhoto;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminTel() {
        return adminTel;
    }

    public void setAdminTel(String adminTel) {
        this.adminTel = adminTel;
    }

    public String getAdminRemarks() {
        return adminRemarks;
    }

    public void setAdminRemarks(String adminRemarks) {
        this.adminRemarks = adminRemarks;
    }
}