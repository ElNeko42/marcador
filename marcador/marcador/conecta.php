<?
    $mysqli = new mysqli("localhost", "root", "", "proyecto_ev3");

    if ($mysqli->connect_errno) {
        echo "Fallo al conectar a MySQL: (" . $mysqli->connect_errno . ") " . $mysqli->connect_error;
    }

?>