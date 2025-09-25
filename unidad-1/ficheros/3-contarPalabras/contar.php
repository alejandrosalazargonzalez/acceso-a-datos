<?php
$palabras = file_get_contents("texto.txt");
echo $palabras."\n";
echo str_word_count($palabras)."\n";
