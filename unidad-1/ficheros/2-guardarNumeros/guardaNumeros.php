<?php
$archivo = fopen("numeros.txt", "w");
for ($i=1; $i <= 10; $i++) {
    fwrite($archivo,$i."\n");
}
fclose($archivo);
$archivo = fopen("numeros.txt", "r");
echo fread($archivo,filesize("numeros.txt"));
fclose($archivo);
