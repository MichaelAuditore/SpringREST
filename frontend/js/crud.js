let nombre;
let apellido;

$(document).ready(() => {
    nombre = $("#nombre");
    apellido = $("#apellido");
});


let userList = [];

const URL = "http://localhost:8080/";
const REQUEST = {
    method: '',
    headers: { "Content-Type": "application/json", "Access-Control-Allow-Origin": "*" },
    mode: 'cors',
    crossDomain: true,
    cache: 'default',
}

const createUser = async () => {
    const name = nombre.val().trim();
    const lastName = apellido.val().trim();
    REQUEST.method = "POST";
    REQUEST.body = JSON.stringify({ "nombre": name, "apellido": lastName });
    if (nombre.val() !== "" || apellido.val() !== "") {
        await fetch(`${URL}users`, REQUEST)
            .then(res => res.json())
            .then(() => { $("input").val(""); $(".msg-succeed").show(); $(".msg-unsucceed").hide() })
            .catch(() => { $(".msg-unsucceed").show(); $(".msg-succeed").hide() });
    }
    else {
        $(".msg-unsucceed").show()
    }
}

const saveUser = async (id) => {
    const name = $(`#nombre${id}`).val().trim();
    const lastName = $(`#apellido${id}`).val().trim();
    REQUEST.method = "PUT";
    REQUEST.body = JSON.stringify({ nombre: name, apellido: lastName });
    await fetch(`${URL}update/${id}`, REQUEST);
    setTimeout(() => {
        readUsers();
    }, 200);
}

const readUsers = async () => {
    REQUEST.method = "GET";
    delete REQUEST["body"];
    await fetch(`${URL}users`, REQUEST)
        .then(res => res.json())
        .then(users => { userList = users; })
        .catch(err => console.error(err));
    readPage();
}

const deleteUser = async (id) => {
    REQUEST.method = "DELETE";
    await fetch(`${URL}users/${id}`, REQUEST);
    setTimeout(() => {
        readUsers();
    }, 200);
}

const processUser = () => {
    REQUEST.method = "PUT";
    REQUEST.body = JSON.stringify({ procesado: true });
    processedIds.map(async (id) => {
        await fetch(`${URL}update/${id}`, REQUEST)
    });
    setTimeout(() => {
        readUsers();
    }, 200);

}