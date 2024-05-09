<%--
  Created by IntelliJ IDEA.
  User: JoraOMVA
  Date: 19/04/2024
  Time: 14:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<form class="container" method="post" action="connexion">
    <h1 class="h3 mb-3 fw-normal">Connexion à l'espace utilisateur</h1>

    <div class="form-floating">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
        <label for="floatingInput">Adresse mail</label>
        <span class="erreur">${form.erreurs['email']}</span>
    </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
        <label for="floatingPassword">Mot de passe</label>
        <span class="erreur">${form.erreurs['pwd']}</span>
    </div>

    <div class="form-check text-start my-3">
        <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
            Se souvenir de moi
        </label>
    </div>
    <button class="btn btn-primary w-100 py-2" type="submit">Connexion</button>
    <button class="btn btn-warning w-100 py-2" type="submit">Nouveau compte</button>
    <p class="mt-5 mb-3 text-body-secondary">© 2017–2024</p>
</form>
