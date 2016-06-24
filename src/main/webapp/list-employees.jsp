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
    %>
    
    <%= "SIZE: " + (employeeList == null ? 0 : employeeList.size()) %>
            

    </body>
</html>