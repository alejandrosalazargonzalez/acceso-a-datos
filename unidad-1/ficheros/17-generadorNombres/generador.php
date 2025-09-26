<?php
$adjetivos = file("adjetivos.txt");
$animales = file("animales.txt");

$adj = $adjetivos[array_rand($adjetivos)];
$animal = $animales[array_rand($animales)];

$combinacion = trim($adj) . " " . trim($animal);
echo "$combinacion\n";
