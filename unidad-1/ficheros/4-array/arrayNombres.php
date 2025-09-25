<?php
    $fichero = fopen("nombres.txt", "w");
    $nombres = ["Jhosef","Adolfo","Nicolas","Ana","Maria","Luisa","Marcos"];
    for ($i=0; $i < sizeof($nombres); $i++) {
        fwrite($fichero, $nombres[$i]."\n");
    }
    fclose($fichero);
    $fichero = fopen("nombres.txt", "r");
    echo fread($fichero, filesize("nombres.txt"));
