<?php
    $file = fopen("diario.txt", "a");
    do{
        $datetime = date_format(date_create(), "Y-m-d H:i");
        $entrada = readline("¿que hiciste hoy? Si no hiciste nada no respondas ");
        if (strlen($entrada) > 0) {
            fwrite($file, "[$datetime] $entrada\n");
        }
    }while ($entrada);
    echo implode(file("diario.txt"));
    fclose($file);
