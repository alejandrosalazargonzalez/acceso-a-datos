<?php
    $file = fopen("usuarios.txt","w");
    do{
        $nombre = readline("¿quien ha entrado? Si no hay nadie no respondas ");
        if (!empty($nombre) || !is_null($nombre)) {
            fwrite($file, $nombre."\n");
        }
    }while ($nombre);
    echo implode(file("usuarios.txt"));
    fclose($file);
