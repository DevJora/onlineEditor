<%--
  Created by IntelliJ IDEA.
  User: JoraOMVA
  Date: 10/05/2024
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<html>
<jsp:include page="../head.jsp" />
<body class="bg-dark text-light d-flex align-item-center justify-content-center">
<form action="inscription" method="post">
    Pseudo: <input type="text" name="pseudo" required><br>
    Mail: <input type="text" name="mail" required><br>
    Password: <input type="password" name="pwd" required><br>
    <input type="submit" value="S'inscription">
</form>
</body>
</html>
