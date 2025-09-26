<?php
$file = fopen("comidas.txt", "a");
$comida = readline("que comida te gusta? ");
fwrite($file, $comida . "\n");
fclose($file);

$file = fopen("comidas.txt", "r");
$ranking = array();

while ($linea = fgets($file)) {
    $comida = trim($linea);
    if (isset($ranking[$comida])) {
        $ranking[$comida] += 1;
    } else {
        $ranking[$comida] = 1;
    }
}
fclose($file);

arsort($ranking);

echo "Ranking de comidas:\n";
foreach ($ranking as $comida => $veces) {
    echo "$comida: $veces\n";
}
