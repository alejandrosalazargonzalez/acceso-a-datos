<?php

$file = file("ranking.txt");

$ranking = [];

foreach ($file as $linea) {
    list($juego, $puntos) = explode(":", $linea);
    $ranking[$juego] = (int)$puntos;
}

arsort($ranking);

$contador = 0;
foreach ($ranking as $juego => $puntos) {
    echo "$juego: $puntos\n";
    $contador++;
    if ($contador == 3){
        break;
    }
}

