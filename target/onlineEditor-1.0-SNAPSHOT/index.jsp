<!DOCTYPE html>
<html>
<<<<<<< Updated upstream
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
=======
<jsp:include page="head.jsp" />

<body onload="connexionChat();">
<a href="hello-servlet">Hello Servlet</a>
<a href="editor">Editor servlet </a>
<a href="home">Home</a>

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
>>>>>>> Stashed changes
</body>
</html>