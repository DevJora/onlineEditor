<%@ page contentType="text/html;charset=UTF-8" language="java" %><head>
  <title>Gdoc-connexion</title>
  <link href="css/styles.css" rel="stylesheet">
   <style>
        /* Ajoutez des styles supplémentaires ici si nécessaire */
        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: linear-gradient(#141e30, #243b55);
        }

        form {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 400px;
            padding: 40px;
            transform: translate(-50%, -50%);
            background: rgba(0,0,0,.5);
            box-sizing: border-box;
            box-shadow: 0 15px 25px rgba(0,0,0,.6);
            border-radius: 10px;
        }

        form h2 {
            margin: 0 0 30px;
            padding: 0;
            color: #fff;
            text-align: center;
        }

        form .user-box {
            position: relative;
        }

        form .user-box input {
            width: 100%;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            margin-bottom: 30px;
            border: none;
            border-bottom: 1px solid #fff;
            outline: none;
            background: transparent;
        }
        form .user-box label {
            position: absolute;
            top:0;
            left: 0;
            padding: 10px 0;
            font-size: 16px;
            color: #fff;
            pointer-events: none;
            transition: .5s;
        }

        form .user-box input:focus ~ label,
        form .user-box input:valid ~ label {
            top: -20px;
            left: 0;
            color: #03e9f4;
            font-size: 12px;
        }

        form input[type="submit"] {
            position: relative;
            display: inline-block;
            padding: 10px 20px;
            color: #03e9f4;
            font-size: 16px;
            text-decoration: none;
            text-transform: uppercase;
            overflow: hidden;
            transition: .5s;
            margin-top: 40px;
            letter-spacing: 4px;
        }

        form input[type="submit"]:hover {
            background: #03e9f4;
            color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 5px #03e9f4,
                        0 0 25px #03e9f4,
                        0 0 50px #03e9f4,
                        0 0 100px #03e9f4;
        }
    </style>
</head>
<nav>
    <a href="hello-servlet">Hello Servlet</a>
    <a href="editor">Editor servlet</a>
    <a href="home">Home</a>
    <a href="connexion">Connexion</a>
    <a href="inscription">Inscription</a>
</nav>
<form class="container" method="post" action="connexion">
    <h1 class="h3 mb-3 fw-normal">Connexion à l'espace utilisateur</h1>

    <div class="form-floating">
        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" required>
        <label for="floatingInput">Adresse mail</label>
        <span class="erreur">${form.erreurs['email']}</span>
    </div>
    <div class="form-floating">
        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" required>
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
    <a href="/inscription"><button class="btn btn-warning w-100 py-2" type="button">Nouveau compte</button></a>
    <p class="mt-5 mb-3 text-body-secondary">© 2017–2024</p>
</form>