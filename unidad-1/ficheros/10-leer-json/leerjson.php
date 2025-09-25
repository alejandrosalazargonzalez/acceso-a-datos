<?php

$contenido = file_get_contents("datos.json");
$salida = json_decode($contenido);
foreach ($salida as $nombre => $value) {
    echo $value -> nombre."\n";
}
