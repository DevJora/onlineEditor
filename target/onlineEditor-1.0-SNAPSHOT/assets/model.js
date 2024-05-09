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

let pseudo = prompt("Entrez votre pseudo");