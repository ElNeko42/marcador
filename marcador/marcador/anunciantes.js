$("#slideshow > div:gt(0)").hide();

var refresco;

trae_datos();

refresco=setInterval("trae_datos()", 3000);

function trae_datos(){
    $.post("anunciantes.php", {datos: 0}, function(datos){
        resultado = JSON.parse(datos);
        var imgs = ["img1", "img2", "img3", "img4", "img5"];

        $("#slideshow").show();

        for (let i = 0; i < resultado.length; i++) {
            $("#" + imgs[i]).attr("src", "./imgs/" + resultado[i].logo);
        }
    });
}

setInterval(function() { 
  $('#slideshow > div:first')
  .fadeOut(1000)
  .next()
  .fadeIn(1000)
  .end()
  .appendTo('#slideshow');
}, 4000);