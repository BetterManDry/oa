package com.lynu.bean;

import java.util.Objects;

public class AskForLeave {
    private int id;
    private int empId;
    private String fromType;
    private String startTime;
    private String endTime;
    private String reason;
    private String createTime;
    private String state;
    private String empName;

    public AskForLeave() {
    }

    @Override
    public String toString() {
        return "AskForLeave{" +
                "id=" + id +
                ", empId=" + empId +
                ", fromType='" + fromType + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", reason='" + reason + '\'' +
                ", createTime='" + createTime + '\'' +
                ", state='" + state + '\'' +
                ", empName='" + empName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AskForLeave that = (AskForLeave) o;
        return id == that.id && empId == that.empId && Objects.equals(fromType, that.fromType) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(reason, that.reason) && Objects.equals(createTime, that.createTime) && Objects.equals(state, that.state) && Objects.equals(empName, that.empName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empId, fromType, startTime, endTime, reason, createTime, state, empName);
    }

    public AskForLeave(int id, int empId, String fromType, String startTime, String endTime, String reason, String createTime, String state, String empName) {
        this.id = id;
        this.empId = empId;
        this.fromType = fromType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.reason = reason;
        this.createTime = createTime;
        this.state = state;
        this.empName = empName;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFromType() {
        return fromType;
    }

    public void setFromType(String fromType) {
        this.fromType = fromType;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

}
