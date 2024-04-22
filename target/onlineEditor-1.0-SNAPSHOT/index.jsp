<!DOCTYPE html>
<html>
<jsp:include page="head.jsp" />
<script type="text/javascript" src="assets/chat.js">

</script>
<body onload="connexionChat();">
<main class="">
    <article></article>
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
<br/>
<a href="hello-servlet">Hello Servlet</a>

<script>
    const loginSection = document.querySelector("#login");
    const signinSection  = document.querySelector("#signin");
    function swtichToSignin(){
        console.log("nouveau")
        //loginSection.style.display = 'none';
        //signinSection.style.display ='block';
    }

    function swichToLogin(){
        console.log("déja membre")
        loginSection.style.display = 'block';
            signinSection.style.display = 'none';
    }
</script>
</body>

</html>