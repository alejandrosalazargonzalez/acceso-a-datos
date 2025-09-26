<?php
    $canciones = file("canciones.txt");
    $random = array_rand($canciones);
    echo $canciones[$random];
