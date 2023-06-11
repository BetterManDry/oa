package com.lynu.bean;

import java.util.Objects;

public class CheckAtten {
    private Integer id;

    private Integer empId;

    private Integer attendanceDay;

    private Integer workTime;

    public CheckAtten() {
    }

    public CheckAtten(Integer id, Integer empId, Integer attendanceDay, Integer workTime) {
        this.id = id;
        this.empId = empId;
        this.attendanceDay = attendanceDay;
        this.workTime = workTime;
    }

    @Override
    public String toString() {
        return "checkAtten{" +
                "id=" + id +
                ", empId=" + empId +
                ", attendanceDay=" + attendanceDay +
                ", workTime=" + workTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CheckAtten that = (CheckAtten) o;
        return Objects.equals(id, that.id) && Objects.equals(empId, that.empId) && Objects.equals(attendanceDay, that.attendanceDay) && Objects.equals(workTime, that.workTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, empId, attendanceDay, workTime);
    }

    public Integer getWorkTime() {
        return workTime;
    }

    public void setWorkTime(Integer workTime) {
        this.workTime = workTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public Integer getAttendanceDay() {
        return attendanceDay;
    }

    public void setAttendanceDay(Integer attendanceDay) {
        this.attendanceDay = attendanceDay;
    }
}