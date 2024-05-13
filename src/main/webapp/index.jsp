<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
  <jsp:include page="head.jsp" />
</head>
<body>
<div class="px-4 py-5 my-5 text-center">
  <img class="d-block mx-auto mb-4" src="/docs/5.3/assets/brand/bootstrap-logo.svg" alt="" width="72" height="57">
  <h1 class="display-5 fw-bold text-body-emphasis">Online Editor</h1>
  <div class="col-lg-6 mx-auto">
    <p class="lead mb-4">Quickly design and customize responsive mobile-first sites with Bootstrap, the world’s most popular front-end open source toolkit, featuring Sass variables and mixins, responsive grid system, extensive prebuilt components, and powerful JavaScript plugins.</p>
    <div class="d-grid gap-2 d-sm-flex justify-content-sm-center">
      <a href="connexion" class="btn btn-primary btn-lg px-4 gap-3">Se connecter</a>
      <a href="inscription" class="btn btn-outline-secondary btn-lg px-4">S'inscrire</a>
      <!--<a href="editor">Editor servlet </a>
      <a href="home">Home</a>
      <button type="button" class="btn btn-primary ">Primary button</button>
      <button type="button" class="btn btn-outline-secondary ">Secondary</button>-->
    </div>
  </div>
</div>
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