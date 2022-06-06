<?
	if(isset($_REQUEST["datos"]) ){
		include_once("conecta.php");
        $myfile = fopen("idJugador.txt", "r") or die("Unable to open file!");

		if($_REQUEST["datos"] == 0)
			$sql = fread($myfile,filesize("idJugador.txt"));

		$resultado = $mysqli->query($sql)->fetch_all(MYSQLI_ASSOC);
		$devolver = json_encode($resultado);
		echo $devolver;
		die();
        fclose($myfile);
	}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <link rel="stylesheet" href="styles3.css">
    <title>jugadores.php</title>
</head>
<body>
    <div id="contenedor">
        <div id="nombreJugador">
            <p></p>
        </div>
        <div id="adrJugador">
            <p></p>
        </div>
        <div id="kJugador">
            <p></p>
        </div>
        <div id="aJugador">
            <p></p>
        </div>
        <div id="dJugador">
            <p></p>
        </div>
    </div>
    <script src="./jugadores.js"></script>			
</body>
</html>