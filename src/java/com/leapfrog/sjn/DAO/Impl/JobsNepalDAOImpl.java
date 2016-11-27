/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sjn.DAO.Impl;

import com.leapfrog.sjn.DAO.JobsNepalDAO;
import com.leapfrog.sjn.entity.Jobs;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AM3ET
 */
public class JobsNepalDAOImpl implements JobsNepalDAO{
    
    List<Jobs> jList = new ArrayList<>();
    
    @Override
    public boolean insert(Jobs j) {
        return jList.add(j);
    }

    @Override
    public List<Jobs> getAll() {
        return jList;
    }
    
}
