// tous les boutons
console.log("script doc js chargé")
const outils = document.querySelectorAll(".btn");
var nbBlocs = 0;
//event pour chaque btn
let leDoc = new Texte();
outils.forEach(element => {
    // event click sur chaque bouton
    element.addEventListener("click",()=>{
        console.log("click d'un btn outils")
        // recup des éléments mis dans le data-element
        var commande = element.dataset['element'];
        //inserer lien ou img
        if(commande == 'createLink' || commande == 'insertImage'){
            console.log("commande " + commande);
            var url = prompt('Entrez le lien', 'http://');
            document.execCommand(commande, false, url);
        }else if(commande == 'addBloc'){
            ajouterBloc();
        }else {
            document.execCommand(commande, false, null)
        }

    });
});

//détecter les changement de chaque bouton
/**
 * Ajout d'un paragraphe
 */
function ajouterBloc(){
    let idBloc = leDoc.blocs.length+1;
    let bloc = document.createElement('div');
    bloc.setAttribute("contenteditable", "true");
    bloc.id = idBloc;
    bloc.classList.add('bloc');
    let titre = document.createElement('h2');
    let contentbloc = document.createElement('div');
    contentbloc.setAttribute('contenteditable', 'true');
    titre.id = 'titre-bloc-'+idBloc;
    titre.classList.add('titre-bloc');
    titre.setAttribute("contenteditable", "true");
    titre.innerHTML = "Exemple de titre - bloc "+idBloc;
    contentbloc.innerHTML = "exemple de contenu - bloc "+idBloc;
    bloc.appendChild(titre);
    bloc.appendChild(contentbloc);
    /*bloc.addEventListener("input", function(e) {
        let blocChange = new Bloc(e.target.id, e.target.children[0].outerHTML, e.target.children[1].outerHTML)
        actualiserBloc(blocChange);
    }, false);*/

    let nouveauBloc = new Bloc(idBloc, titre.outerHTML, contentbloc.outerHTML);
    leDoc.blocs.push(nouveauBloc);
    document.getElementById('doc').appendChild(bloc);

    console.log("document changé")
}


/**
 * Actualisation du bloc changé dans le document
 * @param {Bloc} bloc
 */
function actualiserBloc(bloc){
    leDoc.blocs.forEach(element => {
        if(element.id == bloc.id) {
            element = bloc;
            console.log("bloc actualisé")
        };
    })
}

var ws;
if("WebSocket" in window){
    //
    ws = new WebSocket("ws://localhost:8080/onlineEditor_war_exploded/chat");
}


function connexionChat() {
    ws.onmessage = function (message) {
        var author = "Server";
        writeMsg(author, message.data)
    }
}
ws.onmessage = function (event) {
    var mySpan = document.getElementById("chat")
    mySpan.innerText+= event.data;
}

ws.onerror = function(event){
    console.log("Erreur ", event)
}

function sendMsg(){
    var msg = pseudo + " : "+ document.getElementById("msg").value;
    var msgToMe = document.getElementById("msg").value;
    var author = "Me";
    if(msg) ws.send(msg);
    writeMsg( author, msgToMe);
    document.getElementById("msg").value = "";
}

function writeMsg(author, msg){
    var mySpan = document.getElementById("chat")
    var divMsg = document.createElement("div");
    divMsg.classList.add("w-100", "d-flex");
    var message =  document.createElement("p");
    message.classList.add("message");
    switch (author){
        case 'Me':
            message.classList.add("me");
            divMsg.classList.add("justify-content-end");
            break;
        case 'Server':
            message.classList.add("other")
            break;
        default:
            break;
    }
    message.appendChild(document.createTextNode(msg));
    divMsg.appendChild(message)
    mySpan.appendChild(divMsg);
}


