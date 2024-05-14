<%--
  Created by IntelliJ IDEA.
  User: JoraOMVA
  Date: 19/04/2024
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../head.jsp" />
<body class="bg-dark text-light d-flex align-item-center justify-content-center">
<form action="connexion" method="post">
    <c:if test="erreurLogin">
        <p class="align-center">${erreurLogin}</p>
    </c:if>
    Username: <input type="text" name="login"><br>
    Password: <input type="password" name="pwd"><br>
    <input type="submit" value="Se connecter">
</form>
</body>
</html>