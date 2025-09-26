<?php
    $file = fopen("tabla5.txt","w");
    for ($i=0; $i <= 10 ; $i++) {
        $resultado = 5 * $i;
        $calculo = "5 x $i = $resultado\n";
        fwrite($file,$calculo);
    }
    fclose($file);
    echo file_get_contents("tabla5.txt");
