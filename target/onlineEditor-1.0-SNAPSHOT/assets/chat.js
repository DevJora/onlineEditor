var ws;
var pseudo = prompt("Entrez votre pseudo.")
if("WebSocket" in window){
    ws = new WebSocket("ws://localhost:8080/onlineEditor_war_exploded/acces");
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