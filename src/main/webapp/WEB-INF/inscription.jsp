<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GdocsInscription</title>
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
<body>
<nav>
    <a href="hello-servlet">Hello Servlet</a>
    <a href="editor">Editor servlet</a>
    <a href="home">Home</a>
    <a href="connexion">Connexion</a>
    <a href="inscription">Inscription</a>
</nav>
<form action="inscription" method="post">
    <h2>Inscription</h2>
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