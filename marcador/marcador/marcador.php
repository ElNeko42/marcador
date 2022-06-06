<?
	if(isset($_REQUEST["datos"]) ){
		include_once("conecta.php");
		if($_REQUEST["datos"] == 0)
			$sql = "SELECT equipos.nombre AS Equipo1, equipos.logo, partidas.resultado_rondas, eq2.logo, eq2.nombre AS Equipo2
					FROM partidas
					LEFT JOIN equipos
					ON partidas.id_equipo1 = equipos.id_equipo
					LEFT JOIN equipos eq2
					ON partidas.id_equipo2 = eq2.id_equipo";

		$resultado = $mysqli->query($sql)->fetch_all(MYSQLI_ASSOC);
		$devolver = json_encode($resultado);
		echo $devolver;
		die();
	}
?>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>marcador.php</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<link rel="stylesheet" href="styles.css">
	</head>
	<body>
		<div id="contenedor" class="contenedor">
			<div class="Eq1">
				<p></p>
			</div>
			<div class="Eq1Logo">
				<img>
			</div>
			<div class="Eq1Puntuacion">
				<p></p>
			</div>
			<div></div>
			<div class="Eq2Puntuacion">
				<p></p>
			</div>
			<div class="Eq2Logo">
				<img>
			</div>
			<div class="Eq2">
				<p></p>
			</div>
		</div>
		<script src="./marcador.js"></script>			
	<body>
</html>









