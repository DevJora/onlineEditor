<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GdocsInscription</title>
    <link href="./assets/css/styles.css" rel="stylesheet">
</head>
<body>
<nav>
	<a href="home">Menu</a>
    <a href="hello-servlet">Chat</a>
    <a href="editor">Editor servlet</a>
    <a href="home">Home</a>
    <a href="connexion">Connexion</a>
    <a href="inscription">Inscription</a>
</nav>
<form action="inscription" method="post">
    <h2>Inscription</h2>
    
    <% if (request.getAttribute("error") != null) { %>
        <p class="error-message"><%= request.getAttribute("error") %></p>
    <% } %>
    <div class="user-box">
        <input type="text" name="pseudo" required>
        <label for="pseudo">Pseudo</label>
    </div>
    <div class="user-box">
        <input type="text" name="mail" required>
        <label for="mail">Mail</label>
    </div>
    <div class="user-box">
        <input type="password" name="pwd" required>
        <label for="pwd">Password</label>
    </div>
    <input type="submit" value="S'inscrire">
</form>
</body>
</html>
