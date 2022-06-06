var refresco;

trae_datos();

refresco=setInterval("trae_datos()", 3000);

function trae_datos(){
    $.post("marcador.php", {datos: 0}, function(datos){
        resultado = JSON.parse(datos);

        // Puntos primer equipo
        var eq1_puntos = resultado[0].resultado_rondas.substr(0, 2);
        // Puntos segundo equipo
        var eq2_puntos = resultado[0].resultado_rondas.substr(4, 6);

        $("#contenedor").show();

        // Equipo1 opciones
        $(".Eq1 p").text(resultado[0].Equipo1);
        $(".Eq1Logo img").attr("src", "./imgs/avangar.png");
        $(".Eq1Puntuacion p").text(eq1_puntos);

        // Equipo2 opciones
        $(".Eq2").text(resultado[0].Equipo2);
        $(".Eq2Logo img").attr("src","./imgs/astralis.png");
        $(".Eq2Puntuacion p").text(eq2_puntos);

    });
}