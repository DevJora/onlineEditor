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

        background-color: lightgrey;
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
        }
        &.landing {
            background-color: white;
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
</style>
<body>
<main>
    <div class="content-landing">
        <h2>Bonjour <span>${utilisateur.pseudo}</span></h2>
        <nav class="navbar navbar-expand-lg bg-body-tertiary w-100">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">OnlineEditor</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="deconnexion">Déconnexion</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                Dropdown
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="#">Action</a></li>
                                <li><a class="dropdown-item" href="#">Another action</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="#">Something else here</a></li>
                            </ul>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link disabled" aria-disabled="true">Disabled</a>
                        </li>
                    </ul>
                    <form class="d-flex" role="search">
                        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Search</button>
                    </form>
                </div>
            </div>
        </nav>
        <div class="landing =">
            <div class="d-flex">
                <div class="w-50 m-1 card p-1">
                    <h4 class="text-center">Créer un nouveau document</h4>
                    <form class="d-flex w-75 m-auto" style="height: 30px;" action="ajoutdoc" method="post">
                        <input class="form-control me-2" type="text" name="titreDocument" placeholder="ajouter le titre" aria-label="Search">
                        <button class="btn btn-outline-success" type="submit">Nouveau</button>
                    </form>
                </div>
                <div class="w-50 m-1 card p-1">
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
                    <div class="card m-1 p-1" style="width: 65%;">
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
                    <div class="card m-1 p-1" style="width: 35%;">
                        <div class="list-group " id="list-tab2" role="tablist">
                            <h4 class="text-center">Mes Collaboration</h4>
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
