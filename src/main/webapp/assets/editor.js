// tous les boutons
console.log("script editor js chargé")


const outils = document.querySelectorAll(".btn");
var nbBlocs = 0;
//event pour chaque btn
let leDoc = new Texte();
let doc = document.querySelector('#doc');
outils.forEach(element => {
    // event click sur chaque bouton
    element.addEventListener("click",()=>{
        // recup des éléments mis dans le data-element
        var commande = element.dataset['element'];
        //inserer lien ou img
        if(commande == 'createLink' || commande == 'insertImage'){
            var url = prompt('Entrez le lien', 'http://');
            document.execCommand(commande, false, url);
        }else if(commande == 'addBloc'){
            ajouterBloc();
        }else {
            document.execCommand(commande, false, null)
        }

    });
});

var ws;
if("WebSocket" in window){
    //
    ws = new WebSocket(`ws://localhost:8080/onlineEditor_war_exploded/editor?id_document=${id_Document}&&id_user=${id_user}`);
}

function getCookie(name) {
    var cookieValue = null;
    if(document.cookie && document.cookie !== ''){
        var cookies = document.cookie.split(';');
        for(var i = 0; i < cookies.length; i++){
            var cookie = cookie[i].trim();
            if(cookie.substring(0, name.length+1)=== (name)+"="){
                decodeURIComponent(cookie.substring(name.length + 1))
                break;
            }
        }
    }

    return cookieValue;
}
function connexionChat() {
    ws.onmessage = function (message) {
        var author = "Server";
        writeMsg(author, message.data)
    }
}
ws.onmessage = function (event) {
    if(event.data.includes("C:-")) {
        let contenu = event.data.substr(3);
        writeMsg("Other", contenu);
    }else if(event.data.includes("D:-")){
        let contenu = event.data.substr(3);
        doc.innerHTML = contenu;
    }

}

ws.onerror = function(event){
    console.log("Erreur ", event)
}

function actualiserDocument(){
    let doc = document.querySelector('#doc');
    console.log(doc);
}

function sendMsg(){
    var msg = pseudo + " : "+ document.getElementById("msg").value;
    var msgToMe = document.getElementById("msg").value;
    var author = "Me";
    if(msg) ws.send("C:-"+msg);
    writeMsg( author, msgToMe);
    document.getElementById("msg").value = "";
}

function writeMsg(author, msg){
    var mySpan = document.getElementById("chat");
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
            break;
        case 'Other':
            message.classList.add("other")
            break;
        default:
            break;
    }
    message.appendChild(document.createTextNode(msg));
    divMsg.appendChild(message)
    mySpan.appendChild(divMsg);
}


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
    let btn_delete = document.createElement('button');
    btn_delete.classList.add('btn', 'delete-element');
    btn_delete.innerHTML = '<span class="material-symbols-outlined">delete\n</span>';
    contentbloc.setAttribute('contenteditable', 'true');
    bloc.appendChild(btn_delete);
    titre.id = 'titre-bloc-'+idBloc;
    titre.classList.add('titre-bloc');
    titre.setAttribute("contenteditable", "true");
    titre.innerText = "Exemple de titre - bloc "+idBloc;
    contentbloc.innerText = "exemple de contenu - bloc "+idBloc;
    bloc.appendChild(titre);
    bloc.appendChild(contentbloc);
    /*bloc.addEventListener("input", function(e) {
        let blocChange = new Bloc(e.target.id, e.target.children[1].outerHTML, e.target.children[2].outerHTML)
        //actualiserBloc(blocChange);
    }, false);*/
    btn_delete.addEventListener("click", function (e){
        let blocChange = new Bloc(((e.target.parentElement).parentElement).id, ((e.target.parentElement).parentElement).children[1].outerHTML, ((e.target.parentElement).parentElement).children[2].outerHTML)
        suppBloc(blocChange);
        document.getElementById('doc').removeChild(bloc);
        console.log("document changé")
    })

    let nouveauBloc = new Bloc(idBloc, titre.outerHTML, contentbloc.outerHTML);
    leDoc.blocs.push(nouveauBloc);
    document.getElementById('doc').appendChild(bloc);
    /*
        <button type="button" class="btn delete-element">
        <span class="material-symbols-outlined">
            delete
        </span>
    </button>
    * */

}

/**
 *
 * @param{Bloc} bloc
 */
function  suppBloc(bloc){
    leDoc.blocs.forEach(element => {
        if(element.id == bloc.id) {
            leDoc.blocs.splice(leDoc.blocs.indexOf(element));
        };
    })

    console.log("document changé");
}



document.querySelector("#doc").addEventListener("input", function(e) {
    ws.send("D:-"+doc.innerHTML);
})
document.querySelector("#doc").addEventListener("change", function(e) {
    ws.send("D:-"+doc.innerHTML);
})

