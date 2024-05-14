<%@ page contentType="text/html;charset=UTF-8" language="java" %><head>
  <title>Gdoc-connexion</title>
  <link href="css/styles.css" rel="stylesheet">
   <style>
        body {
            margin: 0;
            padding: 0;
            font-family: sans-serif;
            background: #272727;;
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
            background: green;           
        }
        
div a:link, a:visited {
 	 background-color: #48bb44;
 	 color: white;
  	 border: 2px solid white;
 	 padding: 10px 20px;
 	 text-align: center;
	 text-decoration: none;
 	 display: inline-block;
 	 font-weight: bolder;
 	 
}

div a:hover, a:active {
  background-color: orange;
  color: white;
}

.buttonco {
  background-color: #fff;
  color: #0d172a;
  cursor: pointer;
  display: inline-block;
  font-size: 1.1rem;
  font-weight: 600;
  line-height: 1;
  padding: 1rem 1.6rem;
  text-align: center;
  text-decoration: none #0d172a solid;
  text-decoration-thickness: auto;
  transition: all .1s cubic-bezier(.4, 0, .2, 1);
  box-shadow: 0px 1px 2px rgba(166, 175, 195, 0.25);
  touch-action: manipulation;
}

.button-81:hover {
  background-color: #1e293b;
  color: #fff;
}

@media (min-width: 300px) {
  .button-81 {
    font-size: 1.125rem;
    padding: 1rem 2rem;
  }
}
    </style>
</head>
<nav>
	<a href="index.jsp">Menu</a>
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

    <div class="form-check text-start my-3">
        <input class="form-check-input" type="checkbox" value="remember-me" id="flexCheckDefault">
        <label class="form-check-label" for="flexCheckDefault">
            Se souvenir de moi
        </label>
    </div>
     <br>
    <button class="buttonco" type="submit">Connexion</button>
    <br>
    <br>
    <br>
    <div><a href="inscription">Nouveau compte</a></div>
    <p class="mt-5 mb-3 text-body-secondary">© 2017–2024</p>
</form>