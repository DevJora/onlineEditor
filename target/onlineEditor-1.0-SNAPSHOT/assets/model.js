//  tous les cookies associés au document
var cookies = document.cookie;

// affichage
console.log(cookies);



class Texte {
    id;
    blocs = [];
    constructor(title){
        this.title = title;
    }
}

class Bloc {
    constructor(id, title, content){
        this.id = id;
        this.title = title;
        this.content = content;
    }
}


function getCookieValue(nom_cookie) {
    var cookies = document.cookie.split("; ");
    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i].split("=");
        if (cookie[0] === nom_cookie) {
            return decodeURIComponent(cookie[1]);
        }
    }
    return null;
}

var id_Document = getCookieValue("id_document");
var id_user = getCookieValue("id");
let pseudo = getCookieValue("pseudo");