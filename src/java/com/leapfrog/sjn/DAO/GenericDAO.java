/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.sjn.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AM3ET
 */
public interface GenericDAO<T> {
    boolean insert(T t);
    List<T> getAll();
    int insertDB(T t) throws SQLException, ClassNotFoundException;
    List<T> getAllDB() throws SQLException, ClassNotFoundException;
    T getByUrl(String Url) throws SQLException, ClassNotFoundException;
}
