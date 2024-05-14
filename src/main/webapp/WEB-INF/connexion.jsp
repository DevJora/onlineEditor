<%@ page contentType="text/html;charset=UTF-8" language="java" %><head>
  <title>Gdoc-connexion</title>
  <link href="css/connect.css" rel="stylesheet">
 
</head>
<nav>
	<a href="home">Menu</a>
    <a href="hello-servlet">Chat</a>
    <a href="editor">Editor servlet</a>
    <a href="home">Home</a>
    <a href="connexion">Connexion</a>
    <a href="inscription">Inscription</a>
</nav>
<form method="post" action="connexion">
    <h2 class="h3 mb-3 fw-normal">Connexion à l'espace utilisateur</h2>

    <div class="user-box">
    <input type="email" class="form-control" id="floatingInput" required>
    <label for="floatingInput">Adresse mail</label>
    <span class="erreur">${form.erreurs['email']}</span>
</div>
<div class="user-box">
    <input type="password" class="form-control" id="floatingPassword" required>
    <label for="floatingPassword">Mot de passe</label>
    <span class="erreur">${form.erreurs['pwd']}</span>
</div>


<% if (request.getAttribute("error") != null) { %>
        <p class="error-message"><%= request.getAttribute("error") %></p>
    <% } %>

    <div class="form-check text-start my-3">
        <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault" style="color:white;">
            Se souvenir de moi
        </label>
    </div>
     <br>
    <button class="buttonco" type="submit">Connexion</button>
    <br>
    <br>
    <br>
    <div><a href="inscription">Nouveau compte</a></div>
    <p class="mt-5 mb-3 text-body-secondary" style="color:white;">© 2017–2024</p>
</form>