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
            height: 300px;
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
        <h2>Bienvenu(e) <span>pseudo</span></h2>
        <nav class="navbar navbar-expand-lg bg-body-tertiary w-100">
            <div class="container-fluid">
                <a class="navbar-brand" href="#">Navbar</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" aria-current="page" href="#">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Link</a>
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
        <div class="landing">
            <div class="content-list-doc container">
                <div class="row">
                    <div class="col-4">
                        <div class="list-group" id="list-tab" role="tablist">
                            <a class="list-group-item list-group-item-action active" id="list-home-list" data-bs-toggle="list" href="#list-home" role="tab" aria-controls="list-home">Document 1</a>
                            <a class="list-group-item list-group-item-action" id="list-profile-list" data-bs-toggle="list" href="#list-profile" role="tab" aria-controls="list-profile">Document 2</a>
                            <a class="list-group-item list-group-item-action" id="list-messages-list" data-bs-toggle="list" href="#list-messages" role="tab" aria-controls="list-messages">Document 3</a>
                            <a class="list-group-item list-group-item-action" id="list-settings-list" data-bs-toggle="list" href="#list-settings" role="tab" aria-controls="list-settings">Document 4</a>
                        </div>
                    </div>
                    <div class="col-8">
                        <div class="tab-content" id="nav-tabContent">
                            <div class="tab-pane fade show active" id="list-home" role="tabpanel" aria-labelledby="list-home-list">...</div>
                            <div class="tab-pane fade" id="list-profile" role="tabpanel" aria-labelledby="list-profile-list">...</div>
                            <div class="tab-pane fade" id="list-messages" role="tabpanel" aria-labelledby="list-messages-list">...</div>
                            <div class="tab-pane fade" id="list-settings" role="tabpanel" aria-labelledby="list-settings-list">...</div>
                        </div>
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
