const tablaNotebooksHTML = document.getElementById('tablaNotebooks')
const brand =  document.getElementById('brand')
const model =  document.getElementById('model')
const processor =  document.getElementById('processor')
const ram = document.getElementById('ram')
const storage =  document.getElementById('storage')
const gpu =  document.getElementById('gpu')
const price =  document.getElementById('price')
const btnGuardar =  document.getElementById('btnGuardar')
let tituloModal = document.getElementById('tituloModal')
let idNotebookModificar = 0


btnGuardar.addEventListener('click',()=>{
    if(tituloModal.innerText === "Modificar Notebook"){
        actualizarNotebook(idNotebookModificar)
    }
    else if(tituloModal.innerText === "Crear Notebook"){
        crearNotebook(0)
    }
})

async function eliminarNotebook(id){
    await fetch('http://localhost:9090/api/notebook/'+id,{
        method: 'DELETE',
        mode: 'cors', 
        headers: {
          'Content-Type': 'application/json'
        },
      })
      .then((res)=>{
        // console.log(res);
        alert("Notebook eliminada")
        obtenerNotebooks()
      })
      .catch((err)=>{
        // console.log(err);
        alert("Lo sentimos, no pudimos eliminar la notebook")
      })
}


function modificarNotebook(id){
    tituloModal.innerText = "Modificar Notebook"
    modal.style.display = "block";
    idNotebookModificar = id
    resetModal()
    let notebook = listaNotebooks.filter(notebook => notebook.id === id)
    // console.log(notebook[0]);
    brand.value = notebook[0].brand
    model.value = notebook[0].model
    processor.value = notebook[0].processor
    ram.value = notebook[0].ram
    storage.value = notebook[0].storage
    gpu.value = notebook[0].gpu
    price.value = notebook[0].price
}

async function actualizarNotebook(id){
    if (brand.value === "" || model.value === "" || processor.value === "" || 
        isNaN(parseInt(ram.value)) || storage.value === "" || gpu.value === "" || 
        isNaN(parseFloat(price.value))) {
        alert("Por favor, completa todos los campos correctamente.");
        return;
    }

    let notebookActualizar = {
        id: id,
        brand: brand.value,
        model: model.value,
        processor: processor.value,
        ram: parseInt(ram.value),
        storage: storage.value,
        gpu: gpu.value,
        price: parseFloat(price.value)
    }
    console.log(notebookActualizar);

    await fetch(`http://localhost:9090/api/notebook/${id}`, {
        method: 'PATCH',
        mode: 'cors', 
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(notebookActualizar) 
      })
      .then(response => response.json()) 
      .then((notebook)=>{
        console.log(notebook);
        alert("Notebook actualizada")
        modal.style.display = "none";
        obtenerNotebooks()
        resetModal()
      })
      .catch((err)=>{
        // console.log(err);
        alert("Lo sentimos, no pudimos actualizar la notebook")
      })
}


async function crearNotebook(id){
    if (brand.value === "" || model.value === "" || processor.value === "" || 
        isNaN(parseInt(ram.value)) || storage.value === "" || gpu.value === "" || 
        isNaN(parseFloat(price.value))) {
        alert("Por favor, completa todos los campos correctamente.");
        return;
    }

    let notebookGuardar = {
        id: id,
        brand: brand.value,
        model: model.value,
        processor: processor.value,
        ram: parseInt(ram.value),
        storage: storage.value,
        gpu: gpu.value,
        price: parseFloat(price.value)
    }
    // console.log(notebookGuardar);

    await fetch('http://localhost:9090/api/notebook',{
        method: 'POST',
        mode: 'cors', 
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(notebookGuardar) 
      })
      .then((notebook)=>{
        console.log(notebook);
        alert("Notebook guardada")
        modal.style.display = "none";
        obtenerNotebooks()
        resetModal()
      })
      .catch((err)=>{
        // console.log(err);
        alert("Lo sentimos, no pudimos crear la notebook")
      })
}

//Consumo API
let listaNotebooks = []
async function obtenerNotebooks(){
    tablaNotebooksHTML.innerHTML = ''
    await fetch('http://localhost:9090/api/notebook')
        .then(response =>  response.json())
        .then(notebooks => {
            // console.log(notebooks)
            listaNotebooks = notebooks
            for(let notebook of notebooks){
                tablaNotebooksHTML.innerHTML +=
                '<tr>'+
                '    <th scope="row">'+notebook.id+'</th>'+
                '    <td>'+notebook.brand+'</td>'+
                '    <td>'+notebook.model+'</td>'+
                '    <td>'+notebook.processor+'</td>'+
                '    <td>'+notebook.ram+'</td>'+
                '    <td>'+notebook.storage+'</td>'+
                '    <td>'+notebook.gpu+'</td>'+
                '    <td>'+notebook.price+'</td>'+
                '    <td>'+
                '        <input type="button" class="btn btn-outline-danger" value="Eliminar" onclick=eliminarNotebook('+notebook.id+')>'+
                '        <input type="button" class="btn btn-primary" value="Modificar" onclick=modificarNotebook('+notebook.id+')>'+
                '    </td>'+
                '</tr>'
            }
        })
        .catch((err)=>{
            // console.log(err);
            alert("Lo sentimos, no pudimos obtener las notebooks")
        })
}
obtenerNotebooks()

//Reset Modal
function resetModal(){
    brand.value = ""
    model.value = ""
    processor.value = ""
    ram.value = ""
    storage.value = ""
    gpu.value = ""
    price.value = ""
}

//Modal 
var modal = document.getElementById("myModal");
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("close")[0];

btn.onclick = function() {
    tituloModal.innerText = "Crear Notebook"
    modal.style.display = "block";
}
span.onclick = function() {
  modal.style.display = "none";
  resetModal()
}
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
    resetModal()
  }
}

document.addEventListener('keydown', function(event) {
    if (event.key === 'Enter') {
        event.preventDefault(); 

        document.getElementById('btnGuardar').click();
    }
});