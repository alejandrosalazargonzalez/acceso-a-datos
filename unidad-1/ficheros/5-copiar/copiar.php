<?php

echo file_get_contents("original.txt")."\n";
$datos = copy("original.txt", "copia.txt");
echo file_get_contents("copia.txt")."\n";
