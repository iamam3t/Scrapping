package com.leapfrog.sjn.util.fileImport;

import com.leapfrog.sjn.DAO.Impl.JobsNepalDAOImpl;
import com.leapfrog.sjn.DAO.Impl.MeroJobsDAOImpl;
import com.leapfrog.sjn.DAO.JobsNepalDAO;
import com.leapfrog.sjn.DAO.MeroJobsDAO;
import com.leapfrog.sjn.entity.Jobs;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;

public class FileImport{

    public void exportToFile(String token) {
        try {
            StringBuilder content = new StringBuilder();
            FileWriter writer;
            if (token.equalsIgnoreCase("jobsnepal")) {
                JobsNepalDAO jnDAO = new JobsNepalDAOImpl();
                for (Jobs j : jnDAO.getAllDB()) {
                    content.append(j.getJobsTitle()).append(",").append(j.getJobsType()).append(",").append(j.getUrlName()).append(",").append(j.getCompanyName()).append("\r\n");
                }
                writer = new FileWriter("/Users/AM3ET/Desktop/jobsnepal.csv");
            } else {
                MeroJobsDAO mjDAO = new MeroJobsDAOImpl();
                for (Jobs j : mjDAO.getAllDB()) {
                    content.append(j.getJobsTitle()).append(",").append(j.getJobsType()).append(",").append(j.getUrlName()).append(",").append(j.getCompanyName()).append("\r\n");

                }
                writer = new FileWriter("/Users/AM3ET/Desktop/merojobs.csv");
            }
            
            writer.write(content.toString());
            writer.close();
        } catch (IOException|ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
