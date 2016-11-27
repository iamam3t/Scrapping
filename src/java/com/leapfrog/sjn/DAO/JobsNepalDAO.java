/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sjn.DAO;

import com.leapfrog.sjn.entity.Jobs;
import java.util.List;

/**
 *
 * @author AM3ET
 */
public interface JobsNepalDAO extends GenericDAO<Jobs>{
    boolean insert(Jobs t);
    List<Jobs> getAll(); 
}
