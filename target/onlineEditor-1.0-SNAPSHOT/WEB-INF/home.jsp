<%--
  Created by IntelliJ IDEA.
  User: JoraOMVA
  Date: 22/04/2024
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<jsp:include page="../head.jsp" />
<script type="text/javascript" src="../assets/chat.js">
</script>
<style>

    main {
        display: flex;
        justify-content: center;
        align-content: center;
        height: 100vh;

    }

    header {
        height: 5rem;
        background-color: rgba(0, 0, 0, 0.81);
        margin-bottom: 2rem;
        border-radius: 15px;
    }

    div {
        &.content-landing {
            height: max-content;
            width: 60%;

        }
        &.landing {
            padding-bottom: 20px;
            /*border: solid 1px white;*/
            min-height: 500px;
            justify-content: center;
            align-content: center;
        }

        &.content-list-doc {
        }
    }

    ul{
        width: max-content;
        height: max-content;
        margin: auto;
    }

    .card-form {
        width: 40%;
        height: 200px;
    }

    .card-doc {
        min-height: 200px;
    }
</style>
<body class="bg-dark text-light">
<main>
    <div class="content-landing mt-5">
        <h2 class="text-warning">Bonjour <span>${utilisateur.pseudo}</span><img src="./assets/img/icone.png" height="20" width="20"></h2>
        <nav class="navbar navbar-expand-lg bg-warning w-100">
            <div class="container-fluid">
                <a class="navbar-brand" href="/home">OnlineEditor</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <ul class="navbar-nav">
                    <li class="">
                        <a class="nav-link active" aria-current="page" href="deconnexion">Déconnexion</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="landing bg-secondary">
            <div class="d-flex justify-content-center mt-2">
                <div class=" m-1 card p-1 d-flex justify-content-center align-item-center card-form">
                    <div>
                        <h4 class="text-center">Créer un nouveau document</h4>
                        <form class="d-flex w-75 m-auto" style="height: 30px;" action="ajoutdoc" method="post">
                            <input class="form-control me-2" type="text" name="titreDocument" placeholder="ajouter le titre" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Nouveau</button>
                        </form>
                    </div>
                </div>
                <div class=" m-1 card p-1 m-1 card p-1 d-flex justify-content-center align-item-center card-form">
                    <div>
                        <h4 class="text-center">Ajouter une collaboration</h4>
                        <form class="d-flex w-75 m-auto" style="height: 30px;" action="ajoutcollab" method="post">
                            <input class="form-control me-2" type="text" name="code" placeholder="code du document" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Ajouter</button>
                        </form>
                    </div>
                </div>
            </div>
            <br>
            <hr>
            <br>
            <div class="content-list-doc container">
                <div class="d-flex justify-content-space-arround">
                    <div class="card m-1 p-1 "  style="width: 65%;">
                        <div class="list-group " id="list-tab" role="tablist">
                            <h4 class="text-center">Mes documents</h4>
                            <c:if test="documents.size() == 0">
                                <p class="font-weight-bold">Vous n'avez aucun document.</p>
                            </c:if>
                            <c:forEach var="document" items="${documents}">
                                <div class="d-flex" >
                                    <a class="list-group-item list-group-item-action" id="list-home-list" data-bs-toggle="list" href="editor?id=${document.id}" role="tab" aria-controls="list-home">${document.titre}</a>
                                    <a class="list-group-item list-group-item-action bg-danger" style="width: 30%; height: 40px;"  href="supprimerdoc?id=${document.id}" role="tab">Supprimer</a>
                                    <span class="list-group-item list-group-item-action bg-warning" style="width: 30%; height: 40px;"   role="tab">${document.code_collab}</span>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="card m-1 p-1" style="width: 35%; min-height: 200px">
                        <div class="list-group " id="list-tab2" role="tablist">
                            <h4 class="text-center">Mes Collaborations</h4>
                            <c:if test="documents.size() == 0">
                                <p class="font-weight-bold">Vous n'avez aucun document en collab.</p>
                            </c:if>
                            <c:forEach var="docCollab" items="${documentsCollab}">
                                <div class="d-flex" >
                                    <a class="list-group-item list-group-item-action" id="list-home-list2" data-bs-toggle="list" href="editor?id=${docCollab.id}" role="tab" aria-controls="list-home">${docCollab.titre}</a>
                                </div>
                            </c:forEach>
                        </div>
                    </div>
                    <!--<div class="col-8">
                        <div class="tab-content" id="nav-tabContent">

                            <c:forEach var="document" items="${documents}">
                                <div class="tab-pane fade show active" id="contenu-${document.id}" role="tabpanel" aria-labelledby="list-home-list">${document.contenu}</div>
                            </c:forEach>
                        </div>-->
                    </div>
                </div>
            </div>
        </div>
    </div>
     <!--<nav aria-label="...">
     <ul class="pagination">
         <li class="page-item disabled">
             <a class="page-link">Previous</a>
         </li>
         <li class="page-item"><a class="page-link" href="#">1</a></li>
         <li class="page-item active" aria-current="page">
             <a class="page-link" href="#">2</a>
         </li>
         <li class="page-item"><a class="page-link" href="#">3</a></li>
         <li class="page-item">
             <a class="page-link" href="#">Next</a>
         </li>
     </ul>
 </nav>-->
</main>

</body>
</html>
