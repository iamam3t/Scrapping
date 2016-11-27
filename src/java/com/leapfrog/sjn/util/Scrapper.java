package com.leapfrog.sjn.util;

import com.leapfrog.sjn.DAO.Impl.JobsNepalDAOImpl;
import com.leapfrog.sjn.DAO.Impl.MeroJobsDAOImpl;
import com.leapfrog.sjn.entity.Jobs;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.leapfrog.sjn.DAO.JobsNepalDAO;
import com.leapfrog.sjn.DAO.MeroJobsDAO;

public class Scrapper {

    JobsNepalDAO jnDAO = new JobsNepalDAOImpl();
    MeroJobsDAO mjDAO = new MeroJobsDAOImpl();

    public Scrapper(JobsNepalDAO jnDAO) {
        this.jnDAO = jnDAO;
    }

    public Scrapper(MeroJobsDAO mjDAO) {
        this.mjDAO = mjDAO;
    }

    public void getScrapper(String token) {
        String link = "";
        String regEx = "";
        int i = 1;
        try {
            Grabber grabber = new Grabber();
            if (token.equalsIgnoreCase("jobsnepal")) {
                link = "http://www.jobsnepal.com/";
                regEx = "<a class=\"job-item\"(.*?)href=\"(.*?)\"\\s>\\s+(.*?)</a>(.*?)class=\"joblist\">\\s+(.*?)</a>(.*?)\"center\"\\s>(.*?)</td>(.*?)\">(.*?)</span>";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(grabber.grab(link));

                while (matcher.find()) {
                    Jobs j = new Jobs();
                    j.setId(i);
                    j.setCompanyName(matcher.group(5));
                    j.setUrlName(matcher.group(2));
                    j.setJobsTitle(matcher.group(3));
                    j.setJobsType(matcher.group(7));
                    jnDAO.insert(j);
                    i++;
                }
            } else {
                link = "http://www.merojob.com/";
                regEx = "<td width=\"50%\" valign=\"top\">\\s+<a\\shref='(.*?)<strong>(.*?)</strong>(.*?)href='(.*?)'\\s+target='_blank''>(.*?)</a>";
                Pattern pattern = Pattern.compile(regEx);
                Matcher matcher = pattern.matcher(grabber.grab(link));

                while (matcher.find()) {
                    Jobs j = new Jobs();
                    j.setId(i);
                    j.setCompanyName(matcher.group(2));
                    j.setUrlName(matcher.group(4));
                    j.setJobsTitle(matcher.group(5));
                    j.setJobsType("");
                    mjDAO.insert(j);
                    i++;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
