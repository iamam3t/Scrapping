/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sjn.Constant;

/**
 *
 * @author AM3ET
 */
public class SqlConstant {
    public final static String INSERT_JOBSNEPAL="INSERT INTO "+TableConstant.TABLE_JOBSNEPAL+" (job_title_jn,job_type_jn,job_url_jn,company_name_jn) VALUES(?,?,?,?)";
    public final static String GETALL_JOBSNEPAL="SELECT * FROM "+TableConstant.TABLE_JOBSNEPAL;
    public final static String GETBYURL_JOBSNEPAL="SELECT * FROM "+TableConstant.TABLE_JOBSNEPAL+" WHERE job_url_jn=?";
    
    public final static String INSERT_MEROJOBS="INSERT INTO "+TableConstant.TABLE_MEROJOBS+" (job_title_mj,job_type_mj,job_url_mj,company_name_mj) VALUES(?,?,?,?)";
    public final static String GETALL_MEROJOBS="SELECT * FROM "+TableConstant.TABLE_MEROJOBS;
    public final static String GETBYURL_MEROJOBS="SELECT * FROM "+TableConstant.TABLE_MEROJOBS+" WHERE job_url_mj=?";
}
