package com.leapfrog.sjn.entity;

import java.util.Date;

public class Jobs {
    private String companyName, jobsTitle, urlName, jobsType;
    private int id;
    private Date addedDate;

    public Jobs() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getJobsTitle() {
        return jobsTitle;
    }

    public void setJobsTitle(String jobsTitle) {
        this.jobsTitle = jobsTitle;
    }

    public String getUrlName() {
        return urlName;
    }

    public void setUrlName(String urlName) {
        this.urlName = urlName;
    }

    public String getJobsType() {
        return jobsType;
    }

    public void setJobsType(String jobsType) {
        this.jobsType = jobsType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }
    
}
