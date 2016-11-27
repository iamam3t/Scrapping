/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sjn.DAO.Impl;

import com.leapfrog.sjn.Constant.SqlConstant;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.leapfrog.sjn.DBConnection.DBConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.leapfrog.sjn.DAO.MeroJobsDAO;
import com.leapfrog.sjn.entity.Jobs;

/**
 *
 * @author AM3ET
 */
public class MeroJobsDAOImpl implements MeroJobsDAO {

    DBConnection db = new DBConnection();
    PreparedStatement stmt = null;
    List<Jobs> jList = new ArrayList<>();
    
    @Override
    public boolean insert(Jobs j) {
        return jList.add(j);
    }

    @Override
    public List<Jobs> getAll() {
        return jList;
    }

    @Override
    public int insertDB(Jobs j) throws SQLException, ClassNotFoundException {
        db.open();
        stmt = db.initStatement(SqlConstant.INSERT_MEROJOBS);
        stmt.setString(1, j.getJobsTitle());
        stmt.setString(2, j.getJobsType());
        stmt.setString(3, j.getUrlName());
        stmt.setString(4, j.getCompanyName());
        int result = stmt.executeUpdate();
        db.close();
        return result;
    }

    @Override
    public List<Jobs> getAllDB() throws SQLException, ClassNotFoundException {
        db.open();
        stmt = db.initStatement(SqlConstant.GETALL_MEROJOBS);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Jobs j = new Jobs();
            j.setId(rs.getInt("mj_id"));
            j.setJobsTitle(rs.getString("job_title_mj"));
            j.setJobsType(rs.getString("job_type_mj"));
            j.setUrlName(rs.getString("job_url_mj"));
            j.setCompanyName(rs.getString("company_name_mj"));
            j.setAddedDate(rs.getDate("added_date_mj"));
            jList.add(j);
        }
        return jList;
    }

    @Override
    public Jobs getByUrl(String Url) throws SQLException, ClassNotFoundException {
        Jobs j=null;
        db.open();
        stmt = db.initStatement(SqlConstant.GETBYURL_MEROJOBS);
        stmt.setString(1, Url);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            j = new Jobs();
            j.setId(rs.getInt("mj_id"));
            j.setJobsTitle(rs.getString("job_title_mj"));
            j.setJobsType(rs.getString("job_type_mj"));
            j.setUrlName(rs.getString("job_url_mj"));
            j.setCompanyName(rs.getString("company_name_mj"));
            j.setAddedDate(rs.getDate("added_date_mj"));
        }
        return j;
    }

}
