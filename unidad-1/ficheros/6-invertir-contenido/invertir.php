<?php
$frase = file_get_contents("frase.txt");
$frase = strrev($frase);
file_put_contents("frase_invertida.txt",$frase);

echo file_get_contents("frase_invertida.txt")."\n";