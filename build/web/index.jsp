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
    <div class="col-md-5">
    </div>
    <div class="col-md-4">

        <form action="" method="get" class="form-inline">
            <select name="jobSite" class="form-control">
                <option value="">Select Website</option>
                <option value="jobsNepal">JOBSNEPAL</option>
                <option value="merojobs">MEROJOBS</option>
            </select>
            <button class="btn btn-primary" type="submit"><span class="glyphicon glyphicon-search"></span></button>
        </form>
    </div>
    <div class="col-md-3">
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
        <tr class="danger">
            <th>ID</th>
            <th>JOBS TITLE</th>
            <th>JOBS TYPE</th>
            <th>COMPANY</th>
            <th>URL</th>
        </tr>

        <%
            List<Jobs> jobs = new ArrayList<Jobs>();
            JobsNepalDAO jnDAO = new JobsNepalDAOImpl();
            String token = "";
            if (request.getParameter("jobSite") != null) {
                token = request.getParameter("jobSite");
                Scrapper scrapper = new Scrapper(jnDAO);
                scrapper.getScrapper(token);
                jobs = jnDAO.getAll();
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
<%@include file="footer.jsp"%>