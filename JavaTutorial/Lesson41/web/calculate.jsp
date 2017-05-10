<%--
  Created by IntelliJ IDEA.
  User: neevor
  Date: 10/05/17
  Time: 23:20
  To change this template use File | Settings | File Templates.
--%>
<%-- directive --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.lang.Math.*" %>

<html>
    <head>
        <title>Calculate</title>
    </head>
    <body>

    <%-- scriptlet --%>
    <% out.print("Today Date: "); %>

    <%-- expression codes (evaluates to string) --%>
    <%=new java.util.Date() %>

    <%-- declarations --%>
    <%! int number1, number2; %>

    <br><br>

    <form action="calculate.jsp" method="POST">
        Enter 2 Numbers:
        <input type="text" name="numOne">
        <input type="text" name="numTwo">

        <input type="submit" value="Calculate">
    </form>

    The Answer:
    <%= request.getParameter("numOne") %> +
    <%= request.getParameter("numTwo") %>

    <%
        try {
            number1 = Integer.parseInt(request.getParameter("numOne"));
            number2 = Integer.parseInt(request.getParameter("numTwo"));
            int sumOfNums = number1 + number2;

            out.println(" = " + sumOfNums);
        } catch(NumberFormatException ex) {
            // Do stuff
        }
    %>

    </body>
</html>
