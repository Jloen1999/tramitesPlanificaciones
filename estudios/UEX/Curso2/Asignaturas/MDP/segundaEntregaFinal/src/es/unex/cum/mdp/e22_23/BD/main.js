async function cargarDatos(){
    const response = await fetch('http://localhost:63342/segundaEntregaFinal/es/unex/cum/mdp/e22_23/BD/datosPersona.json')
    const datos = await response.json()
    $('#tabla').append('<tr class="row fila"><td class="col-auto columna">NOMBRE</td>' +
        '<td class="col columna">ID</td>' +
        '<td class="col columna">EDAD</td></tr>')

    for (let i = 0; i < datos.Persona.length; i++) {
        $('#tabla').append('<tr class="row fila">'+
            '<td class="col columna" >'+datos.Persona[i].nombre+'</td>' +
            '<td class="col columna">'+datos.Persona[i].id+'</td>' +
            '<td class="col columna">'+datos.Persona[i].edad+'</td></tr>')
    }
}
cargarDatos()

