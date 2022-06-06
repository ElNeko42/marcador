var refresco;

trae_datos();

refresco=setInterval("trae_datos()", 1000);

function trae_datos(){
    $.post("jugadores.php", {datos: 0}, function(datos){
        resultado = JSON.parse(datos);
         
        $("#contenedor").show();

        // 5 es por el equipo de la drcha que es azul
        if (resultado[0].id_equipo == 5) {
            $("#contenedor").css("background-color", "#326fa2"); // azul
        } else {
            $("#contenedor").css("background-color", "#9e8140"); // amarillo
        }

        // Jugador estadisticas
        $("#nombreJugador p").text(resultado[0].aka);
        $("#adrJugador p").text(resultado[0].adr);
        $("#kJugador p").text(resultado[0].k);
        $("#aJugador p").text(resultado[0].a);
        $("#dJugador p").text(resultado[0].d);

    });
}