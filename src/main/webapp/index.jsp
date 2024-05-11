<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
<link href="css/styles.css" rel="stylesheet">
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>

<nav>
    <a href="hello-servlet">Hello Servlet</a>
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