<?php

$numeros = explode(",",file_get_contents("datos_numericos.txt"));
echo array_sum($numeros)."\n";