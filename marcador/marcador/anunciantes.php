<?
	if(isset($_REQUEST["datos"]) ){
		include_once("conecta.php");
		if($_REQUEST["datos"] == 0)
			$sql = "SELECT logo FROM `anunciantes` WHERE id_anunciante = 4 OR id_anunciante = 19 OR id_anunciante = 20 OR id_anunciante = 21 OR id_anunciante = 22 ORDER BY precio DESC";

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
		<title>anunciantes.php</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	    <link rel="stylesheet" href="styles2.css">
	</head>
	<body>
        <div id="slideshow">
            <div>
                <img id="img1">
            </div>
            <div>
                <img id="img2">
            </div>
            <div>
                <img id="img3">
            </div>
            <div>
                <img id="img4">
            </div>
			<div>
                <img id="img5">
            </div>
        </div>
		<script src="./anunciantes.js"></script>			
	<body>
</html>









