package com.lynu.bean;

import java.util.Objects;

public class Anno {
    private int annoId;
    private String annoName;
    private String annoContent;
    private String annoBy;
    private String startDate;
    private String annoDays;
    private String annoDel;

    public Anno() {
    }

    public Anno(int annoId, String annoName, String annoContent, String annoBy, String startDate, String annoDays, String annoDel) {
        this.annoId = annoId;
        this.annoName = annoName;
        this.annoContent = annoContent;
        this.annoBy = annoBy;
        this.startDate = startDate;
        this.annoDays = annoDays;
        this.annoDel = annoDel;
    }

    public int getAnnoId() {
        return annoId;
    }

    public void setAnnoId(int annoId) {
        this.annoId = annoId;
    }

    public String getAnnoName() {
        return annoName;
    }

    public void setAnnoName(String annoName) {
        this.annoName = annoName;
    }

    public String getAnnoContent() {
        return annoContent;
    }

    public void setAnnoContent(String annoContent) {
        this.annoContent = annoContent;
    }

    public String getAnnoBy() {
        return annoBy;
    }

    public void setAnnoBy(String annoBy) {
        this.annoBy = annoBy;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getAnnoDays() {
        return annoDays;
    }

    public void setAnnoDays(String annoDays) {
        this.annoDays = annoDays;
    }

    public String getAnnoDel() {
        return annoDel;
    }

    public void setAnnoDel(String annoDel) {
        this.annoDel = annoDel;
    }

    @Override
    public String toString() {
        return "Anno{" +
                "annoId=" + annoId +
                ", annoName='" + annoName + '\'' +
                ", annoContent='" + annoContent + '\'' +
                ", annoBy='" + annoBy + '\'' +
                ", startDate='" + startDate + '\'' +
                ", annoDays='" + annoDays + '\'' +
                ", annoDel='" + annoDel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anno anno = (Anno) o;
        return annoId == anno.annoId && Objects.equals(annoName, anno.annoName) && Objects.equals(annoContent, anno.annoContent) && Objects.equals(annoBy, anno.annoBy) && Objects.equals(startDate, anno.startDate) && Objects.equals(annoDays, anno.annoDays) && Objects.equals(annoDel, anno.annoDel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(annoId, annoName, annoContent, annoBy, startDate, annoDays, annoDel);
    }
}
