<%@ page import="simplewebapp.*" %>
<%@ page import="java.util.List" %>

<html>
    <head>
        <!--link rel="stylesheet" href="../css/bootstrap.min.css">   		
        <script src="../js/bootstrap.min.js"></script>-->       
    </head>

    <body>  
    <%
            List<Employee> employeeList = (List<Employee>) request.getAttribute("employeeList");      
            for(Employee emp : employeeList) {
             	out.println("<ul>");
            	out.println("<li>" + emp.getName() + " " + emp.getLastName() + "</li>");
            	out.println("</ul>");
            }     
    %>   
    
            <div class="container">
            <h2>Employees</h2>
            <!--Search Form -->
            <form action="/stuff/employee" method="get" id="seachEmployeeForm" role="form">
                <input type="hidden" id="searchAction" name="searchAction" value="searchByName">
                <div class="form-group col-xs-5">
                    <input type="text" name="employeeName" id="employeeName" class="form-control" required="true" placeholder="Type the Name or Last Name of the employee"/>                    
                </div>
                <button type="submit" class="btn btn-info">
                    <span class="glyphicon glyphicon-search"></span> Search
                </button>
                <br></br>
                <br></br>
            </form>
                
    </body>
</html>