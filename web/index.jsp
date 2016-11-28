<%@page import="com.leapfrog.sjn.util.fileImport.FileImport"%>
<%@page import="com.leapfrog.sjn.DAO.Impl.MeroJobsDAOImpl"%>
<%@page import="com.leapfrog.sjn.DAO.MeroJobsDAO"%>
<%@page import="java.sql.SQLException"%>
<%@page import="com.leapfrog.sjn.DAO.Impl.JobsNepalDAOImpl"%>
<%@page import="com.leapfrog.sjn.DAO.JobsNepalDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.leapfrog.sjn.util.Scrapper"%>
<%@page import="com.leapfrog.sjn.entity.Jobs"%>
<%@page import="com.leapfrog.sjn.DAO.Impl.JobsNepalDAOImpl"%>
<%@page import="com.leapfrog.sjn.DAO.JobsNepalDAO"%>
<%@include file="header.jsp"%>
<br>

<h1 style="text-align: center">
    <%
        out.print("Webscrapping: This is just for Educational Purpose.");
    %>
</h1>
<br>
<div class="container">
    <div class="col-md-1">

    </div>
    <div class="col-md-5">

        <form action="" method="get" class="form-inline pull-right">
            <input type="text" name="keyword"/>
            <label>Keyword</label>
            <select name="jobSite" class="form-control">
                <option value="">Select Website</option>
                <option value="jobsNepal">JOBSNEPAL</option>
                <option value="merojobs">MEROJOBS</option>
            </select>
            <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-search"></span></button>
        </form>
    </div>
    <div class="col-md-2">
        <form action="" method="post">
            <input class="btn btn-success" type="submit" value="Insert into Database" name="insert_db"/>
        </form>
    </div>
    <div class="col-md-2">
        <form action="" method="post">
            <input class="btn btn-info" type="submit" value="Export to CSV" name="csv"/>
        </form>
    </div>


</div>
<div class="container">


    <table class="table table-bordered table-stripped table-hover">

        <%
            if (request.getParameter("jobSite") != null) {
        %>
        <h3 style="text-align: center">
            <%
                out.print("Job list from " + request.getParameter("jobSite").toUpperCase());
            %>
        </h3>
        <%
            }
        %>
        <br>
        <tr class="info">
            <th>ID</th>
            <th>JOBS TITLE</th>
            <th>JOBS TYPE</th>
            <th>COMPANY</th>
            <th>URL</th>
        </tr>

        <%
            List<Jobs> jobs = new ArrayList<Jobs>();
            JobsNepalDAO jDAO = new JobsNepalDAOImpl();
            MeroJobsDAO mjDAO = new MeroJobsDAOImpl();

            String token = "";
            if (request.getParameter("jobSite") != null) {
                token = request.getParameter("jobSite");
                if (token.equalsIgnoreCase("jobsnepal")) {
                    Scrapper scrapper = new Scrapper(jDAO);
                    scrapper.getScrapper(token);
                    jobs = jDAO.getAll();
                } else {
                    Scrapper scrapper = new Scrapper(mjDAO);
                    scrapper.getScrapper(token);
                    jobs = mjDAO.getAll();
                }

            }
            for (Jobs j : jobs) {
        %>
        <tr>
            <td><%=j.getId()%></td>
            <td><%=j.getJobsTitle()%></td>
            <td><%=j.getJobsType()%></td>
            <td><%=j.getCompanyName()%></td>
            <td><%=j.getUrlName()%></td>
            <% }%>
        </tr>
    </table>
</div>
<%
    String token2 = "";
    if (request.getParameter("jobSite") != null) {
        token = request.getParameter("jobSite");
    }
    if (request.getMethod().equalsIgnoreCase("post")) {
        if (request.getParameter("csv") != null) {
            token2 = request.getParameter("csv");
        }
        if (token != null && !token2.equalsIgnoreCase("Export to CSV")) {
            if (token.equalsIgnoreCase("jobsnepal")) {
                for (Jobs j : jDAO.getAll()) {
                    if (jDAO.getByUrl(j.getUrlName()) == null) {
                        try {
                            jDAO.insertDB(j);
                        } catch (Exception e) {
                            out.print(e.getMessage());
                        }
                    }
                }
                response.sendRedirect("index.jsp");
            } else {
                for (Jobs j : mjDAO.getAll()) {
                    if (mjDAO.getByUrl(j.getUrlName()) == null) {
                        try {
                            mjDAO.insertDB(j);
                        } catch (Exception e) {
                            out.print(e.getMessage());
                        }
                    }
                }
                response.sendRedirect("index.jsp");
            }
        } else {
            FileImport fImp = new FileImport();
            fImp.exportToFile(token);
            response.sendRedirect("index.jsp");
        }
    }

%>

<%@include file="footer.jsp"%>