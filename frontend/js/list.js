$(document).ready(async () => {
    await readUsers();

    removeClass();
    $(".nav-item:nth-child(2)").addClass("active");
});

const readPage = () => {
    let lista = [];

    if (userList.length > 0) {
        userList.map((row, idx) => {
            const li = `<div class="input-group mb-12 pd">
        <div class="input-group-prepend">
          <div class="input-group-text">
            <input class="check-input" onchange="checkedObjects(this)" type="checkbox" data-name="id${row.id}" data-id="${row.id}" ">
          </div>
        </div>
        <label class="form-control" for="nombre">Nombre</label>
        <input type="text" name="nombre" id="nombre${row.id}" class="form-control input${row.id}" disabled value="${row.nombre}">
        <label class="form-control" for="apellido">Apellido</label>
        <input type="text" name="apellido" id="apellido${row.id}" class="form-control input${row.id}" disabled value="${row.apellido}">
        <label class="form-control" for="procesado">Procesado</label>
        <input type="text" name="procesado" id="procesado" class="form-control" disabled value="${row.procesado}">
        <div class="input-group-append" id="button-addon4">
            <button class="btn btn-outline-warning update${row.id}" type="button" onclick="updateUser(${row.id})"> Actualizar</button>
            <button class="btn btn-outline-success saveButton save${row.id}" type="button" onclick="saveUser(${row.id})"> Guardar</button>
            <button class="btn btn-outline-danger" type = "button" onclick="deleteUser(${row.id})"> Eliminar</button>
            </div>
      </div>`;
            lista[idx] = li;
        })
        $(".page").html("<p>Selecciona las casillas para procesar los usuarios</p>");
        $(".page p").after($("<ul class='list-group'>").append(lista.join('')));
        $(".list-group").after("<button class='btn btn-success' onclick='processUser()'>Procesar</button>")
    } else {
        $(".page").html("No hay usuarios registrados");
    }

}

const updateUser = (id) => {
    $(`.save${id}`).show();
    $(`.update${id}`).hide();
    $(`.input${id}`).prop("disabled", false)
}