<%--
  Created by IntelliJ IDEA.
  User: JoraOMVA
  Date: 22/04/2024
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Online Editor</title>
    <!--<link rel="stylesheet" href="assets/style.css" >-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="assets/style.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
    <link href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="assets/document.css">
    <!-- Latest compiled and minified JavaScript -->
    <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>-->
</head>
<body onload="connexionChat();">
<main class="">
    <article>
        <div class="editor">
            <div class="outils">
                <!--Liste des outils à utiliser-->
                <!--texte en gras-->
                <button type="button" class="btn" data-element="bold">
                <span class="material-symbols-outlined">
                format_bold
                </span>
                </button>
                <!--texte en italic-->
                <button type="button" class="btn" data-element="italic">
                <span class="material-symbols-outlined">
                    format_italic
                </span>
                </button>
                <!--texte souligné-->
                <button type="button" class="btn" data-element="underline">
                <span class="material-symbols-outlined">
                    format_underlined
                </span>
                </button>
                <!--liste non ordonnée -->
                <button type="button" class="btn" data-element="insertUnorderedList">
                <span class="material-symbols-outlined">
                    list
                </span>
                </button>
                <!--liste ordonnée -->
                <button type="button" class="btn" data-element="insertOrderedList">
                <span class="material-symbols-outlined">
                    format_list_numbered
                </span>
                </button>
                <!--lien -->
                <button type="button" class="btn" data-element="createLink">
                <span class="material-symbols-outlined">
                    link
                </span>
                </button>
                <!--text left -->
                <button type="button" class="btn" data-element="justifyLeft">
                <span class="material-symbols-outlined">
                    format_align_left
                    </span>
                </button>
                <!--text center -->
                <button type="button" class="btn" data-element="justifyCenter">
                <span class="material-symbols-outlined">
                    format_align_center
                </span>
                </button>
                <!--text right -->
                <button type="button" class="btn" data-element="justifyRight">
                <span class="material-symbols-outlined">
                    format_align_right
                </span>
                </button>
                <!--insert img -->
                <button type="button" class="btn" data-element="insertImage">
                <span class="material-symbols-outlined">
                    image
                </span>
                </button>
                <!--ajout bloc-->
                <button type="button" class="btn" data-element="addBloc">
                <span class="material-symbols-outlined">
                    variable_add
                </span>
                </button>
                <!--save bloc-->
                <button type="button" class="btn">
                <span class="material-symbols-outlined">
                    save
                </span>
                </button>
            </div>
            <div class="document" id="doc" >

                <h1 contenteditable = "true">Titre du document</h1>
            </div>

            <!--boite de texte-->
            <!--l'attribut contenteditable précise que l'utilisateur peut modifier cette div-->
            <!--<div class="texte" contenteditable="true">

            </div>-->
        </div>
    </article>
    <aside class="">
        <div class="conv d-flex flex-column flex-shrink-0 p-3 text-white bg-dark">
            <a href="/" class="d-flex align-items-center mb-3 mb-md-0 me-md-auto text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32"><use xlink:href="#bootstrap"></use></svg>
                <span class="fs-4">Participants</span>
            </a>
            <hr>
            <div id="chat"></div>
            <hr>
            <div class="dropdown m-auto d-flex justify-content-arround">
                <a href="#" class="d-flex align-items-center text-white text-decoration-none dropdown-toggle" id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
                    <img src="https://github.com/mdo.png" alt="" width="32" height="32" class="rounded-circle me-2">
                    <strong></strong>
                </a>
                <ul class="dropdown-menu dropdown-menu-dark text-small shadow" aria-labelledby="dropdownUser1">
                    <li><a class="dropdown-item" href="#">New project...</a></li>
                    <li><a class="dropdown-item" href="#">Settings</a></li>
                    <li><a class="dropdown-item" href="#">Profile</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#">Sign out</a></li>
                </ul>
                <div class="d-flex">
                    <input type="text" name="msg" id="msg" placeholder="Enter message here"/>
                    <button onclick="return sendMsg();"><span class="material-symbols-outlined">send</span></button>
                </div>
            </div>
        </div>
    </aside>
    <!--    <div class="w-50 container" id="login">
            <form class="container">
                <h1 class="h3 mb-3 fw-normal">Connexion à l'espace utilisateur</h1>

                <div class="form-floating">
                    <input type="email" class="form-control" name="loginmail" placeholder="name@example.com">
                    <label for="floatingInput">Adresse mail</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" name="loginpwd" placeholder="Password">
                    <label for="floatingPassword">Mot de passe</label>
                </div>

                <button class="btn btn-primary w-100 py-2" type="submit">Connexion</button>
                <button onclick="swtichToSignin()" class="btn btn-warning w-100 py-2">Nouveau compte</button>
                <p class="mt-5 mb-3 text-body-secondary">© 2017–2024</p>
            </form>

        </div>
        <div class="w-50 container d-none" id="signin">
            <form class="container">
                <h1 class="h3 mb-3 fw-normal">Créer un compte</h1>
                <div class="form-floating">
                    <input type="email" class="form-control" id="nom" placeholder="">
                    <label for="nom">Nom</label>
                </div>
                <div class="form-floating">
                    <input type="email" class="form-control" id="prenom" placeholder="">
                    <label for="prenom">Prénom</label>
                </div>
                <div class="form-floating">
                    <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com">
                    <label for="floatingInput">Adresse mail</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="floatingPassword" placeholder="Password">
                    <label for="floatingPassword">Choisir un mot de passe</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" id="copyPass" placeholder="Password">
                    <label for="floatingPassword">Confirmer le mot de passe</label>
                </div>

                <div class="d-flex justify-content-center">
                    <button class=" w-25 btn btn-primary w-100 py-2" type="submit">Inscription</button>
                    <button onclick="swichToLogin()" class="w-25 btn btn-warning w-100 py-2">Déjà membre</button>
                </div>
                <p class="mt-5 mb-3 text-body-secondary">© 2017–2024</p>
            </form>
        </div>-->
</main>
<script type="text/javascript" src="assets/model.js"></script>
<script type="text/javascript" src="assets/chat.js"></script>
</body>

</html>
