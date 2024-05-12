<!DOCTYPE html>
<html>
<head>
  <title>Gdoc</title>
  <link href="css/menus.css" rel="stylesheet">
</head>
<body>
<h1><%= "Document Online" %></h1>
<br/>


<nav class="cmenu">
	<a href="index.jsp">Menu</a>
    <a href="hello-servlet">Chat</a>
    <a href="editor">Editor servlet</a>
    <a href="home">Home</a>
    <a href="connexion">Connexion</a>
    <a href="inscription">Inscription</a>
</nav>
<body onload="connexionChat();">



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